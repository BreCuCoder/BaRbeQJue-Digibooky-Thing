package com.barbeqjue.digibooky.utitlities.exceptions;

public class ResourceAlreadyPresentException extends DigiBookyException {
    public ResourceAlreadyPresentException(String field, String resource) {
        super(String.format("There is already a %s for the provided %s", resource, field));
    }
}
