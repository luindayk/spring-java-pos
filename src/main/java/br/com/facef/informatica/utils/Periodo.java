package br.com.facef.informatica.utils;

public enum Periodo {
    DIURNO(1), NOTURNO(2), INTEGRAL(3);

    private final int valor;

    Periodo(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
