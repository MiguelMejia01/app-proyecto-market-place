package com.marketplace.proyecto.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime dateTime;
    private final String path;
}
