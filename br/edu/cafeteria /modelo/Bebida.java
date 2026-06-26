package br.edu.cafeteria.modelo;
import br.edu.cafeteria.modelo.Produto;

public class Bebida extends Produto {
    private String tamanho;
    private double cafeinaMg;

    public Bebida(String codigo, String nome, double precoBase, int quantidadeEstoque, String tamanho, double cafeinaMg) {
        super(codigo, nome, precoBase, quantidadeEstoque);
        this.tamanho = tamanho;
        this.cafeinaMg = cafeinaMg;
    }
    public String getTamanho() {
        return tamanho;
    }
    public double getCafeinaMg() {
        return cafeinaMg;
    }
    
}