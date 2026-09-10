# FiapRide - Sistema de Mobilidade Urbana

Projeto incremental da disciplina de Programação Orientada a Objetos. O FiapRide modela passageiros com carteira digital, celulares com armazenamento limitado e veículos da frota com estado protegido por encapsulamento.

## Estrutura

```text
src/br/com/fiapride/
├── main/
│   ├── SistemaPrincipal.java
│   ├── TesteCelular.java
│   └── TesteVeiculo.java
└── model/
    ├── Celular.java
    ├── Passageiro.java
    └── Veiculo.java
docs/
├── fiapride.puml
└── uml.md
```

## Encapsulamento

Todos os atributos de modelo são `private`. Os getters públicos permitem leitura controlada, enquanto os setters são privados e só podem ser usados pela própria classe. Assim, classes externas não conseguem alterar diretamente o estado dos objetos.

### Classe `Passageiro`

Representa uma pessoa que utiliza o FiapRide.

- `nome` e `cpf`: definidos na construção e protegidos por setters privados.
- `saldo`: alterado somente por `adicionarSaldo` e `pagarViagem`.
- `getNome()`, `getCpf()` e `getSaldo()`: getters públicos.
- `setNome`, `setCpf` e `setSaldo`: setters privados; `setSaldo` bloqueia valores negativos ou não finitos.
- `adicionarSaldo(double valor)`: aceita somente recargas positivas.
- `pagarViagem(double custo)`: aceita somente custos positivos e saldo suficiente.

### Classe `Celular`

Representa um celular e o controle de seu armazenamento.

- `cor`: protegida por setter privado.
- `memoriaTotal`: definida na construção e sem setter, pois a capacidade física não muda.
- `memoria`: alterada por `instalarAplicativo` e `esvaziarMemoria`, usando setter privado que mantém o valor entre zero e `memoriaTotal`.

### Classe `Veiculo`

Representa um veículo da frota.

- `proprietario` e `placa`: definidos na construção e sem setters, pois identificam o veículo.
- `combustivel`: alterado apenas por `abastecer` e `consumir`, através de setter privado que impede valores negativos ou inválidos.
- `getProprietario()`, `getPlaca()` e `getCombustivel()`: getters públicos.

## Executáveis e testes

- `SistemaPrincipal`: testa exclusivamente o fluxo do FiapRide com `Passageiro`.
- `TesteCelular`: testa o objeto pessoal `Celular`, incluindo tentativas inválidas.
- `TesteVeiculo`: testa o objeto pessoal `Veiculo`, incluindo abastecimento e consumo inválidos.

No PowerShell:

```powershell
$fontes = Get-ChildItem src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName
javac -encoding UTF-8 -d out $fontes
java -cp out br.com.fiapride.main.SistemaPrincipal
java -cp out br.com.fiapride.main.TesteCelular
java -cp out br.com.fiapride.main.TesteVeiculo
```

As linhas comentadas de atribuição direta nos executáveis mostram exemplos que deixariam de compilar, comprovando a proteção dos atributos.

## UML

O diagrama atualizado está em [docs/uml.md](docs/uml.md), com fonte editável em [docs/fiapride.puml](docs/fiapride.puml), e a imagem do módulo de veículos em `diagrama-veiculo-refatorado.png`. O diagrama registra os atributos privados, getters públicos, setters privados e métodos de negócio. A fonte PlantUML pode ser importada no Astah e salva como `FiapRide.asta` na raiz do projeto.

## Boas práticas

- Métodos de negócio têm nomes de ação e uma responsabilidade clara.
- Setters não são públicos e validam as regras de negócio sob responsabilidade da classe.
- Atributos imutáveis não possuem setters desnecessários.
- Arquivos compilados e configurações locais são ignorados pelo [`.gitignore`](.gitignore).
