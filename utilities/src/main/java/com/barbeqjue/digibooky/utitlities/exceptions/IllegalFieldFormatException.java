package com.barbeqjue.digibooky.utitlities.exceptions;

public class IllegalFieldFormatException extends DigiBookyException {
    public IllegalFieldFormatException(String field) {
        super(String.format("The format for your %s is not recognized", field));
    }
}
