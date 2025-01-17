package main.java.com.projeto.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {
    private String nome;
    private final List<Curso> cursos;
    private boolean contaAtiva = false;

    public Aluno() {
        this.cursos = new ArrayList<>();
    }

    public Aluno(String nome, List<Curso> cursos) {
        this.nome = nome;
        this.cursos = cursos != null ? new ArrayList<>(cursos) : new ArrayList<>();
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

    public boolean getContaAtiva() {
        return contaAtiva;
    }

    public void setContaAtiva(boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
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
        } catch (Exception e) {
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

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar curso: " + e.getMessage());
        }
    }

    public void adicionarCurso(String nomeCurso) {
        try {
            if (nomeCurso == null || nomeCurso.isEmpty()) {
                System.out.println("Erro ao adicionar curso: Nome do curso não pode ser nulo ou vazio.");
                return;
            }
            Curso novoCurso = new Curso(nomeCurso, null);
            if (cursos.contains(novoCurso)) {
                System.out.println("Este curso já foi adicionado!");
            } else {
                cursos.add(novoCurso);
                System.out.println("Curso " + nomeCurso + " adicionado com sucesso.");
            }
       } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar curso: " + e.getMessage());
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
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao remover curso: " + e.getMessage());
        }
    }

    public void removerCurso(String nomeCurso) {
        if (nomeCurso == null || nomeCurso.isEmpty()) {
            throw new IllegalArgumentException("Nome do curso não pode ser nulo ou vazio.");
        }
        boolean cursoRemovido = cursos.removeIf(curso -> curso.getNome().equalsIgnoreCase(nomeCurso));
        if (cursoRemovido) {
            System.out.println("Curso " + nomeCurso + " removido com sucesso.");
        } else {
            System.out.println("Nenhum curso encontrado");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome, aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", cursos=" + cursos +
                '}';
    }
}
