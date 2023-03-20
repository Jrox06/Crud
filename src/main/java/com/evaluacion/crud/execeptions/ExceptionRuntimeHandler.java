package com.evaluacion.crud.execeptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class  ExceptionRuntimeHandler extends RuntimeException{
    private HttpStatus httpStatus;

    public ExceptionRuntimeHandler(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
