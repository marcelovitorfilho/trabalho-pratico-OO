package br.edu.cafeteria.servico;

import java.util.ArrayList;

import br.edu.cafeteria.modelo.Cliente;

public class CadastroClientes{
    private ArrayList<Cliente> clientes;

    public CadastroClientes() {
        this.clientes = new ArrayList<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        if (buscarClientePorCpf(cliente.getCpf()) != null) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com esse CPF.");
        }

        clientes.add(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
        }
    }

    public void removerClientePorCpf(String cpf) {
        Cliente cliente = buscarClientePorCpf(cpf);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        clientes.remove(cliente);
        }
        
        return null;
    }
}