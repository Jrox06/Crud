package com.evaluacion.crud.execeptions;

import com.evaluacion.crud.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex){
        ErrorDto error = ErrorDto.builder().menssage(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ExceptionRuntimeHandler.class)
    public ResponseEntity<ErrorDto> exeptionRuntimeHandler(ExceptionRuntimeHandler ex){
        ErrorDto error = ErrorDto.builder().menssage(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}
