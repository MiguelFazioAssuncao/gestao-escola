package main.java.com.projeto.entidades;

import java.util.Objects;

public class Curso {
    private String nome;
    private Professor professor;

    public Curso() {
    }

    public Curso(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setProfessor(String nomeProfessor, int idade) {
        this.professor = new Professor(nomeProfessor, idade, 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Curso curso = (Curso) obj;
        return Objects.equals(nome, curso.nome);
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", professor=" + professor +
                '}';
    }
}
