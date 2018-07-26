package com.bi.jepco.controller;

import com.bi.jepco.exception.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bi.jepco.service.TestService;
import org.springframework.http.HttpStatus;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    /*---get all tests---*/
    @GetMapping("/test")
    public ResponseEntity<?> list() {
        testService.list();
        if (true) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "We were unable to find the specified resource.");
        }
        return ResponseEntity.ok().body("connected success to jepco mobile api.");
    }

}
