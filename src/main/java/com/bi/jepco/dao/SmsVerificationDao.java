package com.bi.jepco.dao;

import com.bi.jepco.entities.SmsVerification;


public interface SmsVerificationDao {

   public SmsVerification create(SmsVerification smsVerification);
   public SmsVerification find(String mobileNumber , Integer status);
   public SmsVerification update(SmsVerification smsVerification);

}
