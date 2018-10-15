package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.CustomerProfileService;
import com.bi.jepco.service.SmsVerificationService;
import com.bi.jepco.utils.Utils;
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


    @GetMapping("/irf")
    public ResponseEntity<MessageBody> getIRF() {

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody("0");
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


    @PostMapping("/profile/create")
    public ResponseEntity<MessageBody> createProfile(@RequestBody CustomerProfile customerProfile) {

        if (customerProfile.getMobileNumber() == null
                || customerProfile.getMobileNumber().isEmpty()
                || customerProfile.getFirstName() == null
                || customerProfile.getFirstName().isEmpty()
                || customerProfile.getLastName() == null
                || customerProfile.getLastName().isEmpty()
                || customerProfile.getFileNumber() == null
                || customerProfile.getFileNumber().length() != 13
                ) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Validation_error");
        }
        String mobileValidator = Utils.formatE164("+962", customerProfile.getMobileNumber());
        customerProfile.setMobileNumber(mobileValidator);

        customerProfile = customerProfileService.create(customerProfile);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("create_profile_success");
        messageBody.setBody(customerProfile);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


    @PostMapping("/profile/verify")
    public ResponseEntity<MessageBody> verifyProfile(@RequestBody CustomerProfile customerProfile) {

        if ( customerProfile.getMobileNumber() == null
                || customerProfile.getMobileNumber().isEmpty()
                || customerProfile.getCode() == null
                || customerProfile.getCode().isEmpty()
                ) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Validation_error");
        }


        customerProfile = customerProfileService.verify(customerProfile);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("create_profile_success");
        messageBody.setBody(customerProfile);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @GetMapping("/profile/{mobileNumber}")
    public ResponseEntity<MessageBody> getProfile(@PathVariable String mobileNumber) {

        if (mobileNumber == null
                || mobileNumber.isEmpty()) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "Validation_error");
        }

        CustomerProfile customerProfile = customerProfileService.find(mobileNumber);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("find_profile_success");
        messageBody.setBody(customerProfile);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
