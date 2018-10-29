package com.bi.jepco.service.impl;

import com.bi.jepco.controller.PushNotificationController;
import com.bi.jepco.dao.CustPNCAccountsDao;
import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.resources.PncResource;
import com.bi.jepco.service.CustPNCAccountsService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class CustPNCAccountsServiceImpl implements CustPNCAccountsService {

    @Autowired
    private CustPNCAccountsDao custPNCAccountsDao;

    @Override
    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts) {

        CustPNCAccounts pncAccounts = custPNCAccountsDao.find(custPNCAccounts.getCustomerProfile());
        if (pncAccounts != null) {
            pncAccounts.setOsVersion(custPNCAccounts.getOsVersion());
            pncAccounts.setToken(custPNCAccounts.getToken());
            pncAccounts.setPlatform(custPNCAccounts.getPlatform());
            return pncAccounts;
        } else {
//            custPNCAccounts.setId(Long.parseLong(Utils.randomNumber(5)));
            pncAccounts = custPNCAccountsDao.find(custPNCAccounts.getToken());
            if (pncAccounts != null) {
                pncAccounts.setOsVersion(custPNCAccounts.getOsVersion());
                pncAccounts.setCustomerProfile(custPNCAccounts.getCustomerProfile());
                pncAccounts.setPlatform(custPNCAccounts.getPlatform());
                return pncAccounts;
            } else {
                return custPNCAccountsDao.save(custPNCAccounts);
            }
        }
    }

    @Override
    public PncResource send(PncResource pncResource) {
        FileInputStream serviceAccount = null;
        FirebaseOptions options = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            serviceAccount = new FileInputStream(classLoader.getResource("fcmfile/jepco-fcm.json").getFile());

            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://jepco-217509.firebaseio.com")
                    .build();

            FirebaseApp firebaseApp = null;
            List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
            if (firebaseApps != null && !firebaseApps.isEmpty()) {
                for (FirebaseApp app : firebaseApps) {
                    if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                        firebaseApp = app;
                    }
                }
            } else {
                firebaseApp = FirebaseApp.initializeApp(options);
            }


        } catch (IOException ex) {
            System.out.println(ex);
            Logger.getLogger(PushNotificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        JSONObject msgObj = new JSONObject();
        JSONObject notificationObj = new JSONObject();

        notificationObj.put("title", pncResource.getTitle());
        notificationObj.put("body", pncResource.getMessage());

        List<CustPNCAccounts> custPNCAccountsList = new ArrayList<>();

        switch (pncResource.getToFlaq()) {
            case "mobileNumber":
                CustomerProfile customerProfile = new CustomerProfile();
                customerProfile.setMobileNumber(pncResource.getMobileNumber());
                custPNCAccountsList.add(custPNCAccountsDao.find(customerProfile));
                break;
            case "fileNumber":
                break;
            case "all":
                custPNCAccountsList = custPNCAccountsDao.find();
                break;
            default:
                break;
        }

        System.out.println(">>>>>>>> ");
        Message fcmMessage = null;
        for (CustPNCAccounts item : custPNCAccountsList) {
            System.out.println(item.getToken());
            fcmMessage = Message.builder()
                    .setAndroidConfig(AndroidConfig.builder()
                            .setTtl(3600 * 1000) // 1 hour in milliseconds
                            .setPriority(AndroidConfig.Priority.NORMAL)
                            .putData("data", notificationObj.toString())
                            .build())
                    .setToken(item.getToken())
                    .build();
        }

        String response;
        try {
            response = FirebaseMessaging.getInstance().sendAsync(fcmMessage).get();
            // Response is a message ID string.
            System.out.println("Successfully sent message: " + response);

        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(PushNotificationController.class.getName()).log(Level.SEVERE, null, ex);
            throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
        }
        return pncResource;
    }
}
