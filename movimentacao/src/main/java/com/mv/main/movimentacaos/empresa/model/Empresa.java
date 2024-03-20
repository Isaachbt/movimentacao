package com.mv.main.movimentacaos.empresa.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @CNPJ(message = "CNPJ invalido")
    private String CNPJ;

    private Double saldo;
}
