package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.entities.CustomerSubInfoPK;
import com.bi.jepco.entities.MobileTips;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.BillhfService;
import com.bi.jepco.service.CustomerSubAccountService;
import com.bi.jepco.service.MobileTipsService;
import com.bi.jepco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class BillhfController {

    @Autowired
    private BillhfService billhfService;

    @Autowired
    private CustomerSubAccountService customerSubAccountService;


    @GetMapping("/bills/{fileNumber}")
    public ResponseEntity<MessageBody> findBills(@PathVariable String fileNumber) {

        if(fileNumber == null || fileNumber.length() != 13){
            throw new ResourceException(HttpStatus.NOT_FOUND , "missing_file_number");
        }

        CustomerSubAccount customerSubAccount = new CustomerSubAccount();

        CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();

        customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);

        customerSubAccount.setFileNumber(fileNumber);

        Utils.initFileNumberTokens(customerSubAccount);

        List<Billhf> billhfList = billhfService.find(customerSubAccount);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("find_bills_success");
        messageBody.setBody(billhfList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
