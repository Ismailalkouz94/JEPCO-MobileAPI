package com.bi.jepco.controller;

import com.bi.jepco.entities.PNCLog;
import com.bi.jepco.entities.ReportProblemLog;
import com.bi.jepco.utils.MessageBody;
import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.resources.PncResource;
import com.bi.jepco.service.CustPNCAccountsService;
import com.bi.jepco.service.CustomerProfileService;
import com.bi.jepco.utils.Utils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<MessageBody> send(@RequestBody PncResource pncResource ) {

        System.out.println(">>>>> "+pncResource.getToFlaq());
        System.out.println(pncResource.getMobileNumber());
        System.out.println(pncResource.getFileNumber());
        System.out.println(pncResource.getTitle());
        System.out.println(pncResource.getMessage());

        String mobileValidator = Utils.formatE164("+962", pncResource.getMobileNumber());
        pncResource.setMobileNumber(mobileValidator);
        custPNCAccountsService.send(pncResource);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(pncResource);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @RequestMapping(value = "/pnc/listPnc", method = RequestMethod.GET)
    public ResponseEntity<MessageBody> findAll() {

        List<CustPNCAccounts> custPNCAccountsList = custPNCAccountsService.find();

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(custPNCAccountsList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @RequestMapping(value = "/pnc/listLog", method = RequestMethod.GET)
    public ResponseEntity<MessageBody> findLog() {

        List<PNCLog> pncLogs = custPNCAccountsService.findLog();

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(pncLogs);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

    @RequestMapping(value = "/pnc/dashboardInfo", method = RequestMethod.GET)
    public ResponseEntity<MessageBody> dashboardInfo() {

        Map<String,Object> resBody = new HashMap<String,Object>();
        resBody.put("allSubscriptions",custPNCAccountsService.findCount("all"));
        resBody.put("androidSubscriptions",custPNCAccountsService.findCount("android"));
        resBody.put("iosSubscriptions", custPNCAccountsService.findCount("ios"));
        resBody.put("history", custPNCAccountsService.findLogCount());

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("success");
        messageBody.setBody(resBody);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

//    @PostMapping("/pnc/upload")
//    public ResponseEntity<MessageBody> upload(@RequestParam("file") MultipartFile file ) {
//
//
//        try {
//            custPNCAccountsService.storePic(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        MessageBody messageBody = MessageBody.getInstance();
//        messageBody.setStatus("success");
//        messageBody.setKey("success");
//        messageBody.setBody(null);
//        return new ResponseEntity<>(messageBody, HttpStatus.OK);
//    }

}
