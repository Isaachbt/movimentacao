package com.mv.main.movimentacaos.empresa.utils;

import com.mv.main.movimentacaos.empresa.Enum.TipoTransacao;

public class Taxando {

    public static double taxandoValor(String t,double valor) {
        double taxa;
        double valorRestante;
        if (t.equalsIgnoreCase(TipoTransacao.DEPOSITO.toString())) {
            taxa = 0.1 * valor;
            valorRestante = valor - taxa;
            return valorRestante;
        } else {
            taxa = 0.3 * valor;
            valorRestante = valor - taxa;
            return valorRestante;
        }
    }
}
