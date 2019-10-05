package br.com.facef.informatica.exception.impl;

public class CustomBadRequestException extends RuntimeException {

    public CustomBadRequestException(String msg) {
        super(msg);
    }
}
