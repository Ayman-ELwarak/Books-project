package com.global.hr.booksproject.error;

public class RecordNotFoundExecption extends RuntimeException{
    public RecordNotFoundExecption(String message) {
        super(message);
    }
}
