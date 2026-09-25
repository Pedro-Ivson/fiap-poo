package br.com.fiapride.main;

import br.com.fiapride.model.Veiculo;

/**
 * Demonstra a criação de um veículo e a atualização validada da placa.
 */
public class TesteVeiculo {
    public static void main(String[] args) {
        System.out.println("--- Teste do construtor de Veiculo ---");

        Veiculo meuCarro = new Veiculo("ABC-1234", "Toyota Corolla");
        System.out.println("Modelo: " + meuCarro.getModelo()
                + " | Placa: " + meuCarro.getPlaca());

        meuCarro.atualizarPlaca("DEF-5678"); // Atualização válida
        meuCarro.atualizarPlaca("   "); // Atualização inválida; mantém a placa anterior

        System.out.println("Placa final: " + meuCarro.getPlaca());

        // ERRO DE COMPILAÇÃO: o construtor exige placa e modelo.
        // Veiculo carroFantasma = new Veiculo();
    }
}
