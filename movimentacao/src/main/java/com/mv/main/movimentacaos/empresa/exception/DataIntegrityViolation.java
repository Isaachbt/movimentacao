package com.mv.main.movimentacaos.empresa.exception;

public class DataIntegrityViolation extends RuntimeException{

    public DataIntegrityViolation() {
        super();
    }

    public DataIntegrityViolation(String message) {
        super(message);
    }
}
