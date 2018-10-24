package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.CustomerProfileService;
import com.bi.jepco.service.CustomerSubAccountService;
import com.bi.jepco.utils.Utils;
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

        if(customerSubAccount.getMobileNumber() == null
                || customerSubAccount.getMobileNumber().isEmpty()
                || customerSubAccount.getAlias() == null
                || customerSubAccount.getAlias().isEmpty()
                || customerSubAccount.getFileNumber() == null
                || customerSubAccount.getFileNumber().length() != 13){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "Validation_error");
        }

        String mobileValidator = Utils.formatE164("+962", customerSubAccount.getMobileNumber());
        customerSubAccount.setMobileNumber(mobileValidator);

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
                || customerSubAccount.getMobileNumber() == null
                || customerSubAccount.getMobileNumber().isEmpty()){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "Validation_error");
        }
        String mobileValidator = Utils.formatE164("+962", customerSubAccount.getMobileNumber());
        customerSubAccount.setMobileNumber(mobileValidator);


        CustomerProfile customerProfile = customerProfileService.find(customerSubAccount.getMobileNumber());

        customerSubAccountService.delete(customerProfile,customerSubAccountFileNumber);

        List<CustomerSubAccount> customerSubAccountList  = customerSubAccountService.find(customerProfile);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("delete_sub_success");
        messageBody.setBody(customerSubAccountList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @PutMapping("/sub/update/{oldCustomerSubAccountFileNumber}")
    public ResponseEntity<MessageBody> updateSub(@PathVariable String oldCustomerSubAccountFileNumber , @RequestBody CustomerSubAccount customerSubAccount) {

        if(oldCustomerSubAccountFileNumber == null
                || oldCustomerSubAccountFileNumber.length() == 0
                || customerSubAccount.getMobileNumber() == null
                || customerSubAccount.getMobileNumber().isEmpty()){
            throw new ResourceException(HttpStatus.BAD_REQUEST , "Validation_error");
        }

        String mobileValidator = Utils.formatE164("+962", customerSubAccount.getMobileNumber());
        customerSubAccount.setMobileNumber(mobileValidator);

        customerSubAccountService.update(oldCustomerSubAccountFileNumber,customerSubAccount);

        List<CustomerSubAccount> customerSubAccountList = customerSubAccountService.find(customerSubAccount.getCustomerSubInfoPK().getCustomerProfile());

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("update_sub_success");
        messageBody.setBody(customerSubAccountList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
