package br.edu.cafeteria.modelo;

public class Atendente {
    private String nome;
    private String registroFuncionario;

    public Atendente(String nome, String registroFuncionario) {
        this.nome = nome;
        this.registroFuncionario = registroFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getRegistroFuncionario() {
        return registroFuncionario;
    }
}