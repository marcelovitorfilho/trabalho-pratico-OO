package br.edu.cafeteria.modelo;

public class comida extends Produto {
    private String tempoPreparoMinutos;
    private booleaneco;

    public comida(String codigo, String nome, double precoBase, int quantidadeEstoque, String tempoPreparoMinutos, double preco) {
        this.tempoPreparoMinutos = tempoPreparoMinutos;
        this.preco = preco;
    }

    public String gettempoPreparoMinutos() {
        return tempoPreparoMinutos;
    }

    public void settempoPreparoMinutos(String tempoPreparoMinutos) {
        this.tempoPreparoMinutos = tempoPreparoMinutos;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}