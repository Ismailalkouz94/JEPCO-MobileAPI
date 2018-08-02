package com.bi.jepco.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.bi.jepco.dao.CustomerSubAccountDao;
import com.bi.jepco.dao.SmsVerificationDao;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.entities.SmsVerification;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bi.jepco.dao.CustomerProfileDao;
import com.bi.jepco.service.CustomerProfileService;


@Service
@Transactional
public class CustomerProfileServiceImp implements CustomerProfileService {

   @Autowired
   private CustomerProfileDao customerProfileDao;

   @Autowired
   private CustomerSubAccountDao customerSubAccountDao;

   @Autowired
   private SmsVerificationDao smsVerificationDao;

   @Override
   public CustomerProfile create(CustomerProfile customerProfile) {

      SmsVerification smsVerification = smsVerificationDao.find(customerProfile.getMobileNumber(),1);

      if(smsVerification == null){
         throw new ResourceException(HttpStatus.NOT_FOUND , "sms_code_not_found");
      }

      if(smsVerification.getExpirationDate().isBefore(LocalDateTime.now())){
         throw new ResourceException(HttpStatus.FORBIDDEN , "sms_code_expired");
      }

      if(!smsVerification.getCode().equals(customerProfile.getCode())){
         throw new ResourceException(HttpStatus.NOT_ACCEPTABLE , "sms_code_invalid");
      }

      smsVerification.setStatus(2);

      smsVerification.setUsedDate(LocalDateTime.now());

      CustomerProfile currentCustomerProfile = customerProfileDao.find(customerProfile.getNationalNumber());

      if(currentCustomerProfile == null){
         //create new customer profile
         customerProfile.setCreationDate(LocalDateTime.now());

         customerProfile.setStatus(1);

         customerProfileDao.save(customerProfile);

         CustomerSubAccount customerSubAccount = new CustomerSubAccount();

         customerSubAccount.setFileNumber(customerProfile.getFileNumber());

         Utils.initFileNumberTokens(customerSubAccount);

         customerSubAccount.setCustomerProfile(customerProfile);

         customerSubAccount.setCreationDate(LocalDateTime.now());

         customerSubAccount.setAlias(customerProfile.getFirstName() + " " + customerProfile.getLastName());

         customerSubAccountDao.create(customerSubAccount);

      }else{
         //update current customer profile
         currentCustomerProfile.setMobileNumber(customerProfile.getMobileNumber());

         List<CustomerSubAccount> customerSubAccounts = customerSubAccountDao.find(currentCustomerProfile);

         currentCustomerProfile.setCustomerSubAccountList(customerSubAccounts);

         customerProfile = currentCustomerProfile;
      }
      return customerProfile;
   }


}
