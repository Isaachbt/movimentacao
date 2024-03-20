package com.mv.main.movimentacaos.empresa.exception;

public class EmpresaNotFound extends RuntimeException{
    public EmpresaNotFound() {
        super("Empresa não encontrada");
    }

    public EmpresaNotFound(String message) {
        super(message);
    }
}
