package com.emerson.crud.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice permite que você trate exceções de maneira global em todo o aplicativo

@RestControllerAdvice
public class RequestsExceptionHandler {
    //@ExceptionHandler oferece uma maneira de lidar com exceções específicas de maneira mais granular.
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> threat404(){
        ExceptionDTO response = new ExceptionDTO("Data not found with provided ID", 404);
        return ResponseEntity.badRequest().body(response);
    }
}

