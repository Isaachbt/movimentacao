package com.mv.main.movimentacaos.empresa.exception;

public class ParamtInvalido extends RuntimeException{

    public ParamtInvalido() {
        super("Paramentro passado e invalido.");
    }

    public ParamtInvalido(String message) {
        super(message);
    }
}
