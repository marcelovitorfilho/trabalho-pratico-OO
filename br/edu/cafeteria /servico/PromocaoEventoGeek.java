package br.edu.cafeteria.servico;
import br.edu.cafeteria.modelo.*;

public class PromocaoEventoGeek implements Promocional{
    double calcularDesconto(Pedido pedido){
        @Override
        public double calcularDesconto(Pedido pedido) {
            double desconto = 0.0;

            for (ItemPedido item : pedido.getItens()) {
                if (item.getProduto() instanceof Bebida) {
                    desconto += item.getSubtotal() * 0.10;
                }
            }

            return desconto;
        }
    }
}