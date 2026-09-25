package br.com.fiapride.model;

/**
 * Especialização de celular que registra sua versão do Android.
 */
public class Android extends Celular {
    private final String versaoAndroid;

    public Android(String cor, int memoriaTotal, int memoriaInicial, Bateria bateria,
            String versaoAndroid) {
        super(cor, memoriaTotal, memoriaInicial, bateria);
        if (versaoAndroid == null || versaoAndroid.isBlank()) {
            throw new IllegalArgumentException("A versão do Android é obrigatória.");
        }

        this.versaoAndroid = versaoAndroid.trim();
    }

    public String getVersaoAndroid() {
        return versaoAndroid;
    }
}
