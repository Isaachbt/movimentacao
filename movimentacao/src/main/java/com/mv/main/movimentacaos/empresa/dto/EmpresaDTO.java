package com.mv.main.movimentacaos.empresa.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record EmpresaDTO(
        @NotBlank
        String nome,
        @CNPJ(message = "CNPJ invalido")
        String CNPJ,
        double saldo
) {
}
