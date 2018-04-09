package com.example.demoexceptions.controllers;

import com.example.demoexceptions.exception.ArithmeticExceptionCdpyme;
import com.example.demoexceptions.exception.StudentNotFoundException;
import com.example.demoexceptions.model.ErrorDetails;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
    /**
     * Handle GenericNotFoundException
     *
     **/
    @ExceptionHandler(StudentNotFoundException.class)
    protected ResponseEntity<ErrorDetails> handleAllGenericNotFoundExceptions(StudentNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"CD43",NOT_FOUND.toString(),ex.getMessage(),ex.getDescription());
        return new ResponseEntity<>(errorDetails,NOT_FOUND);
    }
    /**
     * Handle general Exception
     *
     **/
    @ExceptionHandler(Exception.class)
    protected  ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex){

        ErrorDetails errorDetails = new ErrorDetails(new Date(),"CD43",INTERNAL_SERVER_ERROR.toString(),ex.getMessage(),"Error interno en servidor, contactar al adminsitrador del sistema");
        LOGGER.error("error Exception: ",ex);
        return new ResponseEntity<>(errorDetails,INTERNAL_SERVER_ERROR);

    }

    /**
     * Handle HttpMessageNotReadableException. request JSON is malformed.
     *
     **/
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"ML43",BAD_REQUEST.toString(),ex.getMessage(),error);
        return new ResponseEntity<>(errorDetails,BAD_REQUEST);
    }

    /**
     * Handle ArithmeticException
     *
     **/
    @ExceptionHandler(ArithmeticExceptionCdpyme.class)
    protected ResponseEntity<ErrorDetails> handleAllRuntimeException(ArithmeticExceptionCdpyme ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"CD43",HttpStatus.BAD_REQUEST.toString(),ex.getMessage(),ex.getDescription());
        LOGGER.error("error ArithmeticException:",ex);
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }



    }






