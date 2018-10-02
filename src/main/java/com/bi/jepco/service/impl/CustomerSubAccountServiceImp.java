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

      CustomerProfile customerProfile = customerProfileDao.find(customerSubAccount.getNationalNumber());
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
   public CustomerSubAccount update(CustomerSubAccount customerSubAccount) {
      return customerSubAccountDao.update(customerSubAccount);
   }

   @Override
   public void delete(CustomerSubAccount customerSubAccount) {
//      CustomerSubAccount customerSubAccount = customerSubAccountDao.find(customerSubAccountId);
//      CustomerSubAccount customerSubAccount = null;

      if(customerSubAccount == null){
         throw new ResourceException(HttpStatus.NOT_FOUND, "sub_account_not_found");
      }

      customerSubAccountDao.delete(customerSubAccount);
   }
}
