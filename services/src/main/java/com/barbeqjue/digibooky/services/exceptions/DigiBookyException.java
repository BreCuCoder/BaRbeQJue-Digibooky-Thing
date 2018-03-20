package com.barbeqjue.digibooky.services.exceptions;

public abstract class DigiBookyException extends RuntimeException {

    public DigiBookyException(String message) {
        super(message);
    }

}