package com.mv.main.movimentacaos.empresa.exception;

public class ValorPassadoInvalido extends RuntimeException{

    public ValorPassadoInvalido() {
        super("Valor passado e invalido");
    }

    public ValorPassadoInvalido(String message) {
        super(message);
    }
}
