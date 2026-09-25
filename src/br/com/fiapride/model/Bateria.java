package br.com.fiapride.model;

/**
 * Representa a bateria associada a um celular.
 */
public class Bateria {
    private final int capacidadeMah;

    public Bateria(int capacidadeMah) {
        if (capacidadeMah <= 0) {
            throw new IllegalArgumentException("A capacidade da bateria deve ser maior que zero.");
        }

        this.capacidadeMah = capacidadeMah;
    }

    public int getCapacidadeMah() {
        return capacidadeMah;
    }
}
