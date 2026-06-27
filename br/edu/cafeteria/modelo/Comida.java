package br.edu.cafeteria.modelo;
import br.edu.cafeteria.modelo.Produto;

public class Comida extends Produto {
    private int tempoPreparoMinutos;
    private boolean vegano;
    private boolen semGluten;

    public Comida(String codigo, String nome, double precoBase, int quantidadeEstoque, int tempoPreparoMinutos, boolean vegano, boolean semGluten) {
        super(codigo, nome, precoBase, quantidadeEstoque);
        this.tempoPreparoMinutos = tempoPreparoMinutos;
        this.vegano = vegano;
        this.semGluten = semGluten;
    }

    public int getTempoPreparoMinutos(){
        return tempoPreparoMinutos;
    }

    public boolean isVegano(){
        return vegano;
    }
    public boolean isSemGluten(){
        return semGluten;
    }

}