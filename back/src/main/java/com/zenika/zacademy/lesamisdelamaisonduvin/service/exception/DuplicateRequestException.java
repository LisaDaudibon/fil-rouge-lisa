package com.zenika.zacademy.lesamisdelamaisonduvin.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateRequestException extends Exception{
    public DuplicateRequestException() {
        super("This ressource already exists in database");
    }
}
