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
        -void setNome(String nome)
        -void setCpf(String cpf)
        -void setSaldo(double valor)
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
        -void setCor(String cor)
        -void setMemoria(int valor)
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
        -void setCombustivel(double valor)
    }
```

Os métodos de negócio aparecem na terceira divisão de cada classe e alteram o estado somente após validar as regras correspondentes. Os getters são públicos para leitura controlada, enquanto os setters são privados para impedir alterações diretas externas. `memoriaTotal`, `proprietario` e `placa` não possuem setters porque não devem mudar depois da construção.
