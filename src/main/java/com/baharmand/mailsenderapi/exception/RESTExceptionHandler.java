package com.baharmand.mailsenderapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@ControllerAdvice  //Used in Spring Framework and indicates that this class is exception handler
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        StringBuilder errorDetails = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorDetails.append(fieldError.getDefaultMessage());
            errorDetails.append(", ");
        });
        ErrorDTO dto = new ErrorDTO(HttpStatus.BAD_REQUEST.value(), errorDetails.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> illegalArgumentException(IllegalArgumentException ex) {
        ErrorDTO dto = new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }


    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorDTO> handleEmailException(EmailException ex) {
        ErrorDTO dto = new ErrorDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(Exception ex) {
        String uuid = UUID.randomUUID().toString();
        System.out.println("------------------------");
        System.out.println("ERROR ID: " + uuid);
        ex.printStackTrace();
        System.out.println("------------------------");

        ErrorDTO dto = new ErrorDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Call Support Team. ERROR ID:" + uuid);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dto);
    }


}
