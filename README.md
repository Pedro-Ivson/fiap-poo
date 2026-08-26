# FiapRide - Sistema de Mobilidade Urbana

Este repositório foi desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)**. O projeto consiste em um sistema incremental de mobilidade urbana chamado **FiapRide**, focado na aplicação prática de conceitos de encapsulamento, herança, polimorfismo, proteção de estado e boas práticas de *Clean Code*.

---

## 🛠️ Estrutura Geral do Projeto

O código está organizado seguindo as convenções de pacotes do Java:

* **`br.com.fiapride.model`**: Contém as classes de modelo que definem as entidades e regras de negócio.
* **`br.com.fiapride.main`**: Contém a classe executável (`SistemaPrincipal`) utilizada para testes e simulações na memória RAM.

---

## 👥 1. Core do Sistema: Classe Passageiro

A classe principal do ecossistema representa o cliente do serviço de mobilidade.

### Atributos

* `nome` (String): Nome do passageiro.
* `cpf` (String): Cadastro de Pessoa Física do usuário.
* `saldo` (double): Saldo financeiro disponível na carteira digital.

### Comportamentos e Regras de Negócio

* **`adicionarSaldo(double valor)`**: Permite realizar recargas na carteira digital. Possui validação para impedir depósitos de valores nulos ou negativos.
* **`pagarViagem(double custo)`**: Deduz o valor da corrida do saldo do passageiro, validando se há saldo suficiente antes de autorizar a viagem.

---

## 📱 2. Desafio Pessoal (Checkpoint 1): Classe Celular

Como parte das atividades práticas e da avaliação do **Checkpoint 1**, foi implementado um objeto do mundo real à escolha do aluno para exercitar de forma isolada a modelagem e a proteção de estado.

O objeto escolhido foi um **Celular**, simulando propriedades físicas e o gerenciamento de armazenamento interno.

### Atributos do Celular

* `cor` (String): Cor física do aparelho.
* `memoriaTotal` (int): Capacidade física máxima de fábrica em GB (imutável após a criação).
* `memoria` (int): Espaço livre disponível atualmente para o usuário em GB.

### Comportamentos e Regras de Negócio Implementados

1. **`instalarAplicativo(int tamanhoGb)`**: Consome a memória livre do dispositivo.
   * *Validação*: O tamanho do aplicativo deve ser maior que zero e menor ou igual ao espaço livre disponível atualmente.
2. **`esvaziarMemoria(int quantidadeLiberada)`**: Libera espaço de armazenamento no dispositivo.
   * *Validação*: A quantidade liberada deve ser maior que zero e a soma com a memória livre atual não pode ultrapassar o limite físico de fábrica (`memoriaTotal`).

---

## 💻 Como Executar e Testar

1. Importe o projeto `FiapRide` no seu Eclipse IDE.
2. Abra e execute a classe `SistemaPrincipal.java` localizada no pacote `br.com.fiapride.main`.
3. Acompanhe a saída no **Console** para validar os cenários de teste de sucesso e as respostas controladas de erro ao violar as regras de negócio de ambas as classes.
