package com.barbeqjue.digibooky.services.exceptions;

public class ResourceAlreadyPresentException extends DigiBookyException {
    public ResourceAlreadyPresentException(String field, String resource) {
        super(String.format("There is already a %s for the provided %s", resource, field));
    }
}
