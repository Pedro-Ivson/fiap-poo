package br.com.fiapride.model;

/**
 * Representa um veículo do FiapRide com dados obrigatórios na construção.
 */
public class Veiculo {
    private String placa;
    private final String modelo;

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
}
