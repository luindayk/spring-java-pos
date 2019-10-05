package br.com.facef.informatica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestException {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response exception(Exception ex) {
        return new Response("Internal Server Error");
    }

    @ExceptionHandler(NoSuchFieldException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response exception(NoSuchFieldException ex) {
        return new Response("Bad Request");
    }
}
