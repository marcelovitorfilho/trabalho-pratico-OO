package br.edu.cafeteria.modelo;

public class Atendente {
    private String nome;
    private String registro_de_funcionario;

    public Atendente(String nome, String cpf) {
    this.nome = nome;
    this.registro_de_funcionario = registro_de_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public String getRegistro_de_funcionario() {
        return registro_de_funcionario;
    }
}