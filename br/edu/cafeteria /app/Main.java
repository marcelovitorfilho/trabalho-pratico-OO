package br.edu.cafeteria.app;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.excecao.PontosInsuficientesException;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    //============================================
    // SISTEMA DE VENDAS - Cliente casual 
    // ===========================================
    
    private static int NumeroIdentificacao = 1000; // gerador sequencial automatico exigido
    private String atendente;
    private Cliente cliente; // pode ser Casual, Standard ou VIP
    private List<itemPedido> itens = new ArrayList<itemPedido>();
    private double descontoManual;

    public Pedido(int numeroIdentificacao, String atendente , Cliente cliente){
        this.NumeroIdentificacao = numeroIdentificacao;
        this.atendente = atendente;
        this.cliente = cliente;

    }
    public void adicionarProduto(Produto p) throws EstoqueInsuficienteException{ // sobrecarga
        adicionarProduto(p, 1);
        }
    public void adicionarProduto(Produto p, int quantidade) throws EstoqueInsuficienteException {
        if(p.getQuantidadeestoque() < quantidade){
            throw new EstoqueInsuficienteException("EStoque insuficiente para " + p.getNome());
        }
        itens.add(new itemPedido(p,quantidade));
    }
        public double calcularValorTotal(){
            double total = 0.0;
            for (itemPedido item : itens){
                total += itemPedido.getSubtotal();
            }
            return Math.max(0.0, total - descontoManual);
        }
        public void finalizarPedido(boolean UsarXpComoPagamento) throws EstoqueInsuficienteException, PontosInsuficientesException{
            double valorFinal = calcularValorFinal();

            if (UsarXpComoPagamento){
                if (cliente != null){
                    cliente.pagarComXp(valorFinal);
                }else{
                    throw new PontosInsuficientesException("Clientes casuais nao podem usar o beneficio de XP ");
                }
            }
            for (itemPedido item : itens) {
                item.getProduto().baixarEstoque(item.getQuantidade());
        }
    if (!usarXpComoPagamento && cliente != null) {
            cliente.calcularEAdicionarXP(valorFinal);
        }
    }
    public void aplicarDescontoManual(double valor) {
        this.descontoManual = valor;
    }
    public List<ItemPedido> getItens(){ 
        return this.itens; 
    }
    public int getNumeroIdentificacao(){ 
        return this.numeroIdentificacao; 
    }
        }
    


    