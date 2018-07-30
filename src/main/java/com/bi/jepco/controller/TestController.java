package com.bi.jepco.controller;

import com.bi.jepco.config.MessageBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class TestController {

//    @Autowired
//    private TestService testService;

    /*---get all tests---*/

    @GetMapping("/test")
    public ResponseEntity<MessageBody> list() {
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("success");
        messageBody.setBody("connected success to jepco api");
        return new ResponseEntity<>(messageBody, HttpStatus.OK);
    }

}
