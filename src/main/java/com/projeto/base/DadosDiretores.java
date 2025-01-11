package main.java.com.projeto.base;

import main.java.com.projeto.entidades.Diretor;

import java.util.ArrayList;

public class DadosDiretores {
    ArrayList<Diretor> diretores;

    public void adicionarDiretores(Diretor diretor) {
        try {
            if (diretor == null) {
                throw new IllegalArgumentException("Diretor não pode ser nulo");
            }

            if (!diretores.contains(diretor)) {
                diretores.add(diretor);
                System.out.println("Diretor " + diretor.getNome() + " adicionado com sucesso.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar diretor: " + e.getMessage());
        }
    }

    public void removerDiretores(int id) {
        try {
            if (id < 0 || id >= diretores.size()) {
                throw new IndexOutOfBoundsException("ID invalido");
            }

            Diretor professorRemovido = diretores.remove(id);
            System.out.println("Diretor " + professorRemovido.getNome() + " removido com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao remover diretor: " + e.getMessage());
        }
    }

    public Diretor buscarDiretores(int id) {
        try {
            if (id < 0 || id >= diretores.size()) {
                throw new IndexOutOfBoundsException("ID invalido");
            }

            return diretores.get(id);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao buscar Diretor: " + e.getMessage());
        }
        return null;
    }
}
