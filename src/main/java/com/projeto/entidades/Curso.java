package main.java.com.projeto.entidades;

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
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", professor=" + professor +
                '}';
    }
}
