package com.alurachallenge.convertersormonedas;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Conversor {

    private static final String API_KEY = "02886a2656ff772fb456928f";

    // Método público llamado desde ConversorApp
    public static String convertir(String base, String destino) {
        double cantidad = leerCantidad(base);
        return convertir(base, destino, cantidad);
    }

    // Método sobrecargado que recibe la cantidad como parámetro (útil para menú fijo o pruebas)
    public static String convertir(String base, String destino, double cantidad) {
        try {
            Moneda data = obtenerTasas(base);
            if (data != null && data.getConversion_rates().containsKey(destino)) {
                double tasa = data.getConversion_rates().get(destino);
                double resultado = cantidad * tasa;

                String timestamp = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                String registro = String.format(
                        "[%s] %.2f %s = %.2f %s (Tasa: %.4f)",
                        timestamp, cantidad, base, resultado, destino, tasa
                );

                System.out.println(registro);
                return registro;
            } else {
                System.out.println("No se encontró la tasa para la moneda destino.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
            return null;
        }
    }

    // Método auxiliar para leer cantidad desde consola
    private static double leerCantidad(String base) {
        Scanner scanner = new Scanner(System.in);
        double cantidad = 0;
        System.out.printf("Ingrese cantidad en %s: ", base);
        while (true) {
            try {
                cantidad = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número: ");
            }
        }
        return cantidad;
    }

    // Lógica para consultar la API
    private static Moneda obtenerTasas(String tipoMoneda) throws Exception {
        String urlStr = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + tipoMoneda;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Error al conectar con la API: Código HTTP " + conn.getResponseCode());
        }

        try (InputStreamReader reader = new InputStreamReader(conn.getInputStream())) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Moneda.class);
        }
    }
}
