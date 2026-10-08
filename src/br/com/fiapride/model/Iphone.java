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

    @Override
    public String descreverSeguranca() {
        if (faceIdAtivo) {
            return "iPhone: autenticação biométrica com Face ID ativa.";
        }

        return "iPhone: use o código de acesso; Face ID desativado.";
    }
}
