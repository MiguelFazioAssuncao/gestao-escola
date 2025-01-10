package main.java.com.projeto.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;
    private Date ano;
    private Curso curso;

    public Turma() {
    }

    public Turma(List<Aluno> alunos, Curso curso) {
        this.alunos = alunos != null ? alunos : new ArrayList<Aluno>();
        this.curso = curso;
        this.ano = new Date();
    }

    public void listarAlunos(List<Aluno> alunos) {
        if(alunos.isEmpty()) {
            System.out.println("Nenhum aluno encontrado");
        } else {
            System.out.println("Alunos encontrados: " + alunos.size());
            for (Aluno aluno : alunos) {
                System.out.println(" - " + aluno.getNome());
            }
        }
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno) && aluno!=null) {
            System.out.println("Aluno ja adicionado");
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado a turma");
        } else {
            System.out.println("Nenhum aluno encontrado");
        }
    }

    void removerAluno(Aluno aluno) {
        if(aluno!= null && alunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " removido da turma");
        } else {
            System.out.println("Nenhum aluno encontrado na turma");
        }
    }

    public List<Aluno> getAlunos() {
        return alunos;
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
