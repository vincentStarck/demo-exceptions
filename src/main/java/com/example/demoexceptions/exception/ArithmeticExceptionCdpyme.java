package com.example.demoexceptions.exception;

import lombok.Data;

public @Data class ArithmeticExceptionCdpyme extends  RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String description;
    public ArithmeticExceptionCdpyme(String message) {
        super(message);
    }
    public ArithmeticExceptionCdpyme(String message, String description) {
        super(message);
        this.description = description;

    }

    public ArithmeticExceptionCdpyme(String message,String description, Throwable throwable) {
        super(message,throwable);
        this.description = description;
    }
}
