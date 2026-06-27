package br.edu.cafeteria.modelo;
public class Cliente {
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

    public int calcularPontosXP(double valorCompra) {
        return 0; 
    }
}
