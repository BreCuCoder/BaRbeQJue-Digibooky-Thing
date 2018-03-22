package com.barbeqjue.digibooky.api.actor.member;

import com.barbeqjue.digibooky.utitlities.exceptions.EmptyFieldException;
import com.barbeqjue.digibooky.utitlities.exceptions.IllegalFieldFormatException;
import com.barbeqjue.digibooky.utitlities.exceptions.ResourceAlreadyPresentException;
import com.barbeqjue.digibooky.utitlities.exceptions.UnknownResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"com.barbeqjue.digibooky"})
public class MemberControllerAdvice {

    @ExceptionHandler(UnknownResourceException.class)
    public ResponseEntity<String> convertUnknownIdException(final UnknownResourceException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyPresentException.class)
    public ResponseEntity<String> convertResourceAlreadyPresentException(final ResourceAlreadyPresentException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalFieldFormatException.class)
    public ResponseEntity<String> convertIllegalFieldFormatException(final IllegalFieldFormatException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<String> convertEmptyFieldException(final EmptyFieldException exception) {
        return new ResponseEntity<>(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

}
