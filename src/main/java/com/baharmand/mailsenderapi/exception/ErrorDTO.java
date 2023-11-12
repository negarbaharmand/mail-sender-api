package com.baharmand.mailsenderapi.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder

public class ErrorDTO {
    private Integer errorCode;
    private String errorMessage;
    private LocalDateTime dateTime = LocalDateTime.now();

    public ErrorDTO(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
