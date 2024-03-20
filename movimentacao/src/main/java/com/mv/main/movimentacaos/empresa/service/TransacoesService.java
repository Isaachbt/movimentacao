package com.mv.main.movimentacaos.empresa.service;

import com.mv.main.movimentacaos.empresa.Enum.TipoTransacao;
import com.mv.main.movimentacaos.empresa.exception.*;
import com.mv.main.movimentacaos.empresa.model.Empresa;
import com.mv.main.movimentacaos.empresa.repository.EmpresaRepository;
import com.mv.main.movimentacaos.empresa.service.inter.TransacoesServiceInter;
import com.mv.main.movimentacaos.empresa.utils.CNPJFormatter;
import com.mv.main.movimentacaos.empresa.utils.Taxando;
import com.mv.main.movimentacaos.empresa.utils.WebHook;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class TransacoesService implements TransacoesServiceInter {
    @Autowired
    EmpresaRepository repository;
    @Override
    public void adcionarTaxaTransacao(String cnpj, String transacao, double valor)
            throws EmpresaNotFound,DataIntegrityViolation,ErrorInternal, SaldoInvalido,ParamtInvalido,ValorPassadoInvalido {
        Empresa empresa = repository.findByCNPJ(CNPJFormatter.format(cnpj));
        if (empresa == null){
            throw new EmpresaNotFound();
        }

        if (!(transacao.equalsIgnoreCase(TipoTransacao.SAQUE.toString()) || transacao.equalsIgnoreCase(TipoTransacao.DEPOSITO.toString()))){
            throw new ParamtInvalido();
        }
        double saldo = empresa.getSaldo();

        if (valor == 0){
            throw new ValorPassadoInvalido();
        }

            if (transacao.equalsIgnoreCase(TipoTransacao.SAQUE.toString())){
                if (saldo < valor){
                    throw new SaldoInvalido();
                }else{
                    empresa.setSaldo(saldo-Taxando.taxandoValor(transacao,valor));
                }
            }
            if (transacao.equalsIgnoreCase(TipoTransacao.DEPOSITO.toString())){
                empresa.setSaldo(saldo+Taxando.taxandoValor(transacao,valor));
            }

            try {
                repository.save(empresa);
                WebHook.enviarMenssagem(transacao,valor);
            }catch (DataIntegrityViolationException e){
                throw new  DataIntegrityViolation();
            }catch (PersistenceException e){
                throw new ErrorInternal();
            }
    }

}
