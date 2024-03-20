package com.mv.main.movimentacaos.empresa.service;

import com.mv.main.movimentacaos.empresa.Enum.TipoTransacao;
import com.mv.main.movimentacaos.empresa.model.Empresa;
import com.mv.main.movimentacaos.empresa.repository.EmpresaRepository;
import com.mv.main.movimentacaos.empresa.utils.WebHook;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class TransacoesServiceTest {

    @Test
    public void testAdicionarTaxaTransacao_Saque() {

        EmpresaRepository repository = mock(EmpresaRepository.class);
        WebHook webHook = mock(WebHook.class);
        TransacoesService transacoesService = mock(TransacoesService.class);

        String cnpj = "49841400000119";
        String transacao = TipoTransacao.SAQUE.toString();
        double valor = 100.0;
        Empresa empresa = new Empresa();
        empresa.setSaldo(200.0);
        when(repository.findByCNPJ(anyString())).thenReturn(empresa);
        doNothing().when(transacoesService).adcionarTaxaTransacao(anyString(), anyString(), anyDouble());

        try {
            transacoesService.adcionarTaxaTransacao(cnpj, transacao, valor);
        } catch (Exception e) {
            assertEquals(150.0, empresa.getSaldo(), 0.01);
            verify(webHook).enviarMenssagem(transacao, valor);
        }
    }
}