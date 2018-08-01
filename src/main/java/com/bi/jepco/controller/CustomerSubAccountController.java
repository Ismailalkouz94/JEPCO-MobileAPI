package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.CustomerProfileService;
import com.bi.jepco.service.CustomerSubAccountService;
import com.bi.jepco.service.SmsVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerSubAccountController {

    @Autowired
    private CustomerSubAccountService customerSubAccountService;

    @PostMapping("/sub/create")
    public ResponseEntity<MessageBody> createSub(@RequestBody CustomerSubAccount customerSubAccount) {

        if(customerSubAccount.getAlias() == null
                || customerSubAccount.getAlias().isEmpty()
                || customerSubAccount.getFileNumber() == null
                || customerSubAccount.getFileNumber().isEmpty()){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "Validation_error");
        }

        customerSubAccount = customerSubAccountService.create(customerSubAccount);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("create_sub_success");
        messageBody.setBody(customerSubAccount);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @DeleteMapping("/sub/delete")
    public ResponseEntity<MessageBody> deleteSub(@RequestBody CustomerSubAccount customerSubAccount) {

        customerSubAccount = customerSubAccountService.create(customerSubAccount);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("delete_sub_success");
        messageBody.setBody(customerSubAccount);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
