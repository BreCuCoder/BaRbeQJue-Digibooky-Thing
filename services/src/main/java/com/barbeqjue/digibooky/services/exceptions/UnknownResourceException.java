package com.barbeqjue.digibooky.services.exceptions;

public class UnknownResourceException extends DigiBookyException {

    public UnknownResourceException(String field, String resource) {
        super(String.format("We could not find a %s for the provided %s", resource, field));
    }
}