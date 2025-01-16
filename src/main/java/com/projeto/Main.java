package main.java.com.projeto;

import main.java.com.projeto.entidades.Aluno;
import main.java.com.projeto.entidades.Curso;
import main.java.com.projeto.entidades.Diretor;
import main.java.com.projeto.entidades.Professor;

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
                        while (true) {
                            System.out.println("Você é:\n" +
                                    "1 - Professor\n" +
                                    "2 - Diretor");

                            int opcaoFuncionario = scan.nextInt();
                            scan.nextLine();

                            if (opcaoFuncionario == 1) {
                                System.out.println("Opção escolhida: Professor");
                                criarOuEntrarUsuario("Professor", listaProfessores, scan);
                                break;
                            } else if (opcaoFuncionario == 2) {
                                System.out.println("Opção escolhida: Diretor");
                                criarOuEntrarUsuario("Diretor", listaDiretores, scan);
                                break;
                            } else {
                                System.out.println("Opção inválida, tente novamente.");
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Opção escolhida: Aluno");
                        criarOuEntrarUsuario("Aluno", listaAlunos, scan);
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

    private static <T> void criarOuEntrarUsuario(String cargo, List<T> lista, Scanner scan) {
        System.out.println("O que deseja:\n" +
                "1 - Entrar como usuário existente\n" +
                "2 - Criar usuário");

        try {
            int opcao = scan.nextInt();
            scan.nextLine();

            if (opcao == 1) {
                System.out.println("Digite o nome do seu usuário:");
                String nome = scan.nextLine();
                boolean usuarioEncontrado = lista.stream().anyMatch(usuario -> {
                    if (usuario instanceof Aluno aluno) return aluno.getNome().equals(nome);
                    if (usuario instanceof Professor professor) return professor.getNome().equals(nome);
                    if (usuario instanceof Diretor diretor) return diretor.getNome().equals(nome);
                    return false;
                });

                if (usuarioEncontrado) {
                    System.out.println("Usuário encontrado! Entrando como: " + nome);
                } else {
                    System.out.println("Usuário não encontrado!");
                }

            } else if (opcao == 2) {
                System.out.println("Digite seu nome:");
                String nome = scan.nextLine();

                switch (cargo) {
                    case "Aluno" -> {
                        System.out.println("Digite o nome do curso em que frequenta:");
                        String nomeCurso = scan.nextLine();
                        Aluno aluno = new Aluno(nome, List.of(new Curso(nomeCurso, null)));
                        lista.add((T) aluno);
                        System.out.println("Aluno " + nome + " criado com sucesso!");
                    }
                    case "Professor" -> {
                        System.out.println("Digite sua idade:");
                        int idade = scan.nextInt();
                        System.out.println("Digite seu tempo de trabalho (anos):");
                        int tempoDeTrabalho = scan.nextInt();
                        scan.nextLine();

                        Professor professor = new Professor(nome, idade, tempoDeTrabalho);
                        lista.add((T) professor);
                        System.out.println("Professor " + nome + " criado com sucesso!");
                    }
                    case "Diretor" -> {
                        System.out.println("Digite seu tempo de cargo (anos):");
                        int tempoDeTrabalho = scan.nextInt();
                        System.out.println("Digite seu salário:");
                        double salario = scan.nextDouble();
                        scan.nextLine();

                        Diretor diretor = new Diretor(nome, tempoDeTrabalho, salario);
                        lista.add((T) diretor);
                        System.out.println("Diretor " + nome + " criado com sucesso!");
                    }
                }
            } else {
                System.out.println("Opção inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro ao criar ou entrar como usuário: " + "Por favor, digite um número válido");
            scan.nextLine();
        }
    }
}
