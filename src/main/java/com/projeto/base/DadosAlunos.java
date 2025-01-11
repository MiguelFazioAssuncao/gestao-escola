package main.java.com.projeto.base;

import main.java.com.projeto.entidades.Aluno;

import java.util.ArrayList;

public class DadosAlunos {
    ArrayList<Aluno> alunos;

    public void adicionarAlunos(Aluno aluno) {
        try {
            if (aluno == null) {
                throw new IllegalArgumentException("Aluno não pode ser nulo");
            }

            if (!alunos.contains(aluno)) {
                alunos.add(aluno);
                System.out.println("Aluno " + aluno.getNome() + " adicionado com sucesso.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar aluno: " + e.getMessage());
        }
    }

    public void removerAlunos(int id) {
        try {
            if (id < 0 || id >= alunos.size()) {
                throw new IndexOutOfBoundsException("ID invalido");
            }

            Aluno professorRemovido = alunos.remove(id);
            System.out.println("Aluno " + professorRemovido.getNome() + " removido com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao remover aluno: " + e.getMessage());
        }
    }

    public Aluno buscarAlunos(int id) {
        try {
            if (id < 0 || id >= alunos.size()) {
                throw new IndexOutOfBoundsException("ID invalido");
            }

            return alunos.get(id);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao buscar alunos: " + e.getMessage());
        }
        return null;
    }
}
