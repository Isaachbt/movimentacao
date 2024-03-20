package com.mv.main.movimentacaos.empresa.exception;

public class ErrorInternal extends RuntimeException{

    public ErrorInternal() {
        super("Não foi possivel concluir o cadastro, tente novamnete");
    }

    public ErrorInternal(String message) {
        super(message);
    }
}
