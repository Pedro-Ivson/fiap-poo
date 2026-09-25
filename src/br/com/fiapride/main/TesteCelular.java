package br.com.fiapride.main;

import br.com.fiapride.model.Android;
import br.com.fiapride.model.Bateria;
import br.com.fiapride.model.Celular;
import br.com.fiapride.model.Iphone;

/**
 * Executável separado para testar o objeto pessoal Celular.
 */
public class TesteCelular {
    public static void main(String[] args) {
        System.out.println("--- Teste do objeto pessoal: Celular ---");

        Bateria bateria = new Bateria(5000);
        Celular celular = new Celular("Preto", 128, 64, bateria);
        System.out.println("Cor: " + celular.getCor()
                + " | Memória livre: " + celular.getMemoria() + "GB"
                + " | Bateria: " + celular.getBateria().getCapacidadeMah() + "mAh");

        Android android = new Android("Azul", 256, 200, new Bateria(5000), "15");
        Iphone iphone = new Iphone("Prata", 512, 400, new Bateria(4500), true);
        System.out.println("\n--- Especializações de Celular ---");
        System.out.println("Android: cor " + android.getCor()
                + " | Memória livre: " + android.getMemoria() + "GB"
                + " | Versão: " + android.getVersaoAndroid());
        System.out.println("iPhone: cor " + iphone.getCor()
                + " | Memória livre: " + iphone.getMemoria() + "GB"
                + " | Face ID ativo: " + iphone.isFaceIdAtivo());

        celular.instalarAplicativo(10); // Cenário válido

        System.out.println("\nTentando instalar aplicativo de tamanho zero:");
        celular.instalarAplicativo(0); // Cenário inválido

        System.out.println("Tentando instalar aplicativo maior que a memória disponível:");
        celular.instalarAplicativo(100); // Cenário inválido

        celular.esvaziarMemoria(20); // Cenário válido

        System.out.println("\nTentando ultrapassar a memória total do celular:");
        celular.esvaziarMemoria(100); // Cenário inválido

        try {
            new Celular("Preto", 128, 200, bateria); // Regra do setter privado
        } catch (IllegalArgumentException erro) {
            System.out.println("Memória inicial rejeitada: " + erro.getMessage());
        }

        // Esta linha não compila e demonstra que a memória está protegida:
        // celular.memoria = -1;
    }
}
