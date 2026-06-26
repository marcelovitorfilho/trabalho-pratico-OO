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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public String getsaldoXP() {
        return saldoXP;
    }

    public void setsaldoXP(String saldoXP) {
        this.saldoXP = saldoXP;
    }
    public int calcularPontosXP(double valorCompra) {
        return 0; 
    }
}
