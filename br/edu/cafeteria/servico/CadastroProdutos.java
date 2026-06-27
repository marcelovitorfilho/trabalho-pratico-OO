package br.edu.cafeteria.servico;

import java.util.ArrayList;
import br.edu.cafeteria.modelo.Produto;

public class CadastroProdutos {
    private ArrayList<Produto> produtos;

    public CadastroProdutos() {
        this.produtos = new ArrayList<>();
    }
    //CREATE//
    public void cadastrarProduto(Produto produto) {
        if (buscarProdutoPorCodigo(produto.getCodigo()) != null) {
            throw new IllegalArgumentException("Já existe um produto cadastrado com esse código.");
        }

        produtos.add(produto);
    }
    //READ//
    public Produto buscarProdutoPorCodigo(String codigo){
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }
    //DELETE//
    public void removerProdutoPorCodigo(String codigo){
        Produto produto = buscarProdutoPorCodigo(codigo);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        produtos.remove(produto);
    }

    //UPDATE//
    public void atualizarProduto(String codigo, Produto produtoAtualizado){
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equals(codigo)) {
                produtos.set(i, produtoAtualizado);
                return;
            }
        }

        throw new IllegalArgumentException("Produto não encontrado.");
    }
}