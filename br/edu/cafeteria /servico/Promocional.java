package br.edu.cafeteria.servico;

import br.edu.cafeteria.Pedido;

public interface Promocional{
    double calcularDesconto(Pedido pedido);
}