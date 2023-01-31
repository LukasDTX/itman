package com.lukasdtx.itman.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
