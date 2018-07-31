package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService customerProfileService;


    @PostMapping("/profile/create")
    public ResponseEntity<MessageBody> createProfile(@RequestBody  CustomerProfile customerProfile) {
        Long id = customerProfileService.save(customerProfile);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("create_profile_success");
        messageBody.setBody(id);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
