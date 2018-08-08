package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.SmsVerification;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.SmsVerificationService;
import com.bi.jepco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SmsVerificationController {

    @Autowired
    private SmsVerificationService smsVerificationService;


    @PostMapping("/sms/send")
    public ResponseEntity<MessageBody> createSms(@RequestBody SmsVerification smsVerification) {

        if(smsVerification.getMobileNumber()== null
                || smsVerification.getMobileNumber().isEmpty()
                || smsVerification.getFileNumber() == null
                || smsVerification.getFileNumber().isEmpty()
                || smsVerification.getFileNumber().length() != 13
                || smsVerification.getNationalNumber() == null
                || smsVerification.getNationalNumber().isEmpty()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST , "validation_error");
        }

        String mobileValidator = Utils.formatE164("+962",smsVerification.getMobileNumber());

        if(mobileValidator.equals("0")){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "invalid_mobile");
        }

        if(!Utils.validateNationalNumber(smsVerification.getNationalNumber())){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "national_number_not_valid");
        }

        smsVerification.setMobileNumber(mobileValidator);

        smsVerification = smsVerificationService.create(smsVerification);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("create_sms_success");
        messageBody.setBody(smsVerification);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
