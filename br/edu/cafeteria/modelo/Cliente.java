package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.PontosInsuficientesException;

public abstract class Cliente {
    private String nome;
    private String cpf;
    private int saldoXP;

    public Cliente(String nome, String cpf, int saldoXP) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldoXP = saldoXP;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getSaldoXP() {
        return saldoXP;
    }

    public abstract int calcularPontosXP(double valorCompra)
        
        
    public void adicionarXP(int pontos) {
        this.saldoXP += pontos;
    }

    public void calcularEAdicionarXP(double valorCompra) {
        int pontos = calcularPontosXP(valorCompra);
        adicionarXP(pontos);
    }

    

}
