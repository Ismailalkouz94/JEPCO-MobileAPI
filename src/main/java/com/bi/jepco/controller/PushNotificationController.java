package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.resources.PncResource;
import com.bi.jepco.service.CustPNCAccountsService;
import com.bi.jepco.service.CustomerProfileService;
import com.bi.jepco.utils.Utils;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin
@RestController
public class PushNotificationController {

    @Autowired
    private CustPNCAccountsService custPNCAccountsService;

    @Autowired
    private CustomerProfileService customerProfileService;

    @PostMapping("/pnc/save")
    public ResponseEntity<MessageBody> saveTackenInfo(@RequestBody CustPNCAccounts custPNCAccounts) {

        String mobileValidator = Utils.formatE164("+962", custPNCAccounts.getMobileNumber());

        CustomerProfile customerProfile = customerProfileService.find(mobileValidator);

        custPNCAccounts.setCustomerProfile(customerProfile);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(custPNCAccountsService.save(custPNCAccounts));
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }


    @PostMapping("/pnc/send")
    public ResponseEntity<MessageBody> send(@RequestBody PncResource pncResource) {

        System.out.println(">>>>> "+pncResource.getToFlaq());
        System.out.println(pncResource.getMobileNumber());
        System.out.println(pncResource.getTitle());
        System.out.println(pncResource.getMessage());

        String mobileValidator = Utils.formatE164("+962", pncResource.getMobileNumber());
        pncResource.setMobileNumber(mobileValidator);
        custPNCAccountsService.send(pncResource);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(custPNCAccountsService.send(pncResource));
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
