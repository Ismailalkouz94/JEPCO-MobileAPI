package com.bi.jepco.service.impl;

import com.bi.jepco.controller.PushNotificationController;
import com.bi.jepco.dao.CustPNCAccountsDao;
import com.bi.jepco.dao.CustomerProfileDao;
import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.entities.PNCLog;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.resources.PncResource;
import com.bi.jepco.service.CustPNCAccountsService;
import com.bi.jepco.service.CustomerSubAccountService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Autowired
    private CustomerSubAccountService customerSubAccountService;

    @Autowired
    private CustomerProfileDao customerProfileDao;

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

        String picName = null;
        FileInputStream serviceAccount = null;
        FirebaseOptions options = null;
        try {

//            picName=storePic(pncResource.getPicture(),pncResource.getPictureName());

//            ClassLoader classLoader = getClass().getClassLoader();
//            serviceAccount = new FileInputStream(classLoader.getResource("/fcmfile/jepco-fcm.json").getPath());

            serviceAccount= new FileInputStream("C:\\Users\\mobapp.JEPCO\\Desktop\\jepco-fcm.json");
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

        JSONObject dataObj = new JSONObject();
        dataObj.put("title", pncResource.getTitle());
        dataObj.put("message", pncResource.getMessage());

        JSONArray actionsArr = new JSONArray();
        if(pncResource.getPicture()!=null ){
            picName="http://217.144.0.210:8085/PNC-Image/"+storePic(pncResource.getPicture(),pncResource.getPictureName());
            dataObj.put("style", "picture");
            dataObj.put("summaryText", pncResource.getMessage());
            dataObj.put("picture",picName );
        }else {
            JSONObject actionObjPay = new JSONObject();
            actionObjPay.put("title", "OPEN");
            actionObjPay.put("callback", "open");
            actionObjPay.put("foreground", "true");
            actionsArr.put(actionObjPay);


            dataObj.put("actions", actionsArr);
        }

        dataObj.put("forceShow", "true");
        dataObj.put("coldstart", "true");
        dataObj.put("foreground", "true");


        List<CustPNCAccounts> custPNCAccountsList = new ArrayList<>();

        switch (pncResource.getToFlaq()) {
            case "mobileNumber":
                if (pncResource.getMobileNumber().isEmpty() || pncResource.getMobileNumber() == null) {
                    throw new ResourceException(HttpStatus.BAD_REQUEST, "validation_error");
                }

                CustomerProfile customerProfile = customerProfileDao.find(pncResource.getMobileNumber());
                if (customerProfile == null) {
                    throw new ResourceException(HttpStatus.NOT_FOUND, "profile_not_found");
                }

//                CustomerProfile customerProfile = new CustomerProfile();
                customerProfile.setMobileNumber(pncResource.getMobileNumber());
                custPNCAccountsList.add(custPNCAccountsDao.find(customerProfile));
                break;
            case "fileNumber":
                if (pncResource.getFileNumber().isEmpty() || pncResource.getFileNumber() == null) {
                    throw new ResourceException(HttpStatus.BAD_REQUEST, "validation_error");
                }
                custPNCAccountsList = find(pncResource.getFileNumber());
                break;
            case "all":
                custPNCAccountsList = custPNCAccountsDao.find();
                break;
            default:
                break;
        }

        Message fcmMessage = null;
        PNCLog pncLog =null;
        for (CustPNCAccounts item : custPNCAccountsList) {
            pncLog = new PNCLog();
            System.out.println(item.getToken());
            fcmMessage = Message.builder()
                    .setAndroidConfig(AndroidConfig.builder()
                            .setTtl(3600 * 1000) // 1 hour in milliseconds
                            .setPriority(AndroidConfig.Priority.NORMAL)
                            .putData("data", dataObj.toString())
                            .build())
                    .setToken(item.getToken())
                    .build();

            pncLog.setMobileNumber(item.getCustomerProfile().getMobileNumber());
            pncLog.setFileNumber(pncResource.getFileNumber());
            pncLog.setToken(item.getToken());
            pncLog.setTitle(pncResource.getTitle());
            pncLog.setMessage(pncResource.getMessage());
            pncLog.setImagePath(picName);
            pncLog.setPlatform(item.getPlatform());
            pncLog.setOsVersion(item.getOsVersion());

            String response;
            try {
                response = FirebaseMessaging.getInstance().sendAsync(fcmMessage).get();
                // Response is a message ID string.
                System.out.println("Successfully sent message: " + response);
                 pncLog.setStatus(1);
                 custPNCAccountsDao.saveLog(pncLog);
            } catch (InterruptedException | ExecutionException ex) {
                pncLog.setStatus(0);
                custPNCAccountsDao.saveLog(pncLog);
                Logger.getLogger(PushNotificationController.class.getName()).log(Level.SEVERE, null, ex);
//                throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
            }

        }

        return pncResource;
    }

    @Override
    public List<CustPNCAccounts> find(String fileNumber) {
        List<CustomerSubAccount> customerSubAccountList = customerSubAccountService.find(fileNumber);
        List<CustPNCAccounts> custPNCAccountsList = new ArrayList<>();
        for (CustomerSubAccount subAccount : customerSubAccountList) {
            if (custPNCAccountsDao.find(subAccount.getCustomerSubInfoPK().getCustomerProfile()) != null) {
                custPNCAccountsList.add(custPNCAccountsDao.find(subAccount.getCustomerSubInfoPK().getCustomerProfile()));
            }
        }
        return custPNCAccountsList;
    }

    @Override
    public String storePic(String pic, String picName)  {

        try{

//            String sourceFolder = "D:\\ionic project\\";
            String sourceFolder= "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\PNC-Image\\";

            byte[] btDataFile = new sun.misc.BASE64Decoder().decodeBuffer(pic);

            File of = new File(sourceFolder + picName);
            FileOutputStream fos = new FileOutputStream(of);
            fos.write(btDataFile);
            fos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        return picName;
    }

//    @Override
//    public String storePic(MultipartFile pic) throws IOException {
//        if (!pic.isEmpty()) {
//            byte[] bytes = pic.getBytes();
//            FileOutputStream fos = new FileOutputStream(
//                    "D:\\ionic project\\" + pic.getOriginalFilename());
//
////            "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\JEPCO\\" + pic.getOriginalFilename());
//            try {
//                fos.write(bytes);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                fos.close();
//            }
//            return pic.getOriginalFilename();
//        } else {
//            return "false";
//        }
//    }
}
