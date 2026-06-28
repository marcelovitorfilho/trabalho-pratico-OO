package br.edu.cafeteria.modelo;

public class ClienteVip extends Cliente {

    public ClienteVip(String nome, String cpf, int saldoXP) {
        super(nome, cpf, saldoXP);
    }

    @Override
    public int calcularPontosXP(double valorCompra) { //polifomrismo por sobreescrita
        return (int) (valorCompra * 2); // Clientes VIP ganham o dobro de pontos XP
    }
    public void pagarComXp(double valorCompra) throws PontosInsuficientesException {
        int pontosNecessarios = (int) Math.ceil(valorCompra * 10);

        if (saldoXP < pontosNecessarios) {
            throw new PontosInsuficientesException("XP insuficiente para pagar o pedido.");
        }

        debitarXP(pontosNecessarios);
    }
}