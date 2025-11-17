package com.conversor.servicio;

import com.conversor.modelo.RespuestaConversion;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ProveedorDeTasasApi {
    private static final String API_KEY = "a1290b72be4cfbf8cd503a09";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient cliente;
    private final Gson gson;

    public ProveedorDeTasasApi() {
        this.cliente = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public RespuestaConversion convertir(String base, String objetivo, double monto)
            throws IOException, InterruptedException {

        String url = BASE_URL + API_KEY + "/pair/" + base + "/" + objetivo + "/" + monto;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> respuesta = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(respuesta.body(), RespuestaConversion.class);
    }
}
