package com.bi.jepco.service.impl;

import com.bi.jepco.controller.SmsVerificationController;
import com.bi.jepco.dao.CustomerProfileDao;
import com.bi.jepco.dao.SmsVerificationDao;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.SmsVerification;
import com.bi.jepco.service.CustomerProfileService;
import com.bi.jepco.service.SmsVerificationService;
import com.bi.jepco.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional
public class SmsVerificationServiceImp implements SmsVerificationService {

    private static final Logger logger = Logger.getLogger(SmsVerificationServiceImp.class);

    @Autowired
   private SmsVerificationDao smsVerificationDao;


   @Override
   public SmsVerification create(SmsVerification smsVerification) {

       SmsVerification currentSmsVerification = smsVerificationDao.find(smsVerification.getMobileNumber(),1);

       if (currentSmsVerification != null) {
           currentSmsVerification.setStatus(0);
       }

       smsVerification.setCode(Utils.randomNumber(4));
       smsVerification.setCreationDate(LocalDateTime.now());
       smsVerification.setExpirationDate(LocalDateTime.now().plusMinutes(1).plusSeconds(10));
       smsVerification.setStatus(1);

       return smsVerificationDao.create(smsVerification);
   }

   @Override
   public SmsVerification find(String mobileNumber, Integer status) {
      return smsVerificationDao.find(mobileNumber,status);
   }

   @Override
   public SmsVerification update(SmsVerification smsVerification) {
      return smsVerificationDao.update(smsVerification);
   }
}