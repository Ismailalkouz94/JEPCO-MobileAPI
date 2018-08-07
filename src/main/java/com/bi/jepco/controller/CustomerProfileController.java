package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.CustomerProfileService;
import com.bi.jepco.service.SmsVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@CrossOrigin
@RestController
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService customerProfileService;

    @Autowired
    private SmsVerificationService smsVerificationService;


    @PostMapping("/profile/create")
    public ResponseEntity<MessageBody> createProfile(@RequestBody  CustomerProfile customerProfile) {

        if(customerProfile.getNationalNumber() == null
                || customerProfile.getNationalNumber().isEmpty()
                || customerProfile.getFirstName() == null
                || customerProfile.getFirstName().isEmpty()
                || customerProfile.getLastName() == null
                || customerProfile.getLastName().isEmpty()
                || customerProfile.getMobileNumber() == null
                || customerProfile.getMobileNumber().isEmpty()
                || customerProfile.getCode() == null
                || customerProfile.getCode().isEmpty()
                || customerProfile.getFileNumber() == null
                || customerProfile.getFileNumber().length() != 13){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "Validation_error");
        }

        customerProfile = customerProfileService.create(customerProfile);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("create_profile_success");
        messageBody.setBody(customerProfile);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @GetMapping("/profile/{nationalNumber}")
    public ResponseEntity<MessageBody> getProfile(@PathVariable String nationalNumber) {

        if(nationalNumber == null
                || nationalNumber.isEmpty()){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "Validation_error");
        }

        CustomerProfile customerProfile = customerProfileService.find(nationalNumber);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("find_profile_success");
        messageBody.setBody(customerProfile);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
