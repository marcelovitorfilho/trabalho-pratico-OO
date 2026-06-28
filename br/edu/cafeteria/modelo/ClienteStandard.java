package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente {
    
    public ClienteStandard(String nome, String cpf, int saldoXP) {
        super(nome, cpf, saldoXP);
    }

    @Override
    public int calcularPontosXP(double valorCompra) {
        return (int) valorCompra; // 1 ponto para cada R$1,00 gasto
    }
    public void pagar(double valorCompra) {
        int pontosGanhos = calcularPontosXP(valorCompra);
        this.saldoXP += pontosGanhos;
    }
    
    
}