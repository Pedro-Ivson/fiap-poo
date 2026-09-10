# FiapRide - Sistema de Mobilidade Urbana

Projeto incremental da disciplina de Programação Orientada a Objetos. O FiapRide modela passageiros com carteira digital e celulares com armazenamento limitado.

## Estrutura

```text
src/br/com/fiapride/
├── main/SistemaPrincipal.java
└── model/
    ├── Celular.java
    └── Passageiro.java
docs/uml.md
```

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

O programa demonstra cenários válidos e inválidos para as duas classes, incluindo recarga, pagamento, instalação de aplicativo e liberação de memória.

## UML

O diagrama de classes atualizado está em [docs/uml.md](docs/uml.md). Ele registra os atributos, construtores e os comportamentos implementados no projeto.

## Boas práticas

- Métodos de negócio têm nomes de ação e uma responsabilidade clara.
- Os atributos são privados e o estado é alterado por comportamentos controlados.
- Arquivos compilados e configurações locais são ignorados pelo [`.gitignore`](.gitignore).
