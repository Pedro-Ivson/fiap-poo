package br.com.fiapride.model;

/**
 * Veículo terrestre especializado para representar uma moto.
 */
public class Moto extends Veiculo {
    private boolean isEletrica;

    public Moto(String placa, String modelo, boolean isEletrica) {
        super(placa, modelo);
        this.isEletrica = isEletrica;
    }

    public boolean isEletrica() {
        return isEletrica;
    }
}
