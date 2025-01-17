package main.java.com.projeto;

import main.java.com.projeto.entidades.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Aluno> listaAlunos = new ArrayList<>();
        List<Professor> listaProfessores = new ArrayList<>();
        List<Diretor> listaDiretores = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma das opções:\n" +
                    "1 - Sou funcionário\n" +
                    "2 - Sou aluno\n" +
                    "3 - Sair");

            try {
                int opcaoCargo = scan.nextInt();
                scan.nextLine();

                switch (opcaoCargo) {
                    case 1 -> {
                        boolean continuarProfessorDiretor = true;
                        while (continuarProfessorDiretor) {
                            System.out.println("Você é:\n" +
                                    "1 - Professor\n" +
                                    "2 - Diretor");

                            int opcaoFuncionario = scan.nextInt();
                            scan.nextLine();

                            if (opcaoFuncionario == 1) {
                                System.out.println("Opção escolhida: Professor");
                                Professor professor = criarOuEntrarUsuario("Professor", listaProfessores, scan);

                                if (professor != null) {
                                    boolean continuarProfessor = true;
                                    while (continuarProfessor) {
                                        System.out.println("O que deseja realizar:\n" +
                                                "1 - Listar alunos\n" +
                                                "2 - Adicionar aluno\n" +
                                                "3 - remover aluno\n" +
                                                "4 - sair");

                                        int opcaoProfessor = scan.nextInt();
                                        scan.nextLine();

                                        switch (opcaoProfessor) {
                                            case 1:
                                                professor.listarAlunos();
                                                break;
                                            case 2:
                                                System.out.println("Digite o nome do aluno que deseja adicionar:");
                                                String nomeAlunoAdicionar = scan.nextLine().toLowerCase();
                                                professor.adicionarAluno(nomeAlunoAdicionar);
                                                break;
                                            case 3:
                                                System.out.println("Digite o nome do aluno que deseja remover:");
                                                String nomeAlunoRemover = scan.nextLine().toLowerCase();
                                                professor.removerAluno(nomeAlunoRemover);
                                                break;
                                            case 4:
                                                System.out.println("Voltando ao menu principal...");
                                                continuarProfessor = false;
                                                continuarProfessorDiretor = false;
                                                break;
                                            default:
                                                System.out.println("Opção inválida, tente novamente.");
                                        }
                                    }
                                }
                            } else if (opcaoFuncionario == 2) {
                                System.out.println("Opção escolhida: Diretor");
                                Diretor diretor = criarOuEntrarUsuario("Diretor", listaDiretores, scan);

                                if (diretor != null) {
                                    boolean continuarDiretor = true;
                                    while (continuarDiretor) {
                                        System.out.println("O que deseja realizar:\n" +
                                                "1 - Promover professor\n" +
                                                "2 - Adicionar professor\n" +
                                                "3 - Remover professor\n" +
                                                "4 - Adicionar aluno\n" +
                                                "5 - Remover aluno\n" +
                                                "6 - Listar alunos e professores\n" +
                                                "7 - Sair");

                                        int opcaoDiretor = scan.nextInt();
                                        scan.nextLine();

                                        switch (opcaoDiretor) {
                                            case 1:
                                                System.out.println("Digite o nome do professor que deseja promover:");
                                                String nomeProfessorPromovido = scan.nextLine().toLowerCase();
                                                diretor.promover(nomeProfessorPromovido);
                                                break;
                                            case 2:
                                                System.out.println("Digite o nome do Professor que deseja adicionar:");
                                                String nomeProfessorAdicionar = scan.nextLine().toLowerCase();
                                                diretor.adicionarProfessor(nomeProfessorAdicionar);
                                                break;
                                            case 3:
                                                System.out.println("Digite o nome do Professor que deseja remover:");
                                                String nomeProfessorRemover = scan.nextLine().toLowerCase();
                                                diretor.removerProfessor(nomeProfessorRemover);
                                                break;
                                            case 4:
                                                System.out.println("Digite o nome do aluno que deseja adicionar:");
                                                String nomeAlunoAdicionar = scan.nextLine().toLowerCase();
                                                diretor.adicionarAluno(nomeAlunoAdicionar);
                                                break;
                                            case 5:
                                                System.out.println("Digite o nome do aluno que deseja remover:");
                                                String nomeAlunoRemover = scan.nextLine().toLowerCase();
                                                diretor.removerAluno(nomeAlunoRemover);
                                                break;
                                            case 6:
                                                diretor.listarAlunosProfessores();
                                                break;
                                            case 7:
                                                System.out.println("Voltando ao menu principal...");
                                                continuarDiretor = false;
                                                break;
                                            default:
                                                System.out.println("Opção inválida, tente novamente.");
                                        }
                                    }
                                } else {
                                    System.out.println("Erro ao tentar encontrar ou criar o diretor. Tente novamente.");
                                }
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Opção escolhida: Aluno");
                        Aluno aluno = criarOuEntrarUsuario("Aluno", listaAlunos, scan);

                        if (aluno != null) {
                            boolean continuarAluno = true;
                            while (continuarAluno) {
                                if (aluno.getContaAtiva()) {
                                    System.out.println("O que deseja realizar:\n" +
                                            "1 - Listar cursos\n" +
                                            "2 - Adicionar curso\n" +
                                            "3 - remover curso\n" +
                                            "4 - trancar conta\n" +
                                            "5 - sair");

                                    int opcaoAluno = scan.nextInt();
                                    scan.nextLine();

                                    switch (opcaoAluno) {
                                        case 1:
                                            aluno.listarCursos();
                                            break;
                                        case 2:
                                            System.out.println("Digite o nome do curso que deseja adicionar:");
                                            String nomeCursoAdicionar = scan.nextLine().toLowerCase();
                                            aluno.adicionarCurso(nomeCursoAdicionar);
                                            break;

                                        case 3:
                                            System.out.println("Digite o nome do curso que deseja remover:");
                                            String nomeCursoRemover = scan.nextLine().toLowerCase();
                                            aluno.removerCurso(nomeCursoRemover);
                                            break;

                                        case 4:
                                            System.out.println("Desativando sua conta");
                                            aluno.setContaAtiva(false);
                                            break;

                                        case 5:
                                            System.out.println("Voltando ao menu principal...");
                                            continuarAluno = false;
                                            break;

                                        default:
                                            System.out.println("Opção inválida, tente novamente.");
                                    }
                                } else {
                                    System.out.println("O que deseja realizar:\n" +
                                            "1 - Ativar contaa\n" +
                                            "2 - Sair");

                                    int opcaoAtivarConta = scan.nextInt();
                                    scan.nextLine();

                                    if (opcaoAtivarConta == 1) {
                                        System.out.println("Ativando sua conta");
                                        aluno.setContaAtiva(true);
                                    } else if (opcaoAtivarConta == 2) {
                                        System.out.println("Voltando ao menu principal...");
                                        continuarAluno = false;
                                    } else {
                                        System.out.println("Opção inválida! Por favor, digite um número válido.");
                                    }
                                }
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Encerrando...");
                        continuar = false;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, digite um número válido.");
                scan.nextLine();
            }
        }
        scan.close();
    }

    private static <T> T criarOuEntrarUsuario(String cargo, List<T> lista, Scanner scan) {
        System.out.println("O que deseja:\n" +
                "1 - Entrar como usuário existente\n" +
                "2 - Criar usuário");

        try {
            int opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o nome do seu usuário:");
                String nome = scan.nextLine().toLowerCase();

                for (T usuario : lista) {
                    if (usuario instanceof Aluno aluno && aluno.getNome().toLowerCase().equals(nome)) {
                        System.out.println("Usuário encontrado! Entrando como: " + nome);
                        return (T) aluno;
                    }

                    if (usuario instanceof Professor professor && professor.getNome().toLowerCase().equals(nome)) {
                        System.out.println("Usuário encontrado! Entrando como: " + nome);
                        return (T) professor;
                    }


                    if (usuario instanceof Diretor diretor && diretor.getNome().toLowerCase().equals(nome)) {
                        System.out.println("Usuário encontrado! Entrando como: " + nome);
                    }
                }
                System.out.println("Usuário não encontrado!");
                return null;

            } else if (opcao == 2) {
                System.out.println("Digite seu nome:");
                String nome = scan.nextLine();

                switch (cargo) {
                    case "Aluno" -> {
                        System.out.println("Digite o nome do curso em que frequenta:");
                        String nomeCurso = scan.nextLine();
                        Aluno aluno = new Aluno(nome, new ArrayList<>(List.of(new Curso(nomeCurso, null))));
                        lista.add((T) aluno);
                        aluno.setContaAtiva(true);
                        System.out.println("Aluno " + nome + " criado com sucesso!");
                        return (T) aluno;
                    }
                    case "Professor" -> {
                        System.out.println("Digite sua idade:");
                        int idade = scan.nextInt();
                        if (idade < 18) {
                            System.out.println("Idade inválida. Precisa ser maior que 18");
                        } else {
                            System.out.println("Digite seu tempo de trabalho (anos):");
                            int tempoDeTrabalho = scan.nextInt();
                            scan.nextLine();
                            if (tempoDeTrabalho < 0) {
                                System.out.println("Tempo de trabalho inválido. Precisa ser maior que 0");
                            } else {

                                Professor professor = new Professor(nome, idade, tempoDeTrabalho);
                                Turma turma = new Turma();

                                professor.setTurma(turma);
                                lista.add((T) professor);
                                System.out.println("Professor " + nome + " criado com sucesso!");
                                return (T) professor;
                            }
                        }
                    }
                    case "Diretor" -> {
                        System.out.println("Digite seu tempo de trabalho (anos):");
                        int tempoDeTrabalho = scan.nextInt();
                        if (tempoDeTrabalho < 0) {
                            System.out.println("Tempo de trabalho inválido. Precisa ser maior que 0");
                        } else {
                            System.out.println("Digite seu salário:");
                            double salario = scan.nextDouble();
                            scan.nextLine();
                            if (salario < 0) {
                                System.out.println("Salário inválido Precisa ser maior que 0");
                            } else {

                                Diretor diretor = new Diretor(nome, tempoDeTrabalho, salario);
                                lista.add((T) diretor);
                                System.out.println("Diretor " + nome + " criado com sucesso!");
                                return (T) diretor;
                            }
                        }
                    }
                }
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro ao criar ou entrar como usuário: " + "Por favor, digite um número válido");
            scan.nextLine();
        }
        return null;
    }
}
