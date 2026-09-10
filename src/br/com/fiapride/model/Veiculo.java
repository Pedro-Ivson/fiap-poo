package br.com.fiapride.model;

/**
 * Representa um veiculo da frota e controla seu nivel de combustivel.
 */
public class Veiculo {
    private final String proprietario;
    private final String placa;
    private double combustivel;

    /**
     * Cria um veiculo sem combustivel.
     */
    public Veiculo(String proprietario, String placa) {
        this(proprietario, placa, 0.0);
    }

    /**
     * Cria um veiculo com um nivel inicial de combustivel valido.
     */
    public Veiculo(String proprietario, String placa, double combustivelInicial) {
        validarTexto(proprietario, "O proprietario e obrigatorio.");
        validarTexto(placa, "A placa e obrigatoria.");
        validarCombustivel(combustivelInicial);

        this.proprietario = proprietario;
        this.placa = placa;
        this.combustivel = combustivelInicial;
    }

    /**
     * Adiciona combustivel ao veiculo.
     */
    public void abastecer(double litros) {
        validarQuantidade(litros);
        this.combustivel += litros;
    }

    /**
     * Consome combustivel sem permitir que o nivel fique negativo.
     */
    public void consumir(double litros) {
        validarQuantidade(litros);
        if (litros > this.combustivel) {
            throw new IllegalArgumentException("Combustivel insuficiente para o consumo solicitado.");
        }

        this.combustivel -= litros;
    }

    public String getProprietario() {
        return proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public double getCombustivel() {
        return combustivel;
    }

    private static void validarTexto(String valor, String mensagem) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    private static void validarCombustivel(double valor) {
        if (!Double.isFinite(valor) || valor < 0) {
            throw new IllegalArgumentException("O combustivel deve ser um valor finito e nao negativo.");
        }
    }

    private static void validarQuantidade(double litros) {
        if (!Double.isFinite(litros) || litros <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser um valor finito e maior que zero.");
        }
    }
}
