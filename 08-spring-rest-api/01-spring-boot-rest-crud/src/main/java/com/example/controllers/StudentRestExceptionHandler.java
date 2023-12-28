package com.example.controllers;

import com.example.entity.StudentErrorResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentErrorResponse exception) {
        return new ResponseEntity<>(exception, HttpStatusCode.valueOf(exception.getStatus()));
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatusCode.valueOf(400).value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        errorResponse.setStackTrace(new StackTraceElement[] {});

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(400));
    }
}
