package com.barbeqjue.digibooky.services.exceptions;

public class EmptyFieldException extends DigiBookyException {
    public EmptyFieldException(String field) {
        super(String.format("You have to provide a value for this field : %s", field));
    }
}
