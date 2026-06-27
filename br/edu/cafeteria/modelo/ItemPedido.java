package br.edu.cafeteria.modelo;

public class itemPedido {
    private final Produto produto;
    private int qtd; // quantidade de itens pedidos pelo cliente

    public ItemPedido(Produto produto, int qtd){
        
        if(produto == null){
            throw new IllegalArgumentException("O produto não pode ser igual a 0");
        }
        if (qtd <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que 0");
        }

        this.produto = produto;
        this.qtd = qtd;
    }

    public double getSubtotal() {
        return produto.getPrecoBase() * qtd;
    }

    public void setQuantidade(int quantidade){
        if(qtd <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior do que 0.");
        }
        this.qtd = qtd;
    }

    public Produto getProduto(){
        return produto;
    }

    public int getQtd(){
        return qtd;
    }

    @Override // redefinindo um método que ja existe em uma classe mãe
    public String toString(){
        return String.format("%s x %d | Subtotal: R$ %.2f", produto.getNome(), qtd, getSubtotal());
    }
}