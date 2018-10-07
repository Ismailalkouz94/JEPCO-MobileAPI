package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.*;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.BillParfService;
import com.bi.jepco.service.BillhfService;
import com.bi.jepco.service.BillmfService;
import com.bi.jepco.service.CustomerSubAccountService;
import com.bi.jepco.utils.Utils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class BillmfController {

    @Autowired
    private BillmfService billmfService;

    @Autowired
    private CustomerSubAccountService customerSubAccountService;

    @Autowired
    private BillParfService billParfService;

    @Autowired
    private BillhfService billhfService;


    @GetMapping("/history/{fileNumber}/{payFlag}")
    public ResponseEntity<MessageBody> findBills(@PathVariable String fileNumber, @PathVariable Integer payFlag) {

        if (fileNumber == null || fileNumber.length() != 13) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "missing_file_number");
        }

        CustomerSubAccount customerSubAccount = new CustomerSubAccount();

        CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();

        customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);

        customerSubAccount.setFileNumber(fileNumber);

        Utils.initFileNumberTokens(customerSubAccount);

        Billmf billmf = billmfService.find(customerSubAccount);

        List<Billhf> billhfList = billhfService.find(customerSubAccount, payFlag);

        billmf.setBills(billhfList);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("find_bills_success");
        messageBody.setBody(billmf);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


    @GetMapping("/calculate/{fileNumber}/reading/{meterReading}")
    public ResponseEntity<MessageBody> calculateReading(@PathVariable String fileNumber, @PathVariable Long meterReading) {

        if (fileNumber == null || fileNumber.length() != 13) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "missing_file_number");
        }

        if (meterReading == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "missing_meter_reading");
        }

        CustomerSubAccount customerSubAccount = new CustomerSubAccount();

        CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();

        customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);

        customerSubAccount.setFileNumber(fileNumber);

        Utils.initFileNumberTokens(customerSubAccount);

        Billmf billmf = billmfService.find(customerSubAccount);

        if (meterReading < billmf.getmPreviousRead()) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "bill_consumption_meterReading_lessThan_preReading");
        }
        Long consumption = Math.abs(meterReading - billmf.getmPreviousRead());

        System.out.println("getmPreviousRead: " + billmf.getmPreviousRead());

        List<BillParf> billParfList = billParfService.find(billmf.getmConsType());

        BillParf selectedBillParf = null;

        for (BillParf billParf : billParfList) {
            if ((consumption >= billParf.getFromkw()) && (consumption < billParf.getTokw())) {
                selectedBillParf = billParf;
                break;
            }
        }

        if (selectedBillParf == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "bill_consumption_not_found");
        }

        System.out.println("billParfList: " + billParfList.size());

        Double readingValue = consumption * selectedBillParf.getpValue();

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("calculate_reading_success");
//        messageBody.setBody(Utils.randomNumber(2)+"."+Utils.randomNumber(3));
        Map<String,Object> data=new HashMap<>();
        data.put("consumption",consumption);
        data.put("value",Math.round(readingValue * 100.0) / 100.0);
        messageBody.setBody(data);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
