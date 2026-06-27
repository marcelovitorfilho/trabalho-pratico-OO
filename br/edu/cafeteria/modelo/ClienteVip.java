package br.edu.cafeteria.modelo;

public class ClienteVip extends Cliente {
    
    public ClienteVip(String nome, String cpf, int saldoXP) {
        super(nome, cpf, saldoXP);
        
    }

    @Override
    public int calcularPontosXP(double valorCompra) {
        return (int) (valorCompra * 2); // Clientes VIP ganham o dobro de pontos XP
    }

   

}