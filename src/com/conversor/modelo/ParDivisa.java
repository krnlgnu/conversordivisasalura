package com.conversor.modelo;

public class ParDivisa {
    private Moneda base;
    private Moneda objetivo;

    public ParDivisa(Moneda base, Moneda objetivo) {
        this.base = base;
        this.objetivo = objetivo;
    }

    public Moneda base() {
        return base;
    }

    public Moneda objetivo() {
        return objetivo;
    }

    @Override
    public String toString() {
        return base().codigo() + " (" + base().nombre() + ") → " +
                objetivo().codigo() + " (" + objetivo().nombre() + ")";
    }
}
