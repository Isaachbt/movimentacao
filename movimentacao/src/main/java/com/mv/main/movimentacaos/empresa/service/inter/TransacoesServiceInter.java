package com.mv.main.movimentacaos.empresa.service.inter;

import com.mv.main.movimentacaos.empresa.Enum.TipoTransacao;

public interface TransacoesServiceInter {

    void adcionarTaxaTransacao(String cnpj, String transacao,double valor);
}
