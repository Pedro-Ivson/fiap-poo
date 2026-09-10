package br.com.fiapride.main;

import br.com.fiapride.model.Celular;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;

public class SistemaPrincipal {
    public static void main(String[] args) {
        testarPassageiros();
        testarCelular();
        testarVeiculo();
    }

    private static void testarPassageiros() {
        System.out.println("=== Testes da classe Passageiro ===");

        Passageiro passageiro1 = new Passageiro("Ana Silva", "222");
        Passageiro passageiro2 = new Passageiro("Carlos Souza", "333");

        System.out.println("Passageiro: " + passageiro1.getNome() + " | CPF: " + passageiro1.getCpf());
        passageiro1.adicionarSaldo(50.0); // Cenário válido
        passageiro1.pagarViagem(20.0); // Cenário válido

        System.out.println("\nTentando adicionar saldo negativo:");
        passageiro1.adicionarSaldo(-10.0); // Cenário inválido

        System.out.println("Tentando pagar viagem sem saldo suficiente:");
        passageiro1.pagarViagem(100.0); // Cenário inválido

        System.out.println("Tentando pagar viagem com custo zero:");
        passageiro1.pagarViagem(0.0); // Cenário inválido

        System.out.println("\nPassageiro: " + passageiro2.getNome() + " | CPF: " + passageiro2.getCpf());
        passageiro2.adicionarSaldo(12.5); // Cenário válido
        System.out.println("Tentando pagar uma viagem de R$20,00:");
        passageiro2.pagarViagem(20.0); // Cenário inválido

        System.out.printf("Saldo final de %s: R$%.2f%n%n", passageiro1.getNome(), passageiro1.getSaldo());
    }

    private static void testarCelular() {
        System.out.println("=== Testes da classe Celular ===");

        Celular celular = new Celular("Preto", 128, 64);
        System.out.println("Celular " + celular.getCor() + " | Memória livre: " + celular.getMemoria() + "GB");

        celular.instalarAplicativo(10); // Cenário válido

        System.out.println("\nTentando instalar aplicativo de tamanho zero:");
        celular.instalarAplicativo(0); // Cenário inválido

        System.out.println("Tentando instalar aplicativo maior que a memória disponível:");
        celular.instalarAplicativo(100); // Cenário inválido

        celular.esvaziarMemoria(20); // Cenário válido

        System.out.println("\nTentando ultrapassar a memória total do celular:");
        celular.esvaziarMemoria(100); // Cenário inválido

        System.out.println("Memória final: " + celular.getMemoria() + "GB de " + celular.getMemoriaTotal() + "GB");
    }

    private static void testarVeiculo() {
        System.out.println("=== Testes da classe Veiculo ===");

        Veiculo veiculo = new Veiculo("Carlos", "ABC-1234");
        System.out.println("Dono: " + veiculo.getProprietario()
                + " | Placa: " + veiculo.getPlaca()
                + " | Combustivel: " + veiculo.getCombustivel() + "L");

        veiculo.abastecer(50);
        System.out.println("Apos abastecer 50L: " + veiculo.getCombustivel() + "L");

        try {
            veiculo.consumir(100);
        } catch (IllegalArgumentException erro) {
            System.out.println("Consumo rejeitado: " + erro.getMessage());
        }

        try {
            veiculo.abastecer(-10);
        } catch (IllegalArgumentException erro) {
            System.out.println("Abastecimento rejeitado: " + erro.getMessage());
        }

        System.out.println("Combustivel final: " + veiculo.getCombustivel() + "L");
    }
}
