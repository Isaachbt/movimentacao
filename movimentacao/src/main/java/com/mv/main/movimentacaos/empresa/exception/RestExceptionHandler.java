package com.mv.main.movimentacaos.empresa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EmpresaExists.class)
    private ResponseEntity<String> EmpresaExists(EmpresaExists e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Empresa já existe");
    }

    @ExceptionHandler(DataIntegrityViolation.class)
    private ResponseEntity<String> DataIntegrityViolation(DataIntegrityViolation e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Dados invalidos");
    }

    @ExceptionHandler(ErrorInternal.class)
    private ResponseEntity<String> ErrorInternal(ErrorInternal e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao tentar salvar.");
    }
}
