package br.com.fiapride.main;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;
import java.util.ArrayList;
import java.util.List;

/**
 * Executável principal do FiapRide.
 */
public class SistemaPrincipal {
    public static void main(String[] args) {
        System.out.println("--- Iniciando o Sistema FiapRide ---\n");

        Passageiro ana = new Passageiro("Ana Silva", "222.222.222-22");
        Passageiro carlos = new Passageiro("Carlos Souza", "333.333.333-33");

        System.out.println("--- FIAPRIDE: Teste de frota ---");
        Carro uberX = new Carro("ABC-1234", "Toyota Corolla", 4);
        Moto mottu = new Moto("ABC-9999", "Caloi City", true);

        System.out.println("Carro modelo: " + uberX.getModelo()
                + " | Placa: " + uberX.getPlaca());
        System.out.println("Vagas para passageiros: " + uberX.getCapacidadePassageiros());
        System.out.println("\nMoto modelo: " + mottu.getModelo()
                + " | Placa: " + mottu.getPlaca());
        if (mottu.isEletrica()) {
            System.out.println("Atenção: esta moto é elétrica.");
        }

        System.out.println("\n--- Relatório polimórfico de autonomia da frota ---");
        List<Veiculo> frota = new ArrayList<>();
        frota.add(uberX);
        // O cálculo de 35 km/l da aula representa uma moto a combustão.
        frota.add(new Moto("DEF-5678", "Honda CG 160", false));

        for (Veiculo veiculo : frota) {
            System.out.println("Veículo: " + veiculo.getModelo());
            veiculo.abastecer(50);
            System.out.println(veiculo.calcularAutonomia());
            System.out.println("---------------------------------------");
        }

        System.out.println("\n--- Solicitação da viagem ---");
        Viagem viagemDaAna = new Viagem("Avenida Paulista, 1000", ana, uberX);
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

        System.out.println("\n--- Atualização do veículo herdada por Carro ---");
        System.out.println("Veículo: " + uberX.getModelo()
                + " | Placa: " + uberX.getPlaca());
        uberX.atualizarPlaca("DEF-5678");

        // ERRO DE COMPILAÇÃO: o construtor da subclasse também exige os dados do veículo.
        // Carro carroFantasma = new Carro();

        // Esta linha não compila e demonstra que o atributo está protegido:
        // ana.saldo = -500.0;
    }
}
