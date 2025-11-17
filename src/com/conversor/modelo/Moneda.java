package com.conversor.modelo;

public class Moneda {
    private final String codigo;
    private final String nombre;

    public Moneda(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String codigo() {
        return codigo;
    }

    public String nombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
