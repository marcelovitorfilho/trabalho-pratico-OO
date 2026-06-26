package br.edu.cafeteria.modelo;

public class comida extends Produto {
    private String tempoPreparoMinutos;
    private boolean vegano;

    public comida(String codigo, String nome, double precoBase, int quantidadeEstoque, String tempoPreparoMinutos, double preco) {
        super(codigo, nome, precoBase, quantidadeEstoque);  
        this.tempoPreparoMinutos = tempoPreparoMinutos;
        this.vegano = vegano;
    }

    public String gettempoPreparoMinutos() {
        return tempoPreparoMinutos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}