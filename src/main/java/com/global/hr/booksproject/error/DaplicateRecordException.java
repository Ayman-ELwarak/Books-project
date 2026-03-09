package com.global.hr.booksproject.error;

public class DaplicateRecordException extends RuntimeException {
    public DaplicateRecordException(String message) {
        super(message);
    }
}
