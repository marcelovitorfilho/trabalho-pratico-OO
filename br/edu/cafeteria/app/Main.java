package br.edu.cafeteria.app;

import br.edu.cafeteria.modelo.*;
import br.edu.cafeteria.servico.*;
import br.edu.cafeteria.excecao.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        CadastroProdutos cardapio = new CadastroProdutos();

        Comida LembasBread = new Comida("C001", "Lembas Bread", 12.00, 10, 30, false, false);
        Comida PortalCake = new Comida("C002", "Portal Cake", 12.00, 10, 45, true, false);
        Comida AneisdoPoder = new Comida("C003", "Anéis de Queijo do Poder", 15.00, 10, 35, false, false);
        Bebida cafeDoProgramador = new Bebida("B001", "Café do Programador", 5.00, 10, "P", 150);
        Bebida pocaoDeMana = new Bebida("B002", "Poção de Mana", 9.00, 10, "M", 0);
        Bebida chaDoMago = new Bebida("B003", "Chá mágico do Mago Supremo", 13.00, 10, "G", 0);

        ClienteStandard Bruno = new ClienteStandard("Bruno Vieira", "111.111.222-33", 10);
        ClienteStandard Bernardo = new ClienteStandard("Bernardo Galvão", "402.888.745-00", 20);
        ClienteStandard Lucas = new ClienteStandard("Lucas Renato", "222.222.444-66", 30);
        ClienteVip Marcelo = new ClienteVip("Marcelo Vitor", "333.444.555-66", 350);
        ClienteVip Thiago = new ClienteVip("Thiago Sousa", "444.555.666-77", 400);

        cadastro.cadastrarCliente(Bruno);
        cadastro.cadastrarCliente(Bernardo);
        cadastro.cadastrarCliente(Lucas);
        cadastro.cadastrarCliente(Marcelo);
        cadastro.cadastrarCliente(Thiago);

        Atendente profissional1 = new Atendente("André", 01);
        Atendente profissional2 = new Atendente("Cristina", 02);

        Pedido pedido1 = new Pedido(001, profissional1, Bruno);
        Pedido pedido2 = new Pedido(002, profissional2, Marcelo);

        System.out.println("Bem-vindo à Cafeteria Geek Byte & Brew!");
        System.out.println("Se já é cliente, coloque seu CPF para acessar o cardápio e fazer seu pedido. Caso contrário, cadastre-se como cliente.");
        System.out.println("Digite 1 caso já tenha cadastro\nDigite 2 para se cadastrar como cliente\nDigite 3 para fazer compra sem cadastro");
        opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1:
                System.out.println("Digite seu CPF:");
                String cpf = scanner.nextLine();
                Cliente cliente = cadastroClientes.buscarClientePorCpf(cpf);
                if (cliente != null) {
                    System.out.println("Bem-vindo, " + cliente.getNome() + "! Aqui está o nosso cardápio:");
                } else {
                    System.out.println("CPF não encontrado. Por favor, cadastre-se como cliente.");
                }
                break;
            case 2:
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                System.out.println("Digite seu CPF:");
                String novoCpf = scanner.nextLine();
                System.out.println("Você está cadastrado, você é nosso mais novo cliente Standard. Bem-vindo, " + nome + "! Aqui está o nosso cardápio:");
                break;
            case 3:
                System.out.println("Você optou por fazer uma compra sem cadastro. Aqui está o nosso cardápio:");
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }


        System.out.println("1. Lembas Bread - R$12,00");
        System.out.println("2. Portal Cake - R$12,00");
        System.out.println("3. Anéis de Queijo do Poder - R$15,00");
        System.out.println("4. Café do Programador - R$5,00");
        System.out.println("5. Poção de Mana - R$9,00");
        System.out.println("6. Chá mágico do Mago Supremo - R$13,00");
        System.out.println("7. Finalizar pedido");
        System.out.println("Digite o número da opção desejada:");
        switch (opcao) {
            case 1:
                pedido1.adicionarItem(LembasBread, 1);
            case 2:
                pedido2.adicionarItem(PortalCake, 1);
            case 3:
                pedido1.adicionarItem(AneisdoPoder, 1);
            case 4:
                pedido2.adicionarItem(cafeDoProgramador, 1);
            case 5:
                pedido1.adicionarItem(pocaoDeMana, 1);
            case 6:
                pedido2.adicionarItem(chaDoMago, 1);
            case 7:
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida do cardápio.");
            }

         scanner.close();
    }
}