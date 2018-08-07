package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.CustomerSubAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CustomerSubAccountController {

    @Autowired
    private CustomerSubAccountService customerSubAccountService;

    @PostMapping("/sub/create")
    public ResponseEntity<MessageBody> createSub(@RequestBody CustomerSubAccount customerSubAccount) {

        if(customerSubAccount.getNationalNumber() == null
                || customerSubAccount.getNationalNumber().isEmpty()
                || customerSubAccount.getAlias() == null
                || customerSubAccount.getAlias().isEmpty()
                || customerSubAccount.getFileNumber() == null
                || customerSubAccount.getFileNumber().length() != 13){
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

        if(customerSubAccount.getId() == null
                || customerSubAccount.getId() == 0){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "Validation_error");
        }
        customerSubAccountService.delete(customerSubAccount);
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("delete_sub_success");
        messageBody.setBody("");
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
