package br.com.fiapride.model;

/**
 * Representa um celular com capacidade limitada de armazenamento.
 */
public class Celular {
    private final String cor;
    private final int memoriaTotal;
    private int memoria;

    /**
     * Cria um celular iniciando com toda a memória livre.
     */
    public Celular(String cor, int memoriaTotal) {
        this(cor, memoriaTotal, memoriaTotal);
    }

    /**
     * Cria um celular com capacidade total e memória livre iniciais.
     */
    public Celular(String cor, int memoriaTotal, int memoriaInicial) {
        if (cor == null || cor.isBlank()) {
            throw new IllegalArgumentException("A cor do celular é obrigatória.");
        }
        if (memoriaTotal <= 0) {
            throw new IllegalArgumentException("A memória total deve ser maior que zero.");
        }
        if (memoriaInicial < 0 || memoriaInicial > memoriaTotal) {
            throw new IllegalArgumentException("A memória inicial deve estar entre zero e a memória total.");
        }

        this.cor = cor;
        this.memoriaTotal = memoriaTotal;
        this.memoria = memoriaInicial;
    }

    /**
     * Consome memória livre para instalar um aplicativo.
     */
    public void instalarAplicativo(int tamanhoGb) {
        if (tamanhoGb <= 0) {
            System.out.println("Erro: Tamanho do aplicativo deve ser maior que zero.");
            return;
        }
        if (this.memoria < tamanhoGb) {
            System.out.println("Erro: Espaço insuficiente na memória para instalar o aplicativo.");
            return;
        }

        this.memoria -= tamanhoGb;
        System.out.println("Aplicativo instalado com sucesso! Espaço livre atual: " + this.memoria + "GB.");
    }

    /**
     * Libera memória sem ultrapassar a capacidade física do celular.
     */
    public void esvaziarMemoria(int quantidadeLiberada) {
        if (quantidadeLiberada <= 0) {
            System.out.println("Erro: A quantidade de memória para liberação deve ser maior que zero.");
            return;
        }
        if (quantidadeLiberada > this.memoriaTotal - this.memoria) {
            System.out.println("Erro: A memória livre não pode ultrapassar a capacidade total do celular.");
            return;
        }

        this.memoria += quantidadeLiberada;
        System.out.println("Limpeza concluída! Novo espaço livre disponível: " + this.memoria + "GB.");
    }

    public String getCor() {
        return cor;
    }

    public int getMemoriaTotal() {
        return memoriaTotal;
    }

    public int getMemoria() {
        return memoria;
    }
}
