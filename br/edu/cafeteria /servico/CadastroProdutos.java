package br.edu.cafeteria.servico;

import java.util.ArrayList;
import br.edu.cafeteria.modelo.Produto;

public class CadastroProdutos {
    private ArrayList<Produto> produtos;

    public CadastroProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {

        for (Produto p : produtos) {

            if (p.getCodigo().equals(produto.getCodigo())) {
                throw new IllegalArgumentException("Já existe um produto com esse código.");
                }
            }

        produtos.add(produto);
    }
}
