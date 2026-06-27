package br.edu.cafeteria.servico;

import java.util.ArrayList;

import br.edu.cafeteria.modelo.Cliente;

public class CadastroClientes{
    private ArrayList<Cliente> clientes;

    public CadastroClientes() {
        this.clientes = new ArrayList<>();
    }
    //CREATE//
    public void cadastrarCliente(Cliente cliente) {
        if (buscarClientePorCpf(cliente.getCpf()) != null) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com esse CPF.");
        }

        clientes.add(cliente);
    }
    //READ//
    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
        }

        return null;
    }
    //DELETE//
    public void removerClientePorCpf(String cpf) {
        Cliente cliente = buscarClientePorCpf(cpf);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        clientes.remove(cliente);
        }
    }
    //UPDATE//
    public void atualizarCliente(String cpf, Cliente clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.set(i, clienteAtualizado);
                return;
            }
        }

        throw new IllegalArgumentException("Cliente não encontrado.");
    }
}