package com.enigma.exception;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException() {
        super("Unathorized");
    }
}
