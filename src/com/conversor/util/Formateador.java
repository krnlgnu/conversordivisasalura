package com.conversor.util;

import java.text.Normalizer;
import java.util.Locale;

public class Formateador {
    public static String formatearNumero (double valor)
    {
        if (valor % 1 == 0) {
            return String.valueOf((long) valor);
        }

        // Si tiene decimales, mostramos 2 decimales
        return String.format("%.2f", valor);
    }

    public static String pluralizarNombreDivisa(String nombreDivisa, double cantidad) {
        if (nombreDivisa == null || nombreDivisa.isBlank())
            return nombreDivisa;

        // Si es singular numéricamente -> devolver la frase normalizada en minúsculas (singular)
        if (esSingular(cantidad)) {
            return normalizarMinusculas(nombreDivisa);
        }

        // Normalizar y separar en palabras
        String normal = normalizarMinusculas(nombreDivisa);
        String[] partes = normal.split("\\s+");

        for (int i = 0; i < partes.length; i++) {
            partes[i] = pluralizarPalabraSeguro(partes[i]);
        }

        return String.join(" ", partes);
    }

    private static boolean esSingular(double cantidad) {
        return Math.abs(cantidad - 1.0) < 1e-9;
    }

    // Normaliza (quita tildes) y pasa a minúsculas
    private static String normalizarMinusculas(String s) {
        return Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase(Locale.ROOT)
                .trim();
    }

    // Pluraliza una palabra de forma segura
    private static String pluralizarPalabraSeguro(String w) {
        if (w == null || w.isEmpty()) return w;

        // Si ya parece plural (termina en 's' y longitud > 1), la dejamos tal cual.
        if (w.length() > 1 && w.endsWith("s")) {
            return w;
        }

        char ultima = w.charAt(w.length() - 1);

        // z -> ...ces
        if (ultima == 'z') {
            return w.substring(0, w.length() - 1) + "ces";
        }

        // vocal -> +s
        if ("aeiou".indexOf(ultima) >= 0) {
            return w + "s";
        }

        // r, l, n -> +es
        if (ultima == 'r' || ultima == 'l' || ultima == 'n') {
            return w + "es";
        }

        // por defecto
        return w + "s";
    }

    public static String verboEquivaler(double cantidad) {
        return esSingular(cantidad) ? "equivale" : "equivalen";
    }
}
