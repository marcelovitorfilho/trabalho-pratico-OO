package br.edu.cafeteria.modelo;

public class ItemPedido {
    private final Produto produto;
    private int qtd;

    public ItemPedido(Produto produto, int qtd) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }

        if (qtd <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que 0.");
        }

        this.produto = produto;
        this.qtd = qtd;
    }

    public double getSubtotal() {
        return produto.getPrecoBase() * qtd;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior do que 0.");
        }

        this.qtd = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    @Override
    public String toString() {
        return String.format("%s x %d | Subtotal: R$ %.2f", produto.getNome(), qtd, getSubtotal());
    }
}