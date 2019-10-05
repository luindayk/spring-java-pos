package br.com.facef.informatica.exception.impl;

public class CustomNotFoundException extends RuntimeException {

    public CustomNotFoundException (String msg) {
        super(msg);
    }
}
