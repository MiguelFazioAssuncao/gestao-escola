# Sistema de Gestão de Alunos

Este projeto implementa um sistema simples de gestão de alunos, professores, turmas e cursos. Ele oferece funcionalidades para adicionar, listar e remover alunos de turmas, além de associar turmas a cursos específicos.

## Funcionalidades

- **Gestão de Alunos:**  
  - Adição de alunos a turmas.
  - Remoção de alunos de turmas.
  - Listagem de alunos de turmas.
  
- **Gestão de Professores:**  
  - Atribuição de professores às turmas.
  - Edição das informações dos professores.

- **Gestão de Turmas:**  
  - Cada turma é vinculada a um curso.
  - Possibilidade de adicionar, remover e listar alunos de uma turma.

- **Gestão de Cursos:**  
  - Cursos podem ser associados a turmas.
  - Vinculação de alunos ao seu respectivo curso.

## Estrutura do Projeto

### Classes Principais

- **Aluno:**  
  Representa um aluno, com atributos como nome e idade.

- **Professor:**  
  Estende a classe `Funcionario` e gerencia os atributos relacionados ao professor, como nome, idade e tempo de trabalho. Um professor pode estar associado a uma turma.

- **Turma:**  
  Contém uma lista de alunos e está associada a um curso. Permite adicionar, remover e listar alunos de uma turma.

- **Curso:**  
  Representa um curso, com atributos como nome e descrição.

- **Funcionario:**  
  Classe base que define os atributos comuns a todos os funcionários (como professores), como nome e idade.

### Funcionalidades

- **Adicionar Aluno:**  
  O sistema permite adicionar alunos à turma por nome ou como objetos `Aluno`.

- **Remover Aluno:**  
  É possível remover alunos da turma especificando o nome ou utilizando o objeto aluno.

- **Listar Alunos:**  
  Você pode listar todos os alunos de uma turma ou buscar por alunos específicos pelo nome.

## Como Executar

Para rodar o projeto, siga os passos abaixo:

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/projeto-gestao-alunos.git
