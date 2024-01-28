package com.slloww.lgpd.handlerExceptions;

import com.slloww.lgpd.services.exceptions.EmailAlreadyExists;
import com.slloww.lgpd.services.exceptions.ErrorGeneratingToken;
import com.slloww.lgpd.services.exceptions.UserNotFoundException;
import com.slloww.lgpd.services.exceptions.UsernameAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(UsernameAlreadyExists.class)
    public ResponseEntity<String> UsernameAlreadyExists(UsernameAlreadyExists exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<String> EmailAlreadyExists(EmailAlreadyExists exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> UserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ErrorGeneratingToken.class)
    public ResponseEntity<String> ErrorGeneratingToken(ErrorGeneratingToken exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }





}