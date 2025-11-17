package com.conversor.modelo;

public class Moneda {
    private String codigo;
    private String nombre;

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

    //Este overrride se utlizara futuramente para escalar el proyecto a otras divisas
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
