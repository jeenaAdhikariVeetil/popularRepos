package com.challenge.popularRepo.exceptions;

import com.challenge.popularRepo.constants.ReposConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<String> handleException(DateTimeParseException ex) {
        return new ResponseEntity<String>(ReposConstants.INVALIDDATE, HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(WebClientRequestException.class)
    public ResponseEntity<String> handleException(WebClientRequestException ex) {
        return new ResponseEntity<String>(ReposConstants.NETWORKISSUE, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleException(ResponseStatusException  ex) {
        return new ResponseEntity<String>(ReposConstants.INTERNALSERVERERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
