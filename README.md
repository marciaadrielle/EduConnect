# 🎓 EduConnect – Sistema de Gestão Educacional

## 📖 Sobre o projeto

O EduConnect é um Sistema de Gestão Educacional desenvolvido em Java
como parte de uma atividade acadêmica do curso de Análise e
Desenvolvimento de Sistemas.

O projeto tem como objetivo aplicar os conceitos de Programação
Orientada a Objetos (POO) e boas práticas de desenvolvimento de
software, simulando um sistema de gerenciamento acadêmico para
instituições de ensino.

## 🚀 Funcionalidades

- Cadastro de alunos;
- Cadastro de professores;
- Cadastro de cursos presenciais e EAD;
- Criação e gerenciamento de turmas;
- Associação de alunos e professores às turmas;
- Adição e remoção de alunos das turmas;
- Registro de avaliações e atribuição de notas;
- Autenticação de usuários por meio de interface;
- Geração de relatórios acadêmicos;
- Validação de dados e tratamento de exceções;
- Menu interativo via console.

## 🛠️ Tecnologias utilizadas

- Java 25
- IntelliJ IDEA

## 📚 Conceitos aplicados

- Classes e objetos;
- Encapsulamento;
- Herança;
- Polimorfismo;
- Abstração;
- Interfaces;
- Associações entre objetos;
- Sobrescrita de métodos;
- Collections (List e ArrayList);
- Tratamento de exceções;
- Arquitetura em camadas;
- Separação de responsabilidades.

## 📂 Estrutura do projeto

```text
EduConnect/
├── src/
│   ├── model/
│   │   ├── Administrador.java
│   │   ├── Aluno.java
│   │   ├── Autenticacao.java
│   │   ├── Avaliacao.java
│   │   ├── Curso.java
│   │   ├── CursoEAD.java
│   │   ├── CursoPresencial.java
│   │   ├── Professor.java
│   │   ├── Relatorio.java
│   │   ├── Turma.java
│   │   └── Usuario.java
│   ├── repository/
│   │   ├── AlunoRepository.java
│   │   ├── CursoRepository.java
│   │   ├── ProfessorRepository.java
│   │   └── TurmaRepository.java
│   ├── service/
│   │   ├── AlunoService.java
│   │   ├── CursoService.java
│   │   ├── ProfessorService.java
│   │   └── TurmaService.java
│   ├── ui/
│   │   ├── MenuPrincipal.java
│   │   ├── MenuRelatorio.java
│   │   └── MenuTurmas.java
│   └── Main.java
├── .gitignore
└── README.md
```

## 🏗️ Arquitetura do sistema

O projeto foi organizado em camadas para facilitar a manutenção,
a organização do código e a separação de responsabilidades.

| Camada | Responsabilidade |
|---|---|
| Model | Entidades e regras de domínio |
| Repository | Armazenamento temporário dos dados em listas |
| Service | Regras de negócio e validações |
| UI | Interação com o usuário por meio de menus |
| Main | Inicialização e integração das camadas |

## 💻 Menu principal

```text
============== EDUCONNECT ==============
1 - Cadastrar curso
2 - Cadastrar professor
3 - Cadastrar aluno
4 - Gerenciar turmas
5 - Registrar avaliações
6 - Relatórios
0 - Sair
========================================
```

## 🛡️ Validações e tratamento de erros

O sistema possui mecanismos de validação para garantir a
consistência dos dados, incluindo:

- Prevenção de cadastros duplicados;
- Validação de atributos obrigatórios;
- Verificação da existência de professores e cursos;
- Prevenção de matrículas duplicadas em turmas;
- Validação de notas entre 0 e 10;
- Tratamento de entradas inválidas.

Foram realizados testes manuais de cenários de sucesso e falha
para verificar o comportamento das funcionalidades.

## ⚙️ Como executar

### Pré-requisitos

- JDK 25;
- Git;
- IntelliJ IDEA ou outra IDE compatível com Java.

### Clonando o repositório

```bash
git clone git@github.com:marciaadrielle/EduConnect.git
```

### Executando o projeto

1. Abra o projeto na IDE de sua preferência.
2. Configure o JDK.
3. Localize a classe `Main.java`.
4. Execute o método `main()`.
5. Utilize o menu interativo no console.

## 💾 Armazenamento de dados

O sistema utiliza listas para armazenar os dados temporariamente
em memória, sem integração com banco de dados.

Os registros são mantidos durante a execução do programa e
descartados após seu encerramento.

## 🎯 Objetivo acadêmico

Consolidar os conhecimentos adquiridos na disciplina de
Programação Orientada a Objetos, aplicando conceitos teóricos
no desenvolvimento de um sistema funcional, modular e organizado.

## 👩‍💻 Autora

**Márcia Adrielle**

Estudante de Análise e Desenvolvimento de Sistemas.

[GitHub](https://github.com/marciaadrielle)
