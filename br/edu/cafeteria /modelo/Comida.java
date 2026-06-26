package br.edu.cafeteria.modelo;
import br.edu.cafeteria.modelo.Produto;

public class Comida extends Produto {
    private int tempoPreparoMinutos;
    private boolean vegano;

    public Comida(String codigo, String nome, double precoBase, int quantidadeEstoque, int tempoPreparoMinutos, boolean vegano) {
        super(codigo, nome, precoBase, quantidadeEstoque);  
        this.tempoPreparoMinutos = tempoPreparoMinutos;
        this.vegano = vegano;
    }

    public int getTempoPreparoMinutos() {
        return tempoPreparoMinutos;
    }

    public boolean isVegano() {
        return vegano;
    }


}