package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.SmsVerification;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.SmsVerificationService;
import com.bi.jepco.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsVerificationController {

    private static final Logger logger = Logger.getLogger(SmsVerificationController.class);

    @Autowired
    private SmsVerificationService smsVerificationService;


    @PostMapping("/sms/send")
    public ResponseEntity<MessageBody> createSms(@RequestBody SmsVerification smsVerification) {

        if(smsVerification.getMobileNumber()== null
                || smsVerification.getMobileNumber().isEmpty()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST , "mobile_empty");
        }

        smsVerification.setMobileNumber(Utils.formatE164("+962",smsVerification.getMobileNumber()));

        smsVerification = smsVerificationService.create(smsVerification);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("create_sms_success");
        messageBody.setBody(smsVerification);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
