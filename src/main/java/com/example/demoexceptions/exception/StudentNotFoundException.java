package com.example.demoexceptions.exception;

import lombok.Data;

public @Data class StudentNotFoundException extends RuntimeException {
    private String description;
    public StudentNotFoundException(String message) {
        super(message);
    }
    public StudentNotFoundException(String message, String description) {
        super(message);
        this.description = description;

    }
    public StudentNotFoundException(String message,Throwable throwable) {
        super(message,throwable);
    }

}
