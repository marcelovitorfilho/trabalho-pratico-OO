package br.edu.cafeteria.modelo;

public class Atendente {
    private String nome;
    private int registroFuncionario;

    public Atendente(String nome, int registroFuncionario) {
        this.nome = nome;
        this.registroFuncionario = registroFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public int getRegistroFuncionario() {
        return registroFuncionario;
    }
}