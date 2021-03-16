package com.example.demo.exception;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException() {
    }

    public PetNotFoundException(String message) {
        super(message);
    }

    public PetNotFoundException(long id) {
        super("Pet with id: "+id+" not found");
    }
}
