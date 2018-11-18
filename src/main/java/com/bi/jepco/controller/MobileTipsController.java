package com.bi.jepco.controller;

import com.bi.jepco.utils.MessageBody;
import com.bi.jepco.entities.MobileTips;
import com.bi.jepco.service.MobileTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MobileTipsController {

    @Autowired
    private MobileTipsService mobileTipsService;


    @GetMapping("/tips")
    public ResponseEntity<MessageBody> findAllMobileTips() {

        List<MobileTips> mobileTipsList = mobileTipsService.find();

//        List<MobileTips> mobileTipsList = new ArrayList<>();
//
//        MobileTips mobileTips = new MobileTips();
//        mobileTips.setArabicText("تقليل الاعتماد على الإضاءة الصناعية خلال أوقات النهار، والاعتماد على الإضاءة الطبيعية بدلاً منها، وذلك من خلال فتح النوّافذ لتدخل الإضاءة");
//        mobileTips.setEnglishText("Reduce dependence on industrial lighting during daylight hours, relying on natural lighting instead, by opening windows to interfere with lighting");
//        mobileTipsList.add(mobileTips);

        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setKey("find_tips_success");
        messageBody.setBody(mobileTipsList);
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
