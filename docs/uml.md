# UML do FiapRide

O diagrama inclui as associações da Aula 5 e as generalizações das Aulas 6 e 7.
`Carro` e `Moto` herdam de `Veiculo`; `Android` e `Iphone` herdam de
`Celular`. As classes filhas listam apenas seus atributos próprios, pois os
atributos herdados permanecem definidos nas superclasses.

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

    class Veiculo {
        -String placa
        -String modelo
        -double nivelCombustivel
        +Veiculo(String placa, String modelo)
        +void atualizarPlaca(String novaPlaca)
        +String getPlaca()
        +String getModelo()
        +double getNivelCombustivel()
        +void abastecer(double quantidadeLitros)
        +String calcularAutonomia()
        -void setPlaca(String novaPlaca)
        -void setNivelCombustivel(double nivelCombustivel)
    }

    class Carro {
        -int capacidadePassageiros
        +Carro(String placa, String modelo, int capacidadePassageiros)
        +int getCapacidadePassageiros()
        +String calcularAutonomia()
        -void setCapacidadePassageiros(int capacidadePassageiros)
    }

    class Moto {
        -boolean isEletrica
        +Moto(String placa, String modelo, boolean isEletrica)
        +boolean isEletrica()
        +String calcularAutonomia()
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
        +String descreverSeguranca()
        -void setCor(String cor)
        -void setMemoria(int valor)
    }

    class Android {
        -String versaoAndroid
        +Android(String cor, int memoriaTotal, int memoriaInicial, Bateria bateria, String versaoAndroid)
        +String getVersaoAndroid()
        +String descreverSeguranca()
    }

    class Iphone {
        -boolean faceIdAtivo
        +Iphone(String cor, int memoriaTotal, int memoriaInicial, Bateria bateria, boolean faceIdAtivo)
        +boolean isFaceIdAtivo()
        +String descreverSeguranca()
    }

    class Bateria {
        -int capacidadeMah
        +Bateria(int capacidadeMah)
        +int getCapacidadeMah()
    }

    Veiculo <|-- Carro
    Veiculo <|-- Moto
    Celular <|-- Android
    Celular <|-- Iphone
    Viagem "0..*" --> "1" Passageiro : solicitante
    Viagem "0..*" --> "1" Veiculo : veiculoUtilizado
    Celular "1" --> "1" Bateria : bateria
```

As linhas de associação representam as referências privadas mantidas pelos
objetos. Os papéis `solicitante`, `veiculoUtilizado` e `bateria` aparecem nas
relações sem duplicar os campos na lista de atributos UML. `getDestino()`
retorna `String`, como esperado de um getter para o destino.

As assinaturas iguais de `calcularAutonomia()` em `Veiculo`, `Carro` e `Moto`
representam o contrato e suas sobrescritas. `descreverSeguranca()` mostra o
mesmo padrão no projeto pessoal, entre `Celular`, `Android` e `Iphone`.

O diagrama também está disponível em PlantUML em
[`fiapride.puml`](fiapride.puml).
