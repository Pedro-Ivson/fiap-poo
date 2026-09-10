package br.com.fiapride.main;

import br.com.fiapride.model.Passageiro;

/**
 * Executável principal do FiapRide.
 */
public class SistemaPrincipal {
    public static void main(String[] args) {
        System.out.println("--- Iniciando o Sistema FiapRide ---\n");

        Passageiro passageiro1 = new Passageiro("Ana Silva", "222.222.222-22");
        Passageiro passageiro2 = new Passageiro("Carlos Souza", "333.333.333-33");

        System.out.println(">>> Recarga do passageiro 1:");
        passageiro1.adicionarSaldo(50.0);

        System.out.println(">>> Recarga do passageiro 2:");
        passageiro2.adicionarSaldo(12.5);

        System.out.println("\n--- Status dos passageiros ---");
        System.out.println("Passageiro: " + passageiro1.getNome()
                + " | Saldo: R$ " + passageiro1.getSaldo()
                + " | CPF: " + passageiro1.getCpf());
        System.out.println("Passageiro: " + passageiro2.getNome()
                + " | Saldo: R$ " + passageiro2.getSaldo()
                + " | CPF: " + passageiro2.getCpf());

        System.out.println("\n--- Realizando viagens ---");
        System.out.println("Pagando viagem do passageiro 1 (Ana):");
        passageiro1.pagarViagem(20.0);

        System.out.println("\nPagando viagem do passageiro 2 (Carlos):");
        passageiro2.pagarViagem(20.0);

        System.out.println("\nTentando recarregar com valor negativo:");
        passageiro1.adicionarSaldo(-500.0);

        // Esta linha não compila e demonstra que o atributo está protegido:
        // passageiro1.saldo = -500.0;
    }
}
