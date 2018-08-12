package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.MobileTips;
import com.bi.jepco.entities.PaymentCenter;
import com.bi.jepco.service.MobileTipsService;
import com.bi.jepco.service.PaymentCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class PaymentCenterController {

    @Autowired
    private PaymentCenterService paymentCenterService;


    @GetMapping("/centers")
    public ResponseEntity<MessageBody> findAllPaymentCenters() {

        List<PaymentCenter> paymentCenters = paymentCenterService.find();

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("find_tips_success");
        messageBody.setBody(paymentCenters);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
