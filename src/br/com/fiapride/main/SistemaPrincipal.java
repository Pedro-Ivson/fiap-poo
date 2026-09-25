package br.com.fiapride.main;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Viagem;
import br.com.fiapride.model.Veiculo;

/**
 * Executável principal do FiapRide.
 */
public class SistemaPrincipal {
    public static void main(String[] args) {
        System.out.println("--- Iniciando o Sistema FiapRide ---\n");

        Passageiro ana = new Passageiro("Ana Silva", "222.222.222-22");
        Passageiro carlos = new Passageiro("Carlos Souza", "333.333.333-33");

        System.out.println("--- Cadastro do veículo ---");
        Veiculo carroDoJoao = new Veiculo("ABC-1234", "Toyota Corolla");

        System.out.println("\n--- Solicitação da viagem ---");
        Viagem viagemDaAna = new Viagem("Avenida Paulista, 1000", ana, carroDoJoao);
        viagemDaAna.exibirResumo();

        System.out.println("\n--- Prova de passagem por referência ---");
        ana.adicionarSaldo(50.0);
        System.out.printf("Saldo da Ana consultado pela viagem: R$%.2f%n",
                viagemDaAna.getSolicitante().getSaldo());

        System.out.println("\n>>> Recarga do passageiro Carlos:");
        carlos.adicionarSaldo(12.5);

        System.out.println("\n--- Status dos passageiros ---");
        System.out.println("Passageiro: " + ana.getNome()
                + " | Saldo: R$ " + ana.getSaldo()
                + " | CPF: " + ana.getCpf());
        System.out.println("Passageiro: " + carlos.getNome()
                + " | Saldo: R$ " + carlos.getSaldo()
                + " | CPF: " + carlos.getCpf());

        System.out.println("\n--- Realizando viagens ---");
        System.out.println("Pagando viagem da passageira Ana:");
        ana.pagarViagem(20.0);

        System.out.println("\nPagando viagem do passageiro Carlos:");
        carlos.pagarViagem(20.0);

        System.out.println("\nTentando recarregar com valor negativo:");
        ana.adicionarSaldo(-500.0);

        System.out.println("\n--- Atualização do veículo ---");
        System.out.println("Veículo: " + carroDoJoao.getModelo()
                + " | Placa: " + carroDoJoao.getPlaca());
        carroDoJoao.atualizarPlaca("DEF-5678");

        // ERRO DE COMPILAÇÃO: não existe construtor sem os dados obrigatórios.
        // Veiculo carroFantasma = new Veiculo();

        // Esta linha não compila e demonstra que o atributo está protegido:
        // ana.saldo = -500.0;
    }
}
