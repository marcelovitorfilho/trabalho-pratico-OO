package br.edu.cafeteria.modelo;

public class bebida extends Produto {
    private String tamanho;
    private double cafeinaMg;

    public bebida(String codigo, String nome, double precoBase, int quantidadeEstoque, String tamanho, double cafeinaMg) {
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