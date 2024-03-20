package com.mv.main.movimentacaos.empresa.model;


import com.mv.main.movimentacaos.empresa.Enum.TipoTransacao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.HashMap;
import java.util.Map;
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
//    private Map<TipoTransacao, Double> taxas;
//    public Empresa() {
//        this.taxas = new HashMap<>();
//        this.taxas.put(TipoTransacao.DEPOSITO, 0.0);
//        this.taxas.put(TipoTransacao.SAQUE, 0.0);
//    }
}
