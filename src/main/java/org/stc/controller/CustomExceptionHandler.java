package org.stc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.stc.controller.errors.Error;
import org.stc.controller.errors.ForbiddenException;
import org.stc.controller.errors.NotFoundException;

@ControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException exception) {
        Error error = new Error();
        error.setMessage(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

}
