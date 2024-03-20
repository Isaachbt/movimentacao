package com.mv.main.movimentacaos.empresa.exception;

public class EmpresaExists extends RuntimeException{

    public EmpresaExists() {
        super("Empresa já existe");
    }

    public EmpresaExists(String message) {
        super(message);
    }
}
