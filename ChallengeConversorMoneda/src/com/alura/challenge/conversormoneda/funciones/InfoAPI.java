package com.alura.challenge.conversormoneda.funciones;

import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


public class InfoAPI {

    ArrayList<Double> valores = new ArrayList<>();


    public ArrayList<Double> obtenInfoAPI(String moneda) {

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

        String respuestaAPI = response.body();
        //System.out.println(respuestaAPI);

        Gson gson = new GsonBuilder().create();
        JsonObject respuestaEntera = gson.fromJson(respuestaAPI, JsonObject.class);
        JsonObject conversionRatios = respuestaEntera.getAsJsonObject("conversion_rates");
        MonedasDisponibles monedaPais = gson.fromJson(conversionRatios,MonedasDisponibles.class);

        //Siendo transparentes, esta parte la saqué de ChatGPT, aunque sí le pedí que me explique línea por línea
        // para entender bien
        MonedasDisponibles monedasDisponibles = new MonedasDisponibles("USD","ARS","BRL","COP");
        Set<String> monedasDeInteres = Set.of(
                monedasDisponibles.ARS(),
                monedasDisponibles.USD(),
                monedasDisponibles.BRL(),
                monedasDisponibles.COP()
                );


        for (Map.Entry<String, com.google.gson.JsonElement> entry : conversionRatios.entrySet()) {
            if (monedasDeInteres.contains((entry.getKey()))) {
                Double value = entry.getValue().getAsDouble();
                valores.add(value);
            }
        }

        return valores;


    }
}

