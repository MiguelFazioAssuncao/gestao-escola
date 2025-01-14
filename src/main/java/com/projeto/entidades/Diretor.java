package main.java.com.projeto.entidades;

public class Diretor extends Funcionario{
    private int tempoDeCargo;

    public Diretor(){
    }

    public Diretor(String nome, int tempoDeCargo, Double salario) {
        this.setNome(nome);
        this.tempoDeCargo = tempoDeCargo;
        this.setSalario(salario);
    }

    public Diretor(int tempoDeCargo) {
        this.tempoDeCargo = tempoDeCargo;
    }

    public int getTempoDeCargo() {
        return tempoDeCargo;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "tempoDeCargo=" + tempoDeCargo +
                '}';
    }
}
