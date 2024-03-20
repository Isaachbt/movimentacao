package com.mv.main.movimentacaos.empresa.exception;

public class SaldoInvalido extends RuntimeException{

    public SaldoInvalido() {
        super("Saldo invalido");
    }

    public SaldoInvalido(String message) {
        super(message);
    }
}
