<div align="center">

# 📒 Agenda de Cadastro de Pessoas

### Sistema de Cadastro em Java utilizando POO, JOptionPane, ArrayList e Persistência em Arquivo

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

---

# 🚀 Funcionalidades

- ✅ Menu interativo utilizando JOptionPane
- ✅ Cadastro de pessoas
- ✅ Validação de nome
- ✅ Validação de idade
- ✅ Validação de telefone
- ✅ Apenas maiores de idade podem ser cadastrados
- ✅ Tratamento de exceções
- ✅ Armazenamento utilizando ArrayList
- ✅ Persistência dos dados em arquivo texto
- ✅ Leitura automática dos cadastros ao iniciar o programa
- ✅ Listagem de todos os cadastros realizados

---

# 🛠 Tecnologias utilizadas

- Java
- Apache NetBeans
- JOptionPane
- Programação Orientada a Objetos
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

### Programação Orientada a Objetos

- Classes
- Objetos
- Encapsulamento
- Construtores
- Métodos
- Sobrescrita do método `toString()`

### Coleções

- ArrayList

### Persistência

- Leitura de arquivos
- Escrita de arquivos
- Serialização simples utilizando arquivos texto

### Tratamento de Exceções

- try
- catch
- NumberFormatException
- IOException

### Organização do código

Separação de responsabilidades utilizando uma estrutura semelhante ao padrão Repository.

---

# 📂 Estrutura do projeto

```
src
│
├── Pessoa.java
│
├── PessoaRepository.java
│
└── Agenda.java
```

## Pessoa

Classe responsável por representar uma pessoa cadastrada.

Atributos:

- Nome
- Idade
- Telefone

Também é responsável por converter os dados para uma linha de arquivo e reconstruir um objeto a partir do arquivo.

---

## PessoaRepository

Responsável por toda a persistência dos dados.

Funções:

- Salvar cadastros
- Ler cadastros
- Manipular o arquivo texto

Toda a comunicação com o arquivo fica isolada nesta classe.

---

## Agenda

Classe principal da aplicação.

Responsável por:

- Exibir o menu
- Receber os dados do usuário
- Validar informações
- Chamar o Repository
- Listar os cadastros

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

### Nome

- Obrigatório
- Não aceita números
- Não aceita caracteres especiais

Exemplos válidos

```
Pedro
João Silva
Maria Fernanda
```

---

### Idade

- Obrigatória
- Deve conter apenas números
- Apenas maiores de idade são cadastrados

Caso seja informado um valor inválido, o sistema solicita novamente a idade.

---

### Telefone

- Obrigatório
- Apenas números
- Exatamente 11 dígitos

Exemplo

```
85999998888
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

Ao iniciar novamente o programa, o arquivo é lido automaticamente e todos os cadastros são carregados para o ArrayList.

---

# ⚠ Tratamento de exceções

O sistema trata diversas situações de erro, como:

- Nome vazio
- Nome contendo números
- Idade vazia
- Idade contendo letras
- Telefone vazio
- Telefone contendo letras
- Telefone com quantidade incorreta de dígitos
- Opção inválida do menu

Sempre que um erro ocorre, o usuário permanece na mesma etapa do cadastro até informar um valor válido.

---

# ▶ Como executar

Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
```

Abra o projeto no Apache NetBeans.

Execute a classe:

```
Agenda.java
```

O arquivo de persistência será criado automaticamente após o primeiro cadastro.

---

# 🔮 Melhorias futuras

Algumas melhorias que podem ser implementadas futuramente:

- Editar cadastro
- Excluir cadastro
- Buscar pessoa pelo nome
- Buscar por telefone
- Ordenação alfabética
- Interface gráfica em JavaFX
- Persistência utilizando banco de dados
- Exportação para CSV
- Cadastro com CPF
- Cadastro com endereço
- Máscara para telefone
- Máscara para CPF
- Sistema de login

---

# 🎯 Objetivos de aprendizagem

Este projeto foi desenvolvido com o objetivo de praticar:

- Programação Orientada a Objetos
- Estruturas de repetição
- Estruturas de decisão
- Tratamento de exceções
- Manipulação de arquivos
- Coleções
- Organização de código
- Separação de responsabilidades
- Versionamento com Git
- Publicação de projetos no GitHub

---

# 👨‍💻 Autor

**Pedro Toni Melo Giffoni**

Estudante de Análise e Desenvolvimento de Sistemas.

Apaixonado por tecnologia, desenvolvimento de software, Inteligência Artificial e Visão Computacional, buscando aplicar boas práticas de programação na construção de projetos cada vez mais completos.

---

<div align="center">

⭐ Se este projeto foi útil para você, deixe uma estrela no repositório!

</div>
