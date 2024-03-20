package com.mv.main.movimentacaos.empresa.controller;

import com.mv.main.movimentacaos.empresa.Enum.TipoTransacao;
import com.mv.main.movimentacaos.empresa.service.inter.TransacoesServiceInter;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacoesServiceInter transacoesService;

    @PostMapping("/{cnpj}/{tipoTransacao}/{valor}")
    public ResponseEntity<Object> adicionarTaxa(@PathVariable @NotBlank(message = "CNPJ não pode ser nulo") String cnpj,
                                        @PathVariable @NotBlank(message = "Transação precisa ser passada") String tipoTransacao,
                                        @PathVariable @NotNull(message = "Não pode ser 0")  double valor) {
        transacoesService.adcionarTaxaTransacao(cnpj,tipoTransacao,valor);
        return ResponseEntity.status(HttpStatus.OK).body(tipoTransacao+" realizado com sucesso, no valor de: "+valor);
    }
}
