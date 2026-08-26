package br.com.fiapride.model;

public class Celular {
    // 1. ATRIBUTOS
    public String cor;
    public int memoria; // Armazenamento livre em GB

    // 2. CONSTRUTOR (Inicializa o estado do objeto com valores iniciais seguros)
    public Celular(String cor, int memoria) {
        this.cor = cor;
        this.memoria = memoria;
    }

    // 3. MÉTODOS DE COMPORTAMENTO (As ações que alteram o estado do objeto)
    
    // Comportamento 1: Consome memória interna livre para instalar apps
    public void instalarAplicativo(int tamanhoGb) {
        // Regra de negócio: O tamanho do app deve ser válido (positivo)
        if (tamanhoGb <= 0) {
            System.out.println("Erro: Tamanho do aplicativo deve ser maior que zero.");
            return; // Interrompe a execução do método
        }
        
        // Regra de negócio: Não podemos instalar se não houver espaço suficiente
        if (this.memoria < tamanhoGb) {
            System.out.println("Erro: Espaço insuficiente na memória para instalar o aplicativo.");
            return;
        }
        
        // Altera o estado do atributo
        this.memoria -= tamanhoGb;
        System.out.println("Aplicativo instalado com sucesso! Espaço livre atual: " + this.memoria + "GB.");
    }

    // Comportamento 2: Libera espaço na memória interna desinstalando arquivos
    public void esvaziarMemoria(int quantidadeLiberada) {
        // Regra de negócio: A quantidade a ser limpa deve ser positiva
        if (quantidadeLiberada <= 0) {
            System.out.println("Erro: A quantidade de memória para liberação deve ser maior que zero.");
            return;
        }
        
        // Altera o estado do atributo
        this.memoria += quantidadeLiberada;
        System.out.println("Limpeza concluída! Novo espaço livre disponível: " + this.memoria + "GB.");
    }
}