package com.aktepe.shipment.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MyNotFoundError extends RuntimeException {
    public MyNotFoundError(String message) {
        super(message);
    }
}