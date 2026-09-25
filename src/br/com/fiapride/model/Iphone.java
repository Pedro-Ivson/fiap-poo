package br.com.fiapride.model;

/**
 * Especialização de celular que registra se o Face ID está ativo.
 */
public class Iphone extends Celular {
    private final boolean faceIdAtivo;

    public Iphone(String cor, int memoriaTotal, int memoriaInicial, Bateria bateria,
            boolean faceIdAtivo) {
        super(cor, memoriaTotal, memoriaInicial, bateria);
        this.faceIdAtivo = faceIdAtivo;
    }

    public boolean isFaceIdAtivo() {
        return faceIdAtivo;
    }
}
