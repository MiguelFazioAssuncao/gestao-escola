package main.java.com.projeto.entidades;

import main.java.com.projeto.interfaces.IFuncionario;

import java.util.ArrayList;
import java.util.List;

public class Diretor extends Funcionario implements IFuncionario {
    private int tempoDeCargo;
    private List<Professor> professores;
    private List<Aluno> alunos;
    private Turma turma;

    public Diretor(){
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<Aluno>();
        this.turma = new Turma();
    }

    public Diretor(String nome, int tempoDeCargo, Double salario) {
        super(nome, salario);
        this.tempoDeCargo = tempoDeCargo;
        this.professores = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.turma = new Turma();
    }

    public Diretor(int tempoDeCargo) {
        this.tempoDeCargo = tempoDeCargo;
    }

    public int getTempoDeCargo() {
        return tempoDeCargo;
    }

    public void adicionarProfessor(String nomeProfessor) {
        try {
            if (nomeProfessor == null || nomeProfessor.isEmpty()) {
                System.out.println("Erro ao adicionar professor: Nome do professor não pode ser nulo ou vazio.");
                return;
            }

            Professor professor = new Professor(nomeProfessor);
            if (professores.contains(professor)) {
                System.out.println("Este professor já foi adicionado!");
            } else {
                professores.add(professor);
                System.out.println("Professor " + nomeProfessor + " adicionado com sucesso.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar professor: " + e.getMessage());
        }
    }

    public void removerProfessor(String nomeProfessor) {
        if (nomeProfessor == null || nomeProfessor.isEmpty()) {
            throw new IllegalArgumentException("Nome do professor não pode ser nulo ou vazio.");
        }
        boolean professorRemovido = professores.removeIf(professor -> professor.getNome().equalsIgnoreCase(nomeProfessor));
        if (professorRemovido) {
            System.out.println("Professor " + nomeProfessor + " removido com sucesso.");
        } else {
            System.out.println("Nenhum professor encontrado");
        }
    }

    public void adicionarAluno(String nomeAluno) {
        turma.adicionarAluno(nomeAluno);
    }

    public void removerAluno(String nomeAluno) {
        turma.removerAluno(nomeAluno);
    }

    public void listarAlunosProfessores() {
        try {
            if (professores.isEmpty()) {
                System.out.println("Nenhum professor encontrado");
            } else {
                System.out.println("Professores encontrados: " + professores.size());
                for (int i = 0; i < professores.size(); i++) {
                    System.out.println((i + 1) + " - " + professores.get(i).getNome());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar professores : " + e.getMessage());
        }
        turma.listarAlunos();
    }


    @Override
    public void promover(String nome) {
        System.out.println("Diretor " + nome + " promovido.");
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "tempoDeCargo=" + tempoDeCargo +
                '}';
    }
}
