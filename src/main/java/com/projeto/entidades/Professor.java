package main.java.com.projeto.entidades;

public class Professor extends Funcionario{
    private String nome;
    private int idade;
    private int tempoTrabalho;
    private Turma turma;

    public Professor() {
    }

    public Professor(String nome) {
        this.nome = nome;
    }

    public Professor(String nome, int idade, int tempoTrabalho) {
        this.nome = nome;
        this.idade = idade;
        this.tempoTrabalho = tempoTrabalho;
    }

    public Professor(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTempoTrabalho() {
        return tempoTrabalho;
    }

    public void setTempoTrabalho(int tempoTrabalho) {
        this.tempoTrabalho = tempoTrabalho;
    }

    public void listarAlunos() {
        turma.listarAlunos();
    }

    public void adicionarAluno(String nomeAluno) {
        turma.adicionarAluno(nomeAluno);
    }

    public void removerAluno(String nomeAluno) {
        turma.removerAluno(nomeAluno);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", tempoTrabalho=" + tempoTrabalho +
                '}';
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
