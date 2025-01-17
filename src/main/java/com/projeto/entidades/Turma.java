package main.java.com.projeto.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;
    private Date ano;
    private Curso curso;

    public Turma() {
        this.alunos = new ArrayList<>();
        this.ano = new Date();
    }

    public Turma(List<Aluno> alunos, Curso curso) {
        this.alunos = alunos != null ? alunos : new ArrayList<Aluno>();
        this.curso = curso;
        this.ano = new Date();
    }

    public void listarAlunos() {
        try {
            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno encontrado");
            } else {
                System.out.println("Alunos encontrados: " + alunos.size());
                for (int i = 0; i < alunos.size(); i++) {
                    System.out.println((i + 1) + " - " + alunos.get(i).getNome());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
    }


    public void listarAlunos(String nome) {
        try {
            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno encontrado");
            } else {
                for (Aluno aluno : alunos) {
                    if (aluno.getNome().equals(nome)) {
                        System.out.println(" - " + aluno.getNome());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos pelo nome: " + e.getMessage());
        }
    }

    public void adicionarAluno(Aluno aluno) {
        try {
            if (alunos == null) {
                throw new IllegalArgumentException("Aluno não pode ser nulo");
            }

            if (!alunos.contains(aluno)) {
                alunos.add(aluno);
                System.out.println("Aluno " + aluno.getNome() + " adicionado com sucesso á turma.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar aluno: " + e.getMessage());
        }
    }

    public void adicionarAluno(String nomeAluno) {
        try {
            if (nomeAluno == null || nomeAluno.isEmpty()) {
                System.out.println("Erro ao adicionar aluno: Nome do aluno não pode ser nulo ou vazio.");
                return;
            }
            Aluno novoAluno = new Aluno(nomeAluno, null);
            if (alunos.contains(novoAluno)) {
                System.out.println("Este aluno já foi adicionado!");
            } else {
                alunos.add(novoAluno);
                System.out.println("Aluno " + nomeAluno + " adicionado com sucesso.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar aluno: " + e.getMessage());
        }
    }

    void removerAluno(String nomeAluno) {
       if (nomeAluno == null || nomeAluno.isEmpty()) {
           throw new IllegalArgumentException("Nome do aluno não pode ser nulo ou vazio.");
       }
       boolean alunoRemovido = alunos.removeIf(aluno -> aluno.getNome().equals(nomeAluno));

       if (alunoRemovido) {
           System.out.println("Aluno " + nomeAluno + " removido com sucesso.");
       } else {
           System.out.println("Nenhum aluno encontrado");
       }
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "alunos=" + alunos +
                ", ano=" + ano +
                ", curso=" + curso +
                '}';
    }
}
