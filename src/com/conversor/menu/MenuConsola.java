package com.conversor.menu;

import com.conversor.modelo.Moneda;
import com.conversor.modelo.ParDivisa;
import com.conversor.modelo.RespuestaConversion;
import com.conversor.servicio.ProveedorDeTasasApi;
import com.conversor.util.Formateador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuConsola {
    private final Scanner scanner = new Scanner(System.in);
    private final ProveedorDeTasasApi api = new ProveedorDeTasasApi();
    private final List<ParDivisa> pares = new ArrayList<>();

    public MenuConsola() {
        Moneda usd = new Moneda("USD", "Dólar estadounidense");
        Moneda ars = new Moneda("ARS", "Peso argentino");
        Moneda brl = new Moneda("BRL", "Real brasileño");
        Moneda cop = new Moneda("COP", "Peso colombiano");

        pares.add(new ParDivisa(usd, ars));
        pares.add(new ParDivisa(ars, usd));
        pares.add(new ParDivisa(usd, brl));
        pares.add(new ParDivisa(brl, usd));
        pares.add(new ParDivisa(usd, cop));
        pares.add(new ParDivisa(cop, usd));
    }

    public void iniciar() {

        while (true) {
            System.out.println("\n=== Conversor de Divisas ===");
            System.out.println("Seleccione un par para convertir:");

            for (int i = 0; i < pares.size(); i++) {
                System.out.println((i + 1) + ") " + pares.get(i));
            }
            System.out.println("0) Salir");

            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                break;
            }

            if (opcion < 1 || opcion > pares.size()) {
                System.out.println("Opción inválida.");
                continue;
            }

            ParDivisa par = pares.get(opcion - 1);
            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            try {
                RespuestaConversion r = api.convertir(par.base().codigo(), par.objetivo().codigo(), monto);

                if (!r.result().equals("success")) {
                    System.out.println("Error al consultar la API.");
                    continue;
                }

                System.out.println("\nResultado:");
                System.out.println("La conversión de "
                        + Formateador.formatearNumero(monto)  + " " + Formateador.pluralizarNombreDivisa(par.base().nombre(), monto)
                        + " a " + Formateador.pluralizarNombreDivisa(par.objetivo().nombre(), r.conversion_result())
                        + " es: " + Formateador.formatearNumero(r.conversion_result()));
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al conectar con la API: " + e.getMessage());
            }
        }
    }
}
