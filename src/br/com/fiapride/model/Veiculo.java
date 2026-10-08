package br.com.fiapride.model;

/**
 * Representa um veículo do FiapRide com dados obrigatórios na construção.
 */
public class Veiculo {
    private String placa;
    private final String modelo;
    private double nivelCombustivel;

    /**
     * Cria um veículo com placa válida e modelo definido.
     */
    public Veiculo(String placa, String modelo) {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("O modelo é obrigatório.");
        }

        this.setPlaca(placa);
        this.modelo = modelo.trim();
        System.out.println("Registro inicial: Um " + this.modelo
                + " nasceu com a placa " + this.placa);
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    /**
     * Abastece o veículo com uma quantidade positiva de combustível, em litros.
     */
    public void abastecer(double quantidadeLitros) {
        if (!Double.isFinite(quantidadeLitros) || quantidadeLitros <= 0) {
            throw new IllegalArgumentException("A quantidade de combustível deve ser maior que zero.");
        }

        setNivelCombustivel(nivelCombustivel + quantidadeLitros);
    }

    /**
     * Retorna a resposta genérica para veículos sem uma regra de autonomia própria.
     */
    public String calcularAutonomia() {
        return "Autonomia não definida para um veículo genérico.";
    }

    /**
     * Atualiza a placa através da operação de negócio do veículo.
     */
    public void atualizarPlaca(String novaPlaca) {
        System.out.println("Solicitada atualização de placa no Detran para o veículo "
                + this.modelo + "...");
        try {
            this.setPlaca(novaPlaca);
            System.out.println("Sucesso: A placa agora é " + this.placa);
        } catch (IllegalArgumentException erro) {
            System.out.println("Erro de Validação: " + erro.getMessage());
        }
    }

    /**
     * Único ponto interno que pode alterar a placa.
     */
    private void setPlaca(String novaPlaca) {
        if (novaPlaca == null || novaPlaca.isBlank()) {
            throw new IllegalArgumentException("A placa informada é inválida.");
        }

        this.placa = novaPlaca.trim();
    }

    private void setNivelCombustivel(double nivelCombustivel) {
        if (!Double.isFinite(nivelCombustivel) || nivelCombustivel < 0) {
            throw new IllegalArgumentException("O nível de combustível deve ser válido e não negativo.");
        }

        this.nivelCombustivel = nivelCombustivel;
    }
}
