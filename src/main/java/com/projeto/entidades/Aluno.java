package main.java.com.projeto.entidades;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private final List<Curso> cursos;

    public Aluno() {
        this.cursos = new ArrayList<>();
    }

    public Aluno(String nome, List<Curso> cursos) {
        this.nome = nome;
        this.cursos = cursos != null ? cursos : new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCursos() {
        return cursos.toString();
    }

    public void setCursos(List<Curso> cursos) {
        if (cursos != null) {
            this.cursos.clear();
            this.cursos.addAll(cursos);
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso encontrado");
        } else {
            System.out.println("Cursos do aluno " + nome + ":");
            for (Curso curso : cursos) {
                System.out.println("- " + curso.getNome());
            }
        }
    }

    public void adicionarCurso(Curso curso) {
        if (!cursos.contains(curso) && curso != null) {
            cursos.add(curso);
            System.out.println("Curso " + curso.getNome() + " adicionado com sucesso ao aluno " + nome);
        } else {
            System.out.println("Curso inválido ou já adicionado.");
        }
    }

    public void removerCurso(Curso curso) {
        if (cursos.remove(curso)) {
            System.out.println("Curso " + curso.getNome() + " removido do aluno " + nome + ".");
        } else {
            System.out.println("O curso não está matriculado para o aluno.");
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
