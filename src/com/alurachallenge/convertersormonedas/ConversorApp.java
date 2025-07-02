package com.alurachallenge.convertersormonedas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorApp {
    private static final List<String> historial = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.print("""
                **************************************************
                *       Bienvenido/a al conversor de moneda      *
                **************************************************
                *  1. USD -> ARS                                 *
                *  2. ARS -> USD                                 *
                *  3. USD -> BRL                                 *
                *  4. BRL -> USD                                 *
                *  5. USD -> COP                                 *
                *  6. COP -> USD                                 *
                *  7. Conversión personalizada                   *
                *  8. Ver historial de conversiones              *
                *  9. Salir                                      *
                **************************************************
                Elige una opción válida: 
                """);

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intenta de nuevo.\n");
                continue;
            }

            switch (opcion) {
                case 1 -> guardar(Conversor.convertir("USD", "ARS"));
                case 2 -> guardar(Conversor.convertir("ARS", "USD"));
                case 3 -> guardar(Conversor.convertir("USD", "BRL"));
                case 4 -> guardar(Conversor.convertir("BRL", "USD"));
                case 5 -> guardar(Conversor.convertir("USD", "COP"));
                case 6 -> guardar(Conversor.convertir("COP", "USD"));
                case 7 -> {
                    System.out.print("Ingrese moneda base (ej. USD): ");
                    String base = scanner.nextLine().trim().toUpperCase();

                    System.out.print("Ingrese moneda destino (ej. EUR): ");
                    String destino = scanner.nextLine().trim().toUpperCase();

                    guardar(Conversor.convertir(base, destino));
                }
                case 8 -> {
                    System.out.println("\n===== Historial de Conversiones =====");
                    if (historial.isEmpty()) {
                        System.out.println("No hay conversiones registradas.");
                    } else {
                        historial.forEach(System.out::println);
                    }
                    System.out.println("=====================================\n");
                }
                case 9 -> System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                default -> System.out.println("Opción inválida. Intenta de nuevo.\n");
            }

        } while (opcion != 9);
    }

    private static void guardar(String resultado) {
        if (resultado != null) {
            historial.add(resultado);
        }
    }
}
