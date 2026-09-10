package br.com.fiapride.model;

/**
 * Representa um passageiro e sua carteira digital no FiapRide.
 */
public class Passageiro {
    private String nome;
    private String cpf;
    private double saldo;

    public Passageiro(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
        setSaldo(0.0);
    }

    /**
     * Adiciona dinheiro à carteira, desde que o valor seja positivo.
     */
    public void adicionarSaldo(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            System.out.println("Erro: O valor de recarga deve ser maior que zero.");
            return;
        }

        double novoSaldo = this.saldo + valor;
        if (!Double.isFinite(novoSaldo)) {
            System.out.println("Erro: O saldo resultante não é válido.");
            return;
        }

        setSaldo(novoSaldo);
        System.out.printf("Recarga de R$%.2f realizada. Novo saldo: R$%.2f%n", valor, this.saldo);
    }

    /**
     * Paga uma viagem apenas quando o custo é válido e há saldo suficiente.
     */
    public void pagarViagem(double custo) {
        if (!Double.isFinite(custo) || custo <= 0) {
            System.out.println("Erro: O custo da viagem deve ser maior que zero.");
            return;
        }
        if (this.saldo < custo) {
            System.out.println("Erro: Saldo insuficiente para realizar a viagem.");
            return;
        }

        setSaldo(this.saldo - custo);
        System.out.printf("Viagem de R$%.2f paga. Saldo restante: R$%.2f%n", custo, this.saldo);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Setter privado: nenhuma classe externa pode definir o saldo diretamente.
     */
    private void setSaldo(double valor) {
        if (!Double.isFinite(valor) || valor < 0) {
            System.out.println("Erro de Segurança: Tentativa de definir saldo negativo bloqueada!");
            return;
        }

        this.saldo = valor;
    }

    private void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do passageiro é obrigatório.");
        }

        this.nome = nome;
    }

    private void setCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("O CPF do passageiro é obrigatório.");
        }

        this.cpf = cpf;
    }
}
