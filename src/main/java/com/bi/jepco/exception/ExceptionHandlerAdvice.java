/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jepco.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author LENOVO
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity handleException(ResourceException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
