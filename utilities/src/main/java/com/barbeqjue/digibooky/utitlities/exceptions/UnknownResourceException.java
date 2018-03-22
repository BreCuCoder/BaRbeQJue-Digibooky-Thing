package com.barbeqjue.digibooky.utitlities.exceptions;

public class UnknownResourceException extends DigiBookyException {

    public UnknownResourceException(String field, String resource) {
        super(String.format("We could not find a %s for the provided %s", resource, field));
    }
}