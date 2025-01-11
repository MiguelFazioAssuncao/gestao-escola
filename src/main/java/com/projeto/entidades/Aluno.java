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

    public List<Curso> getCursos() {
        return new ArrayList<>(cursos);
    }

    public void setCursos(List<Curso> cursos) {
        if (cursos != null) {
            this.cursos.clear();
            this.cursos.addAll(cursos);
        }
    }

    public void listarCursos() {
        try {
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso encontrado");
        } else {
           System.out.println("Cursos do aluno " + nome + ":");
            for (Curso curso : cursos) {
                System.out.println("- " + curso.getNome());
            }
          }
        } catch (Exception e){
            System.out.println("Erro ao listar cursos: " + e.getMessage());
        }
    }

    public void adicionarCurso(Curso curso) {
        try {
            if (curso == null) {
                throw new IllegalArgumentException("Nenhum curso encontrado");
            }

            if (!cursos.contains(curso)) {
                cursos.add(curso);
                System.out.println("Curso " + curso.getNome() + " adicionado com sucesso.");
            } else {
                System.out.println("Curso já cadastado");
            }

        } catch (IllegalArgumentException e){
            System.out.println("Erro ao adicionar curso: " + e.getMessage());
        }
    }

    public void adicionarCursos(String nomeCurso) throws IllegalArgumentException {
        try {
        if (nomeCurso != null && !nomeCurso.isEmpty()) {
            Curso curso = new Curso(nomeCurso, null);
            adicionarCurso(curso);
        } else {
            throw new IllegalArgumentException("Nenhum curso encontrado");
          }

        } catch (IllegalArgumentException e){
            System.out.println("Erro ao adicionar cursos pelo nome: " + e.getMessage());
        }
    }

    public void removerCurso(Curso curso) {
        try {
            if (curso == null) {
                throw new IllegalArgumentException("O curso selecionado não pode ser nula");
            }
           if (cursos.remove(curso)) {
               System.out.println("Curso " + curso.getNome() + " removido do aluno " + nome + ".");
          } else {
               System.out.println("O curso não está matriculado para o aluno.");
           }
        } catch (IllegalArgumentException e){
            System.out.println("Erro ao remover curso: " + e.getMessage());
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
