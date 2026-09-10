# FiapRide - Sistema de Mobilidade Urbana

Projeto incremental da disciplina de Programação Orientada a Objetos. O FiapRide modela passageiros com carteira digital, celulares com armazenamento limitado e veículos da frota com combustível protegido por encapsulamento.

## Estrutura

```text
src/br/com/fiapride/
├── main/SistemaPrincipal.java
└── model/
    ├── Celular.java
    ├── Passageiro.java
    └── Veiculo.java
docs/uml.md
```

## Classe `Veiculo`

Representa um veículo da frota e protege seu estado interno.

### Atributos

- `proprietario`: nome do responsável pelo veículo.
- `placa`: identificação do veículo.
- `combustivel`: quantidade disponível em litros.

Os três atributos são privados. O proprietário e a placa são definidos no construtor, e o combustível só é alterado pelos métodos de comportamento.

### Métodos

- `abastecer(double litros)`: adiciona apenas uma quantidade positiva e finita.
- `consumir(double litros)`: consome apenas uma quantidade válida e nunca permite combustível negativo.

Tentativas inválidas geram `IllegalArgumentException`, mantendo o objeto em um estado consistente.

## Classe `Passageiro`

Representa uma pessoa que utiliza o FiapRide.

### Atributos

- `nome`: nome do passageiro.
- `cpf`: identificador do passageiro.
- `saldo`: valor disponível na carteira digital.

Os atributos são protegidos pela classe; o saldo só é alterado pelos métodos de comportamento.

### Métodos

- `adicionarSaldo(double valor)`: adiciona uma recarga somente quando o valor é positivo e finito.
- `pagarViagem(double custo)`: paga uma viagem somente quando o custo é positivo e há saldo suficiente.

## Classe `Celular`

Representa um celular e o controle de seu armazenamento.

### Atributos

- `cor`: cor do aparelho.
- `memoriaTotal`: capacidade física máxima em GB.
- `memoria`: espaço livre atual em GB.

### Métodos

- `instalarAplicativo(int tamanhoGb)`: reduz a memória livre quando o tamanho é positivo e há espaço disponível.
- `esvaziarMemoria(int quantidadeLiberada)`: aumenta a memória livre sem ultrapassar `memoriaTotal`.

As validações impedem valores negativos, aplicativos sem tamanho válido, falta de espaço e memória livre acima da capacidade física.

## Como executar

É necessário ter um JDK instalado. No Eclipse, execute `SistemaPrincipal.java`.

No PowerShell, a execução também pode ser feita assim:

```powershell
$fontes = Get-ChildItem src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -encoding UTF-8 -d out $fontes
java -cp out br.com.fiapride.main.SistemaPrincipal
```

O programa demonstra cenários válidos e inválidos para as três classes, incluindo recarga, pagamento, instalação de aplicativo, liberação de memória, abastecimento e consumo de combustível.

## UML

O diagrama de classes atualizado está em [docs/uml.md](docs/uml.md), e a imagem usada na entrega está em `diagrama-veiculo-refatorado.png`. O diagrama registra os atributos, construtores e comportamentos implementados no projeto.

## Boas práticas

- Métodos de negócio têm nomes de ação e uma responsabilidade clara.
- Os atributos são privados e o estado é alterado por comportamentos controlados.
- Arquivos compilados e configurações locais são ignorados pelo [`.gitignore`](.gitignore).
