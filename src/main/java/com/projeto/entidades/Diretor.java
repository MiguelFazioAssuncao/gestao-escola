package main.java.com.projeto.entidades;

public class Diretor extends Funcionario{
    private int tempoDeCargo;

    public Diretor(){
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
