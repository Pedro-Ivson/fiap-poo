package br.com.fiapride.main;

import br.com.fiapride.model.Veiculo;

/**
 * Executável separado para testar o objeto pessoal Veiculo.
 */
public class TesteVeiculo {
    public static void main(String[] args) {
        System.out.println("--- Teste do objeto pessoal: Veiculo ---");

        Veiculo veiculo = new Veiculo("Carlos", "ABC-1234");
        System.out.println("Proprietário: " + veiculo.getProprietario()
                + " | Placa: " + veiculo.getPlaca()
                + " | Combustível: " + veiculo.getCombustivel() + "L");

        veiculo.abastecer(50); // Cenário válido

        try {
            veiculo.consumir(20); // Cenário válido
        } catch (IllegalArgumentException erro) {
            System.out.println("Consumo rejeitado: " + erro.getMessage());
        }

        try {
            veiculo.consumir(100); // Cenário inválido
        } catch (IllegalArgumentException erro) {
            System.out.println("Consumo rejeitado: " + erro.getMessage());
        }

        try {
            veiculo.abastecer(-10); // Cenário inválido
        } catch (IllegalArgumentException erro) {
            System.out.println("Abastecimento rejeitado: " + erro.getMessage());
        }

        System.out.println("Combustível final: " + veiculo.getCombustivel() + "L");

        // Esta linha não compila e demonstra que o combustível está protegido:
        // veiculo.combustivel = -1;
    }
}
