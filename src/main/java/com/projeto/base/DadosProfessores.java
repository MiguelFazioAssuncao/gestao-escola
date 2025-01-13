package main.java.com.projeto.base;

import main.java.com.projeto.entidades.Professor;

import java.util.ArrayList;

public class DadosProfessores {
    ArrayList<Professor> professores;

    public void adicionarProfessores(Professor professor) {
        try {
            if (professor == null) {
                throw new IllegalArgumentException("Professor não pode ser nulo");
            }

            if (!professores.contains(professor)) {
                professores.add(professor);
                System.out.println("Professor " + professor.getNome() + " adicionado com sucesso.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar professor: " + e.getMessage());
        }
    }

    public void removerProfessores(int id) {
        try {
            if (id < 0 || id >= professores.size()) {
                throw new IndexOutOfBoundsException("ID invalido");
            }

            Professor professorRemovido = professores.remove(id);
            System.out.println("Professor " + professorRemovido.getNome() + " removido com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao remover professor: " + e.getMessage());
        }
    }

    public Professor buscarProfessores(int id) {
        try {
            if (id < 0 || id >= professores.size()) {
                throw new IndexOutOfBoundsException("ID invalido");
            }

            return professores.get(id);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao buscar professor: " + e.getMessage());
        }
        return null;
    }
}
