package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.entities.CustomerSubAccount;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin
@RestController
public class PushNotificationController {

    @GetMapping("/pnc/send/{message}")
    public ResponseEntity<MessageBody> send(@PathVariable String message) {

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

        notificationObj.put("title", "Notification title");
        notificationObj.put("body", message);

        Message fcmMessage = Message.builder()
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000) // 1 hour in milliseconds
                        .setPriority(AndroidConfig.Priority.NORMAL)
                        .putData("data", notificationObj.toString())
                        .build())
                .setToken("dVXpIxSqHqs:APA91bH8Coife69MXWnnIMmXe--ooHbHA9eFIJqDXfe3Fce9Q4m7Pg5afnQO1aXUH77FU5E52xE-rNpCjSPRDNQMBzCSgpVGjhjkyDHqncGbIBzDT4mfmGu8na0DdIsQQzcYbxd68_sc")
                .build();


        String response;
        try {
            response = FirebaseMessaging.getInstance().sendAsync(fcmMessage).get();
            // Response is a message ID string.
            System.out.println("Successfully sent message: " + response);

        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
            Logger.getLogger(PushNotificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(null);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
