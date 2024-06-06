package com.damian.springbootactivemq.exception;

import com.damian.springbootactivemq.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class Advisor {
    @Autowired
    private Response response;
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Response> exceptionHandler(Exception e) {
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("An error occurred while processing the request : "+e.getLocalizedMessage());
        response.setData(null);
        return ResponseEntity.ok(response);
    }
}
