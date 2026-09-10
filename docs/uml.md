# UML do FiapRide

```mermaid
classDiagram
    class Passageiro {
        -String nome
        -String cpf
        -double saldo
        +Passageiro(String nome, String cpf)
        +void adicionarSaldo(double valor)
        +void pagarViagem(double custo)
        +String getNome()
        +String getCpf()
        +double getSaldo()
    }

    class Celular {
        -String cor
        -int memoriaTotal
        -int memoria
        +Celular(String cor, int memoriaTotal)
        +Celular(String cor, int memoriaTotal, int memoriaInicial)
        +void instalarAplicativo(int tamanhoGb)
        +void esvaziarMemoria(int quantidadeLiberada)
        +String getCor()
        +int getMemoriaTotal()
        +int getMemoria()
    }

    class Veiculo {
        -String proprietario
        -String placa
        -double combustivel
        +Veiculo(String proprietario, String placa)
        +Veiculo(String proprietario, String placa, double combustivelInicial)
        +void abastecer(double litros)
        +void consumir(double litros)
        +String getProprietario()
        +String getPlaca()
        +double getCombustivel()
    }
```

Os métodos de negócio aparecem na terceira divisão de cada classe e são responsáveis por alterar o estado somente após validar as regras correspondentes. Em `Veiculo`, os atributos são privados e não existem setters públicos: as alterações passam por `abastecer` e `consumir`, que impedem valores inválidos e combustível negativo.
