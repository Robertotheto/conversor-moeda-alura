package com.conversor.moeda;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoeda {
    public Moeda buscaMoeda(String base_code, String target_code, double value) {
        String chave = "5e3d0f3fa9b48694e4a65fee";
        URI data = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/pair/"+ base_code + "/"+target_code+"/"+ value);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(data)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moeda.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a moeda informada.");
        }

    }
}