package br.com.fiapride.model;

/**
 * Veículo terrestre especializado para transportar passageiros em um carro.
 */
public class Carro extends Veiculo {
    private int capacidadePassageiros;

    public Carro(String placa, String modelo, int capacidadePassageiros) {
        super(placa, modelo);
        setCapacidadePassageiros(capacidadePassageiros);
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    private void setCapacidadePassageiros(int capacidadePassageiros) {
        if (capacidadePassageiros <= 0) {
            throw new IllegalArgumentException("A capacidade de passageiros deve ser maior que zero.");
        }

        this.capacidadePassageiros = capacidadePassageiros;
    }

    @Override
    public String calcularAutonomia() {
        double quilometrosRestantes = getNivelCombustivel() * 10.0;
        return "Autonomia: " + quilometrosRestantes + " km (Consumo de 10 km/l).";
    }
}
