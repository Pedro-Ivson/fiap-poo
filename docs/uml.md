# UML do FiapRide

O diagrama abaixo registra os relacionamentos pedidos na Aula 5. Cada `Viagem`
tem um `Passageiro` solicitante e um `Veiculo` utilizado; os papéis aparecem
com os nomes `solicitante` e `veiculoUtilizado`. O projeto pessoal também tem
uma associação de `Celular` para `Bateria`, chamada `bateria`.

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

    class Viagem {
        -String destino
        -double valor
        +Viagem(String destino, Passageiro solicitante, Veiculo veiculoUtilizado)
        +void exibirResumo()
        +String getDestino()
        +Passageiro getSolicitante()
        +Veiculo getVeiculoUtilizado()
    }

    class Veiculo {
        -String placa
        -String modelo
        +Veiculo(String placa, String modelo)
        +void atualizarPlaca(String novaPlaca)
        +String getPlaca()
        +String getModelo()
        -void setPlaca(String novaPlaca)
    }

    class Celular {
        -String cor
        -int memoriaTotal
        -int memoria
        +Celular(String cor, int memoriaTotal, int memoriaInicial, Bateria bateria)
        +void instalarAplicativo(int tamanhoGb)
        +void esvaziarMemoria(int quantidadeLiberada)
        +String getCor()
        +int getMemoriaTotal()
        +int getMemoria()
        +Bateria getBateria()
        -void setCor(String cor)
        -void setMemoria(int valor)
    }

    class Bateria {
        -int capacidadeMah
        +Bateria(int capacidadeMah)
        +int getCapacidadeMah()
    }

    Viagem "0..*" --> "1" Passageiro : solicitante
    Viagem "0..*" --> "1" Veiculo : veiculoUtilizado
    Celular "1" --> "1" Bateria : bateria
```

As linhas de associação representam as referências privadas mantidas pelos
objetos. Por isso, `solicitante`, `veiculoUtilizado` e `bateria` aparecem como
papéis das relações, sem repetir esses campos na lista de atributos UML.
`getDestino()` retorna `String`, como esperado de um getter para o destino.

O diagrama também está disponível em PlantUML em
[`fiapride.puml`](fiapride.puml).
