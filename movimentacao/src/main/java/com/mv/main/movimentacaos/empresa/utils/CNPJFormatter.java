package com.mv.main.movimentacaos.empresa.utils;

public class CNPJFormatter {
    public static String format(String cnpj) {

        cnpj = cnpj.replaceAll("[^\\d]", "");


        if (cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ deve conter 14 dígitos numéricos");
        }

        return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." +
                cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12);
    }
}
