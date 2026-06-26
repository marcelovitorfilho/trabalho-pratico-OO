package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente {
    
    public ClienteStandard(String nome, String cpf, String email) {
        super(nome, email);
    }

    @Override
    public double calcularPotosXPontos(double valorTotal) {
        return valorTotal * DESCONTO;
    }
}