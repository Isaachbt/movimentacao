package com.mv.main.movimentacaos.cliente.exceptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound() {
        super("Usuario não encontrado.");
    }

    public UserNotFound(String message) {
        super(message);
    }
}
