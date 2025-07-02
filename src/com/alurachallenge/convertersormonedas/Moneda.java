package com.alurachallenge.convertersormonedas;

import java.util.Map;
import java.util.TreeMap;

public class Moneda {
    private String base_code;
    private Map<String, Double> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moneda base: ").append(base_code).append("\n");
        sb.append("Tasas de conversión:\n");

        // Ordenar alfabéticamente usando TreeMap
        Map<String, Double> tasasOrdenadas = new TreeMap<>(conversion_rates);
        for (Map.Entry<String, Double> entry : tasasOrdenadas.entrySet()) {
            sb.append("  ").append(entry.getKey())
                    .append(": ").append(String.format("%.4f", entry.getValue()))
                    .append("\n");
        }

        return sb.toString();
    }
}
