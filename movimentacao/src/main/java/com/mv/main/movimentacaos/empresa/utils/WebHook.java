package com.mv.main.movimentacaos.empresa.utils;

import com.mv.main.movimentacaos.empresa.Enum.TipoTransacao;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebHook {
    private static String webhookUrl = "https://webhook.site/d6f3bf6e-468b-4417-b473-cd9abb48021b";
    public static void enviarMenssagem(String transacoes,double valor)
    {
        URL url = null;

        try {
            url = new URL(webhookUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            String msg;
            if (transacoes.equalsIgnoreCase(TipoTransacao.DEPOSITO.toString())){
                msg = "Um deposito foi feito com sucesso, no valor de: "+valor;
            }else {
                msg = "Um saque foi feito com sucesso, no valor de: "+valor;
            }
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = msg.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            conn.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
