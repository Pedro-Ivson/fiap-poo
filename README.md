# FiapRide - Sistema de Mobilidade Urbana

Projeto incremental da disciplina de Programação Orientada a Objetos. O
FiapRide representa passageiros, veículos e viagens. O projeto pessoal usa
`Celular` e `Bateria` para demonstrar outra associação entre objetos.

## Estrutura

```text
src/br/com/fiapride/
├── main/
│   ├── SistemaPrincipal.java
│   ├── TesteCelular.java
│   └── TesteVeiculo.java
└── model/
    ├── Bateria.java
    ├── Celular.java
    ├── Passageiro.java
    ├── Veiculo.java
    └── Viagem.java
docs/
├── fiapride.puml
└── uml.md
```

## Relacionamentos da Aula 5

Uma `Viagem` recebe e mantém referências para o objeto `Passageiro` que a
solicitou e para o `Veiculo` que será utilizado. O resumo consulta os dados
atuais desses objetos. No exemplo principal, o saldo é recarregado depois que
a viagem é criada e consultado pela chamada
`viagemDaAna.getSolicitante().getSaldo()`, demonstrando que a viagem conhece o
mesmo objeto `Passageiro`.

Os campos de associação usam os nomes de papel do PDF: `solicitante` e
`veiculoUtilizado`. O destino é obrigatório; o valor começa em `0.0`, conforme
o exercício, e não há cobrança automática nesta etapa.

No projeto pessoal, `Celular` recebe um objeto `Bateria` em seu construtor e
expõe a capacidade por `getBateria()`. `TesteCelular` mostra a capacidade em
mAh junto aos dados do celular.

## Encapsulamento

Todos os atributos de modelo são privados. Os getters públicos permitem
leitura controlada, enquanto os setters privados são usados somente pela
própria classe.

### `Passageiro`

- `nome` e `cpf` são obrigatórios na construção.
- `saldo` muda por `adicionarSaldo` e `pagarViagem`.
- Recargas e pagamentos são validados antes de alterar o saldo.

### `Viagem`

- O construtor exige destino, passageiro solicitante e veículo utilizado.
- `exibirResumo()` lê o nome do passageiro e os dados do veículo pelas
  referências associadas.
- `getSolicitante()` e `getVeiculoUtilizado()` permitem consultar os objetos
  relacionados.

### `Veiculo`

- `placa` e `modelo` são obrigatórios no construtor.
- `modelo` é imutável depois da construção.
- `placa` só muda por `atualizarPlaca`, que valida a nova placa.

### `Celular` e `Bateria`

- `Celular` exige um objeto `Bateria` no construtor.
- A bateria guarda uma capacidade positiva em mAh.
- A memória livre do celular é alterada pelas operações de instalar e remover
  aplicativos, respeitando a capacidade total.

## Executáveis de demonstração

- `SistemaPrincipal`: cria uma viagem, exibe o resumo e demonstra a referência
  compartilhada com o passageiro.
- `TesteCelular`: demonstra a associação entre celular e bateria e as regras de
  memória.
- `TesteVeiculo`: demonstra a criação do veículo e a atualização válida e
  inválida da placa.

No PowerShell:

```powershell
$fontes = Get-ChildItem src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -encoding UTF-8 -d out $fontes
java -cp out br.com.fiapride.main.SistemaPrincipal
java -cp out br.com.fiapride.main.TesteCelular
java -cp out br.com.fiapride.main.TesteVeiculo
```

## UML

O diagrama de classes está em [`docs/uml.md`](docs/uml.md) e sua fonte
PlantUML editável em [`docs/fiapride.puml`](docs/fiapride.puml). A imagem
`diagrama-veiculo-refatorado.png` continua ilustrando a refatoração do veículo
da Aula 4.

## Reflexão da Aula 5

Passar o objeto `Passageiro` inteiro para `Viagem` mantém acesso aos dados e às
operações de negócio da mesma pessoa. Passar apenas um `String` com o nome
serviria para exibir o resumo, mas não permitiria consultar o saldo atualizado
nem chamar uma operação como `pagarViagem`. A associação também evita que a
viagem trabalhe com uma cópia desatualizada do nome ou do estado financeiro.

## Aula 4

O veículo não possui setter público: a placa só pode ser atualizada por
`atualizarPlaca`, que valida o valor, e o modelo não muda depois da criação.
Isso impede alterações diretas que deixariam o objeto em um estado inválido.
