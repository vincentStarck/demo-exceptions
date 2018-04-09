package com.example.demoexceptions.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
public @Data class ErrorDetails {
    private Date timestamp;
    private String code;
    private String httpCode;
    private String message;
    private String description;

}
