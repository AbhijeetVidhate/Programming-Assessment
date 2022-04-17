package com.barclays.programmingassessment.controllers;

import com.barclays.programmingassessment.exceptions.MinorVersionException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order()
@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class, MinorVersionException.class})
    protected ResponseEntity<Object> handleNullPointerException(Exception exception, WebRequest webRequest){
        return handleExceptionInternal(exception,exception.getMessage(),new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,webRequest);
    }
}
