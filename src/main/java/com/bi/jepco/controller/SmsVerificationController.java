package com.bi.jepco.controller;

import com.bi.jepco.utils.MessageBody;
import com.bi.jepco.entities.SmsVerification;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.SmsVerificationService;
import com.bi.jepco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SmsVerificationController {

    @Autowired
    private SmsVerificationService smsVerificationService;


    @PostMapping("/sms/send/{mobileNumber}")
    public ResponseEntity<MessageBody> createSms(@PathVariable String mobileNumber) {

        if (mobileNumber == null ||mobileNumber.isEmpty()) {

            throw new ResourceException(HttpStatus.BAD_REQUEST, "validation_error");
        }
        System.out.println(">> mob no "+mobileNumber);
        String mobileValidator = Utils.formatE164("+962", mobileNumber);

        if (mobileValidator.equals("0")) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "invalid_mobile");
        }

//        if(!Utils.validateNationalNumber(smsVerification.getNationalNumber(),smsVerification.getIdType())){
//            throw new ResourceException(HttpStatus.BAD_REQUEST , "national_number_not_valid");
//        }
        SmsVerification smsVerification = new SmsVerification();
        smsVerification.setMobileNumber(mobileValidator);

        smsVerification = smsVerificationService.create(smsVerification);

        try {
            int status = Utils.sendSms("Your JEPCO Code is: " + smsVerification.getCode() + " Close this message and enter into JEPCO to activate your account", smsVerification.getMobileNumber());
        } catch (Exception ex) {
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("create_sms_success");
        messageBody.setBody(smsVerification);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @GetMapping("/sms/send")
    public ResponseEntity<MessageBody> sendSms(@RequestParam("mobile") String mobile, @RequestParam("text") String text) {

        try {
            int status = Utils.sendSms(text, mobile);
        } catch (Exception ex) {
            throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR, "Server error");
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("send_sms_success");
        messageBody.setBody(null);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
