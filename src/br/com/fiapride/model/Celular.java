package br.com.fiapride.model;

/**
 * Representa um celular com capacidade limitada de armazenamento.
 */
public class Celular {
    private String cor;
    private final int memoriaTotal;
    private int memoria;
    private final Bateria bateria;

    /**
     * Cria um celular com memória e bateria definidas.
     */
    public Celular(String cor, int memoriaTotal, int memoriaInicial, Bateria bateria) {
        if (memoriaTotal <= 0) {
            throw new IllegalArgumentException("A memória total deve ser maior que zero.");
        }
        if (bateria == null) {
            throw new IllegalArgumentException("A bateria do celular é obrigatória.");
        }

        this.memoriaTotal = memoriaTotal;
        this.bateria = bateria;
        setCor(cor);
        setMemoria(memoriaInicial);
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

        setMemoria(this.memoria - tamanhoGb);
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

        setMemoria(this.memoria + quantidadeLiberada);
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

    public Bateria getBateria() {
        return bateria;
    }

    private void setCor(String cor) {
        if (cor == null || cor.isBlank()) {
            throw new IllegalArgumentException("A cor do celular é obrigatória.");
        }

        this.cor = cor;
    }

    /**
     * Setter privado com a regra de que a memória livre nunca pode sair dos limites físicos.
     */
    private void setMemoria(int valor) {
        if (valor < 0 || valor > this.memoriaTotal) {
            throw new IllegalArgumentException("A memória deve ficar entre zero e a memória total.");
        }

        this.memoria = valor;
    }
}
