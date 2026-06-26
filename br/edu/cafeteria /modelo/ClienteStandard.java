package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente {
    
    public ClienteStandard(String nome, String cpf, String saldoXP) {
        super(nome, cpf, saldoXP);
    }

    @Override
    public int calcularPontosXP(double valorCompra) {
        return valorTotal * DESCONTO;
    }
}