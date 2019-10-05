package br.com.facef.informatica.utils;

public enum Turma {
    DIURNO(1), NOTURNO(2), INTEGRAL(3);

    private final int valor;

    Turma(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
