/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jepco.exception;

import com.bi.jepco.config.MessageBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author abdallah dabbas
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<MessageBody> handleException(ResourceException exception) {
        MessageBody messageBody = MessageBody.getInstance();
        messageBody.setStatus("error");
        messageBody.setKey(exception.getMessage());
        return new ResponseEntity<>(messageBody, exception.getHttpStatus());
    }
}
