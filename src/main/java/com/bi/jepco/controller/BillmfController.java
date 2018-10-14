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

import java.math.BigDecimal;
import java.math.MathContext;
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

    @GetMapping("/subscriber/{fileNumber}")
    public ResponseEntity<MessageBody> findSubscriber(@PathVariable String fileNumber) {

        if (fileNumber == null || fileNumber.length() != 13) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "missing_file_number");
        }

        CustomerSubAccount customerSubAccount = new CustomerSubAccount();

        CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();

        customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);

        customerSubAccount.setFileNumber(fileNumber);

        Utils.initFileNumberTokens(customerSubAccount);

        Billmf billmf = billmfService.find(customerSubAccount);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("find_subscriber_success");
        messageBody.setBody(billmf);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


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
        BigDecimal consumption = new BigDecimal(Math.abs(meterReading - billmf.getmPreviousRead()));

        //tarifa -> bilParf
        List<BillParf> billParfList = billParfService.find(billmf.getmConsType());

        BigDecimal result = new BigDecimal(0);
        for (BillParf billParf : billParfList) {
            BigDecimal sliceResult = new BigDecimal((billParf.getTokw() - billParf.getFromkw()) + 1);
            if (consumption.compareTo(sliceResult) == -1) {
                //calculate the last tarifa
                result = result.add(consumption.multiply(new BigDecimal(billParf.getpValue())));
                break;
            }
            consumption = consumption.subtract(sliceResult);
            result = result.add(sliceResult.multiply(new BigDecimal(billParf.getpValue())));
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("calculate_reading_success");
        Map<String, Object> data = new HashMap<>();
        data.put("consumption", meterReading - billmf.getmPreviousRead());
        data.put("value", result.setScale(3,BigDecimal.ROUND_HALF_EVEN));
        messageBody.setBody(data);
//        messageBody.setBody(Math.round(readingValue * 100.0) / 100.0);

        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @GetMapping("/calculateWithOutSub/{subscriptionType}/reading/{consValue}")
    public ResponseEntity<MessageBody> calculateWithOutSub(@PathVariable Integer subscriptionType, @PathVariable Long consValue) {

        if (subscriptionType == null ) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "missing_subscription_type");
        }

        if (consValue == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "missing_consumtion_value");
        }

        BigDecimal consumption = new BigDecimal(consValue);

        //tarifa -> bilParf
        List<BillParf> billParfList = billParfService.find(subscriptionType);

        BigDecimal result = new BigDecimal(0);
        for (BillParf billParf : billParfList) {
            BigDecimal sliceResult = new BigDecimal((billParf.getTokw() - billParf.getFromkw()) + 1);
            if (consumption.compareTo(sliceResult) == -1) {
                //calculate the last tarifa
                result = result.add(consumption.multiply(new BigDecimal(billParf.getpValue())));
                break;
            }
            consumption = consumption.subtract(sliceResult);
            result = result.add(sliceResult.multiply(new BigDecimal(billParf.getpValue())));
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("calculate_reading_success");
        Map<String, Object> data = new HashMap<>();
        data.put("consumption", consValue);
        data.put("value", result.setScale(3,BigDecimal.ROUND_HALF_EVEN));
        messageBody.setBody(data);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
