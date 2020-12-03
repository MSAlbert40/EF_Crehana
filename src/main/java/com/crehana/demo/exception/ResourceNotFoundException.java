package com.crehana.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String teacher, String id, Long teacherId){
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
}
