package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;

public class Produto {
    private String codigo;
    private String nome;
    private double precoBase;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, double precoBase, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void baixarEstoque(int quantidade) throws EstoqueInsuficienteException{
        if (this.quantidadeEstoque < quantidade){
            throw new EstoqueInsuficienteException("Estoque se encontra insuficiente para: " + nome);
        }

        this.quantidadeEstoque -= quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}