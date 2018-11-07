package com.bi.jepco.service.impl;

import com.bi.jepco.dao.BillmfDao;
import com.bi.jepco.dao.CustomerProfileDao;
import com.bi.jepco.dao.CustomerSubAccountDao;
import com.bi.jepco.entities.Billmf;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.entities.CustomerSubInfoPK;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.CustomerSubAccountService;
import com.bi.jepco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
public class CustomerSubAccountServiceImp implements CustomerSubAccountService {

   @Autowired
   private CustomerSubAccountDao customerSubAccountDao;

   @Autowired
   private CustomerProfileDao customerProfileDao;

   @Autowired
   private BillmfDao billmfDao;


   @Override
   public CustomerSubAccount create(CustomerSubAccount customerSubAccount) {

      CustomerProfile customerProfile = customerProfileDao.find(customerSubAccount.getMobileNumber());
      if(customerProfile == null){
         throw new ResourceException(HttpStatus.NOT_FOUND, "profile_not_found");
      }

      if(customerSubAccountDao.find(customerProfile,customerSubAccount.getFileNumber()) != null) {
         throw new ResourceException(HttpStatus.FOUND, "file_number_found");
      }

      CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();

      customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);

      Utils.initFileNumberTokens(customerSubAccount);

      Billmf billmf = billmfDao.find(customerSubAccount);

      if(billmf == null){
         throw new ResourceException(HttpStatus.NOT_FOUND,"file_number_not_found");
      }

      customerSubAccount.getCustomerSubInfoPK().setCustomerProfile(customerProfile);

      customerSubAccount.setCreationDate(LocalDateTime.now());

      return customerSubAccountDao.create(customerSubAccount);
   }

   @Override
   public List<CustomerSubAccount> find(CustomerProfile customerProfile) {
      return customerSubAccountDao.find(customerProfile);
   }

   @Override
   public List<CustomerSubAccount> find(String fileNumber) {
      return customerSubAccountDao.find(fileNumber);
   }

   @Override
   public CustomerSubAccount update(String oldFileNumber ,CustomerSubAccount customerSubAccount) {

      CustomerProfile customerProfile = customerProfileDao.find(customerSubAccount.getMobileNumber());

      if(customerProfile == null){
         throw new ResourceException(HttpStatus.NOT_FOUND,"profile_not_found");
      }

      CustomerSubAccount currentCustomerSubAccount = customerSubAccountDao.find(customerProfile, oldFileNumber);

      if(currentCustomerSubAccount == null){
         throw new ResourceException(HttpStatus.NOT_FOUND,"sub_account_not_found");
      }

      customerSubAccountDao.delete(currentCustomerSubAccount);

      CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();
      customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);

      Utils.initFileNumberTokens(customerSubAccount);

      customerSubAccount.getCustomerSubInfoPK().setCustomerProfile(customerProfile);

      Billmf billmf = billmfDao.find(customerSubAccount);

      if(billmf == null){
         throw new ResourceException(HttpStatus.NOT_FOUND,"file_not_found");
      }

      return customerSubAccountDao.create(customerSubAccount);

//      currentCustomerSubAccount.setAlias(customerSubAccount.getAlias());
//      currentCustomerSubAccount.setFileNumber(customerSubAccount.getFileNumber());
//
//      currentCustomerSubAccount.getCustomerSubInfoPK().setCity(Integer.parseInt(customerSubAccount.getFileNumber().substring(0,2)));
//      currentCustomerSubAccount.getCustomerSubInfoPK().setRound(Integer.parseInt(customerSubAccount.getFileNumber().substring(2 , 3)));
//      currentCustomerSubAccount.getCustomerSubInfoPK().setDept(Integer.parseInt(customerSubAccount.getFileNumber().substring(3,5)));
//      currentCustomerSubAccount.getCustomerSubInfoPK().setColl(Integer.parseInt(customerSubAccount.getFileNumber().substring(5 , 7)));
//      currentCustomerSubAccount.getCustomerSubInfoPK().setCons(Integer.parseInt(customerSubAccount.getFileNumber().substring( 7)));

//      return currentCustomerSubAccount;
   }

   @Override
   public void delete(CustomerProfile customerProfile,String customerSubAccountFileNumber) {

      CustomerSubAccount customerSubAccount = customerSubAccountDao.find(customerProfile, customerSubAccountFileNumber);

      if(customerSubAccount == null){
         throw new ResourceException(HttpStatus.NOT_FOUND,"sub_account_not_found");
      }

      CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();
      customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);

      Utils.initFileNumberTokens(customerSubAccount);

      customerSubAccount.getCustomerSubInfoPK().setCustomerProfile(customerProfile);

       customerSubAccountDao.delete(customerSubAccount);
   }
}
