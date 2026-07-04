<div align="center">

# 📒 Agenda de Cadastro de Pessoas

### Sistema de Cadastro em Java utilizando POO, JOptionPane, ArrayList, Persistência em Arquivo e Exceções Personalizadas

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![NetBeans](https://img.shields.io/badge/Apache%20NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)

Projeto desenvolvido como desafio prático da disciplina de **Java**, aplicando conceitos fundamentais de Programação Orientada a Objetos (POO), tratamento de exceções, coleções, persistência de dados e organização em camadas utilizando o padrão **Repository**.

</div>

---

# 📑 Sumário

- Sobre o projeto
- Funcionalidades
- Tecnologias utilizadas
- Conceitos aplicados
- Estrutura do projeto
- Funcionamento
- Persistência de dados
- Tratamento de exceções
- Como executar
- Melhorias futuras
- Objetivos de aprendizagem
- Autor

---

# 📖 Sobre o projeto

A aplicação simula uma pequena agenda de cadastro de pessoas.

O usuário pode cadastrar diversas pessoas informando:

- Nome
- Idade
- Telefone

Os cadastros ficam armazenados em memória utilizando um **ArrayList** e também são gravados em um arquivo `.txt`, permitindo que permaneçam disponíveis mesmo após o encerramento da aplicação.

Toda a interação com o usuário é realizada através do **JOptionPane**, proporcionando uma interface gráfica simples e intuitiva.

Além disso, o sistema utiliza uma **exceção personalizada** para impedir que dois contatos sejam cadastrados com o mesmo número de telefone, garantindo maior integridade aos dados.

---

# 🚀 Funcionalidades

- ✅ Menu interativo utilizando JOptionPane
- ✅ Cadastro de pessoas
- ✅ Validação de nome
- ✅ Validação de idade
- ✅ Validação de telefone
- ✅ Validação de telefone duplicado
- ✅ Apenas maiores de idade podem ser cadastrados
- ✅ Tratamento de exceções
- ✅ Exceção personalizada (`TelefoneDuplicadoException`)
- ✅ Armazenamento utilizando ArrayList
- ✅ Persistência dos dados em arquivo texto
- ✅ Leitura automática dos cadastros ao iniciar o programa
- ✅ Listagem de todos os cadastros realizados

---

# 🛠 Tecnologias utilizadas

- Java
- Apache NetBeans
- JOptionPane
- Programação Orientada a Objetos (POO)
- ArrayList
- FileReader
- FileWriter
- BufferedReader
- BufferedWriter
- Git
- GitHub

---

# 📚 Conceitos aplicados

Durante o desenvolvimento foram utilizados diversos conceitos importantes da linguagem Java.

## Programação Orientada a Objetos

- Classes
- Objetos
- Encapsulamento
- Construtores
- Métodos
- Sobrescrita do método `toString()`

## Coleções

- ArrayList

## Persistência

- Leitura de arquivos
- Escrita de arquivos
- Persistência utilizando arquivo texto

## Tratamento de Exceções

- try
- catch
- NumberFormatException
- IOException
- Exceções Personalizadas (Custom Exceptions)
- TelefoneDuplicadoException

## Organização do código

Separação de responsabilidades utilizando uma estrutura semelhante ao padrão **Repository**, deixando a lógica de persistência desacoplada da interface da aplicação.

---

# 📂 Estrutura do projeto

```text
src
│
├── Agenda.java
├── Pessoa.java
├── PessoaRepository.java
│
└── exceptions
    └── TelefoneDuplicadoException.java
```

---

## Agenda

Classe principal da aplicação.

Responsável por:

- Exibir o menu
- Receber os dados do usuário
- Chamar os métodos de cadastro
- Listar os cadastros

---

## Pessoa

Representa um contato cadastrado.

Atributos:

- Nome
- Idade
- Telefone

Também é responsável por converter um objeto para o formato do arquivo (`toLinhaArquivo`) e reconstruir um objeto a partir do arquivo (`fromLinhaArquivo`).

---

## PessoaRepository

Classe responsável pela persistência dos dados.

Funções:

- Ler o arquivo
- Salvar o arquivo
- Buscar contato por telefone
- Validar telefone duplicado
- Lançar exceções personalizadas

Toda a comunicação com o arquivo fica centralizada nesta classe.

---

## TelefoneDuplicadoException

Exceção personalizada criada para representar uma regra de negócio da aplicação.

Sempre que um usuário tenta cadastrar um telefone já existente, essa exceção é lançada pelo Repository e tratada na classe Agenda, impedindo o cadastro duplicado.

---

# 💻 Funcionamento

Ao iniciar o programa é apresentado o menu principal.

```
1 - Cadastrar
2 - Listar Cadastros
3 - Sair
```

## Cadastro

Durante o cadastro são solicitados:

- Nome
- Idade
- Telefone

Cada informação passa por validações antes de ser salva.

---

### Nome

Regras:

- Obrigatório
- Apenas letras
- Aceita acentos
- Aceita espaços

Exemplos válidos

```
Pedro
Maria Fernanda
João Antônio
```

---

### Idade

Regras:

- Obrigatória
- Apenas números
- Apenas maiores de idade podem ser cadastrados

Caso seja informado um valor inválido, o sistema solicita novamente a idade.

---

### Telefone

Regras:

- Obrigatório
- Apenas números
- Exatamente 11 dígitos

Exemplo

```
85999998888
```

---

### Telefone duplicado

Antes de salvar um novo cadastro, o sistema verifica se o telefone informado já existe.

Caso o número esteja cadastrado, a exceção personalizada `TelefoneDuplicadoException` é lançada pelo Repository.

A aplicação impede o cadastro e informa ao usuário qual contato já possui aquele número.

Exemplo:

```
[Erro]

Telefone já cadastrado!

Nome: Pedro Toni Melo
Telefone: 85999998888
```

---

# 💾 Persistência de dados

Todos os cadastros são gravados automaticamente em um arquivo texto.

Formato utilizado:

```
Pedro;38;85999998888
Maria;25;85988887777
José;41;85977776666
```

Ao iniciar novamente o programa, o arquivo é lido automaticamente e todos os registros são carregados novamente para o `ArrayList`.

---

# ⚠ Tratamento de exceções

O sistema trata diversas situações de erro.

Validações implementadas:

- Nome vazio
- Nome contendo números
- Idade vazia
- Idade contendo letras
- Telefone vazio
- Telefone contendo letras
- Telefone com quantidade incorreta de dígitos
- Telefone já cadastrado
- Opção inválida do menu

Além das exceções nativas da linguagem (`NumberFormatException` e `IOException`), foi criada uma exceção personalizada (`TelefoneDuplicadoException`) para representar uma regra de negócio específica da aplicação.

Sempre que um erro ocorre, o usuário permanece na mesma etapa do cadastro até informar um valor válido.

---

# ▶ Como executar

Clone o repositório.

```bash
git clone [https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git](https://github.com/PedroGiffoni/Agenda-JOption-Pane)
```

Abra o projeto no Apache NetBeans.

Execute a classe:

```
Agenda.java
```

O arquivo de persistência será criado automaticamente após o primeiro cadastro.

---

# 🔮 Melhorias futuras

Algumas funcionalidades que podem ser ser implementadas futuramente:

- Editar cadastro
- Excluir cadastro
- Buscar pessoa pelo nome
- Buscar por telefone
- Ordenação alfabética
- Interface gráfica utilizando JavaFX
- Persistência utilizando banco de dados
- Exportação para CSV
- Cadastro com CPF
- Cadastro com endereço
- Máscara para telefone
- Máscara para CPF
- Sistema de login
- Integração com banco de dados MySQL

---

# 🎯 Objetivos de aprendizagem

Este projeto foi desenvolvido com o objetivo de praticar:

- Programação Orientada a Objetos
- Estruturas de repetição
- Estruturas de decisão
- Métodos
- Encapsulamento
- Tratamento de exceções
- Exceções personalizadas (Custom Exceptions)
- Manipulação de arquivos
- Coleções
- Persistência de dados
- Organização de código
- Separação de responsabilidades
- Repository Pattern
- Versionamento com Git
- Publicação de projetos no GitHub

---

# 👨‍💻 Autor

**Pedro Toni Melo Giffoni**

Estudante de Análise e Desenvolvimento de Sistemas.

Apaixonado por tecnologia, desenvolvimento de software, Inteligência Artificial e Visão Computacional, buscando aplicar boas práticas de programação e arquitetura de software na construção de projetos cada vez mais completos.

---

<div align="center">

⭐ Se este projeto foi útil para você, deixe uma estrela no repositório!

</div>
