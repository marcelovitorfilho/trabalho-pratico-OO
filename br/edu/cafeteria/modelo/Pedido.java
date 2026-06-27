package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.excecao.PontosInsuficientesException;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //============================================
    // SISTEMA DE VENDAS - Pedido
    // ===========================================

    private static int proximoNumero = 1000; // gerador sequencial automatico exigido

    private int numeroIdentificacao;
    private String atendente;
    private Cliente cliente; // pode ser Casual, Standard ou VIP
    private List<ItemPedido> itens;
    private double descontoManual;

    public Pedido(String atendente, Cliente cliente) {
        this.numeroIdentificacao = proximoNumero;
        proximoNumero++;

        this.atendente = atendente;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.descontoManual = 0.0;
    }

    public void adicionarProduto(Produto produto) throws EstoqueInsuficienteException { // sobrecarga
        adicionarProduto(produto, 1);
    }

    public void adicionarProduto(Produto produto, int quantidade) throws EstoqueInsuficienteException {
        if (produto.getQuantidadeEstoque() < quantidade) {
            throw new EstoqueInsuficienteException("Estoque insuficiente para " + produto.getNome());
        }

        itens.add(new ItemPedido(produto, quantidade));
    }

    public double calcularValorTotal() {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }

        return Math.max(0.0, total - descontoManual);
    }

    public void finalizarPedido(boolean usarXpComoPagamento)
            throws EstoqueInsuficienteException, PontosInsuficientesException {

        double valorFinal = calcularValorTotal();

        if (usarXpComoPagamento) {
            if (cliente == null) {
                throw new PontosInsuficientesException("Clientes casuais nao podem usar o beneficio de XP.");
            }

            cliente.pagarComXp(valorFinal);
        }

        for (ItemPedido item : itens) {
            item.getProduto().baixarEstoque(item.getQtd());
        }

        if (!usarXpComoPagamento && cliente != null) {
            cliente.calcularEAdicionarXP(valorFinal);
        }
    }

    public void aplicarDescontoManual(double valor) {
        this.descontoManual = valor;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }

    public int getNumeroIdentificacao() {
        return this.numeroIdentificacao;
    }

    public String getAtendente() {
        return this.atendente;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
}