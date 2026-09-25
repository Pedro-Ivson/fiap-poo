package br.com.fiapride.model;

/**
 * Representa uma viagem solicitada por um passageiro e atendida por um veículo.
 */
public class Viagem {
    private final String destino;
    private double valor;
    private final Passageiro solicitante;
    private final Veiculo veiculoUtilizado;

    public Viagem(String destino, Passageiro solicitante, Veiculo veiculoUtilizado) {
        if (destino == null || destino.isBlank()) {
            throw new IllegalArgumentException("O destino da viagem é obrigatório.");
        }
        if (solicitante == null) {
            throw new IllegalArgumentException("O passageiro solicitante é obrigatório.");
        }
        if (veiculoUtilizado == null) {
            throw new IllegalArgumentException("O veículo utilizado é obrigatório.");
        }

        this.destino = destino.trim();
        this.valor = 0.0;
        this.solicitante = solicitante;
        this.veiculoUtilizado = veiculoUtilizado;
        System.out.println("Solicitação de viagem registrada para " + this.destino + ".");
    }

    public void exibirResumo() {
        System.out.println("\n--- Resumo da viagem ---");
        System.out.println("Destino: " + destino);
        System.out.println("Solicitante: " + solicitante.getNome());
        System.out.println("Veículo: " + veiculoUtilizado.getModelo()
                + " | Placa: " + veiculoUtilizado.getPlaca());
    }

    public String getDestino() {
        return destino;
    }

    public Passageiro getSolicitante() {
        return solicitante;
    }

    public Veiculo getVeiculoUtilizado() {
        return veiculoUtilizado;
    }
}
