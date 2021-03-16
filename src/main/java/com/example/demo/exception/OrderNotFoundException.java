package com.example.demo.exception;

public class OrderNotFoundException extends  RuntimeException{
    public OrderNotFoundException(long id) {
        super("Order with id: "+id+" not found");
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
