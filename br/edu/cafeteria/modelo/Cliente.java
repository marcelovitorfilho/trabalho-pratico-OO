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

    public void adicionarXP(int pontos) {
        this.saldoXP += pontos;
    }

    public void calcularEAdicionarXP(double valorCompra) {
        int pontos = calcularPontosXP(valorCompra);
        adicionarXP(pontos);
    }

    public void pagarComXp(double valorCompra) throws PontosInsuficientesException {
        int pontosNecessarios = (int) Math.ceil(valorCompra * 10);

        if (saldoXP < pontosNecessarios) {
            throw new PontosInsuficientesException("XP insuficiente para pagar o pedido.");
        }

        saldoXP -= pontosNecessarios;
    }
}
