package com.mv.main.movimentacaos.cliente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record UserDTO(
        @NotBlank(message = "Login cant be null")
        String login,
        @CPF(message = "CPF deve conter 11 numeros")
        String CPF
) {
}
