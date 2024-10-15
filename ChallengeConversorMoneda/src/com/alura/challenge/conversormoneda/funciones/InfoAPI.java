package com.alura.challenge.conversormoneda.funciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class InfoAPI {

    public void obtenInfoAPI(String moneda) {

        String enlace = "https://v6.exchangerate-api.com/v6/010c0f087cdbbb7942a4ac47/latest/" + moneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enlace))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        String currency = response.body();
        //System.out.println(currency);

        Gson gson = new GsonBuilder().create();
        MonedasDisponibles monedaPais = gson.fromJson(response.body(),MonedasDisponibles.class);
        System.out.println(monedaPais);
    }
}

