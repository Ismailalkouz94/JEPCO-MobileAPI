package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.CustomerProfileService;
import com.bi.jepco.service.CustomerSubAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerSubAccountController {

    @Autowired
    private CustomerSubAccountService customerSubAccountService;

    @Autowired
    private CustomerProfileService customerProfileService;

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

    @PutMapping("/sub/delete/{customerSubAccountFileNumber}")
    public ResponseEntity<MessageBody> deleteSub(@PathVariable String customerSubAccountFileNumber , @RequestBody CustomerSubAccount customerSubAccount) {

        if(customerSubAccountFileNumber == null
                || customerSubAccountFileNumber.length() == 0
                || customerSubAccount.getNationalNumber() == null
                || customerSubAccount.getNationalNumber().isEmpty()){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "Validation_error");
        }

        CustomerProfile customerProfile = customerProfileService.find(customerSubAccount.getNationalNumber());

        List<CustomerSubAccount> customerSubAccountList = customerSubAccountService.find(customerProfile);

        for(CustomerSubAccount customerSubAccountObj : customerSubAccountList){
            if(customerSubAccountObj.getFileNumber().equals(customerSubAccountFileNumber)){
                System.out.println("find file number success");
                customerSubAccount = customerSubAccountObj;
                break;
            }
        }
        System.out.println("customerSubAccount: "+customerSubAccount.getFileNumber());
        System.out.println("customerSubAccount: "+customerSubAccount.getCustomerSubInfoPK().getCustomerProfile().getNationalNumber());
        customerSubAccountService.delete(customerSubAccount);


        customerSubAccountList = customerSubAccountService.find(customerProfile);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("delete_sub_success");
        messageBody.setBody(customerSubAccountList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
