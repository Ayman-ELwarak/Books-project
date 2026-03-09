package com.global.hr.booksproject.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RecordNotFoundExecption.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundExecption ex){
        ErrorResponse error = new ErrorResponse("Failed", ex.getMessage(), null);
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(DaplicateRecordException.class)
    public ResponseEntity<?> handleDuplicateRecordException(DaplicateRecordException ex){
        ErrorResponse error = new ErrorResponse("Failed", ex.getMessage(), null);
        return ResponseEntity.status(409).body(error);
    }
}
