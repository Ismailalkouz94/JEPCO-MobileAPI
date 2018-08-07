package com.bi.jepco.service;

import com.bi.jepco.entities.SmsVerification;


public interface SmsVerificationService {

   public SmsVerification create(SmsVerification smsVerification);
   public SmsVerification find(String mobileNumber , Integer status);
   public SmsVerification update(SmsVerification smsVerification);
}
