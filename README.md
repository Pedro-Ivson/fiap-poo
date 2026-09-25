# FiapRide - Sistema de Mobilidade Urbana

Projeto incremental da disciplina de Programação Orientada a Objetos. O
FiapRide representa passageiros, veículos e viagens. O projeto pessoal usa
`Celular`, `Android`, `Iphone` e `Bateria` para demonstrar associação e herança.

## Estrutura

```text
src/br/com/fiapride/
├── main/
│   ├── SistemaPrincipal.java
│   ├── TesteCelular.java
│   └── TesteVeiculo.java
└── model/
    ├── Android.java
    ├── Bateria.java
    ├── Carro.java
    ├── Celular.java
    ├── Iphone.java
    ├── Moto.java
    ├── Passageiro.java
    ├── Veiculo.java
    └── Viagem.java
docs/
├── fiapride.puml
└── uml.md
```

## Aula 5: relacionamentos entre objetos

Uma `Viagem` recebe e mantém referências para o objeto `Passageiro` que a
solicitou e para o `Veiculo` que será utilizado. O resumo consulta os dados
atuais desses objetos. No exemplo principal, o saldo é recarregado depois que
a viagem é criada e consultado pela chamada
`viagemDaAna.getSolicitante().getSaldo()`, demonstrando que a viagem conhece o
mesmo objeto `Passageiro`.

Os papéis das associações são `solicitante` e `veiculoUtilizado`. O destino é
obrigatório; o valor começa em `0.0`, conforme o exercício, e não há cobrança
automática nesta etapa. No projeto pessoal, `Celular` recebe uma `Bateria` no
construtor e o programa exibe a capacidade em mAh.

## Aula 6: herança

`Carro` e `Moto` estendem `Veiculo`, pois cada um é um tipo de veículo. Os
construtores das subclasses chamam `super(placa, modelo)`, deixando a
superclasse validar e inicializar os dados comuns. `Carro` adiciona
`capacidadePassageiros`; `Moto` adiciona `isEletrica`. O `SistemaPrincipal`
usa os getters herdados de modelo e placa, além dos atributos próprios de cada
subclasse.

Para o projeto pessoal, `Android` e `Iphone` estendem `Celular`. A primeira
classe adiciona `versaoAndroid`; a segunda adiciona `faceIdAtivo`. Ambas chamam
o construtor da superclasse e herdam as regras de memória e a associação com
`Bateria`. `TesteCelular` demonstra os dados herdados e específicos.

Herança é adequada quando a relação é “é um”: carro é um veículo e Android é
um celular. Para representar algo que outro objeto tem, como um celular que
tem uma bateria, permanece a associação da Aula 5.

## Encapsulamento

Os atributos do modelo são privados. Uma subclasse não acessa diretamente os
atributos privados da superclasse; ela inicializa o estado comum por
`super(...)` e usa as operações públicas herdadas. Por isso `Carro` não pode
alterar `placa` diretamente. O setter `setPlaca` também é privado; depois da
construção, a placa só pode ser atualizada pela operação pública herdada
`atualizarPlaca`, que aplica a validação da classe `Veiculo`.

## Executáveis de demonstração

- `SistemaPrincipal`: demonstra `Carro` e `Moto`, getters herdados e o uso de
  um `Carro` como veículo de uma viagem.
- `TesteCelular`: demonstra a associação com `Bateria` e as subclasses
  `Android` e `Iphone`.
- `TesteVeiculo`: demonstra a criação de `Veiculo` e a atualização válida e
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

## Reflexão da Aula 6

Manter `placa` e `modelo` privados protege o encapsulamento e as regras de
validação da classe `Veiculo`, trabalhadas nas aulas anteriores. Se uma
subclasse pudesse alterar esses campos diretamente, poderia deixar o veículo
em um estado inválido ou contornar a lógica da classe mãe.
`super(placa, modelo)` pede à superclasse que inicialize os dados; `setPlaca` não pode ser
chamado pela filha por também ser privado. Uma atualização posterior usa
`atualizarPlaca`, a operação pública que preserva a validação.
