package com.example.UserManagement.Exception;

import com.example.UserManagement.payloads.ApiResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFoundHandler(ResourceNotFoundException ex){
        String message= ex.getMessage();
        ApiResponse api=new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(api, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> HandleMethodNotFound(MethodArgumentNotValidException ex){
        Map<String,String> res=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String FieldName=((FieldError)error).getField();
            String message= error.getDefaultMessage();
            res.put(FieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(res, HttpStatus.BAD_REQUEST);
    }
}

