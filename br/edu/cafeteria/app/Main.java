package br.edu.cafeteria.app;

import br.edu.cafeteria.modelo.*;
import br.edu.cafeteria.servico.*;
import br.edu.cafeteria.excecao.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CadastroProdutos cardapio = new CadastroProdutos();
        CadastroClientes cadastroClientes = new CadastroClientes();

        Comida lembasBread = new Comida("C001", "Lembas Bread", 12.00, 10, 30, false, false);
        Comida portalCake = new Comida("C002", "Portal Cake", 12.00, 10, 45, true, false);
        Comida aneisDoPoder = new Comida("C003", "Anéis de Queijo do Poder", 15.00, 10, 35, false, false);

        Bebida cafeDoProgramador = new Bebida("B001", "Café do Programador", 5.00, 10, "P", 150);
        Bebida pocaoDeMana = new Bebida("B002", "Poção de Mana", 9.00, 10, "M", 0);
        Bebida chaDoMago = new Bebida("B003", "Chá mágico do Mago Supremo", 13.00, 10, "G", 0);

        cardapio.cadastrarProduto(lembasBread);
        cardapio.cadastrarProduto(portalCake);
        cardapio.cadastrarProduto(aneisDoPoder);
        cardapio.cadastrarProduto(cafeDoProgramador);
        cardapio.cadastrarProduto(pocaoDeMana);
        cardapio.cadastrarProduto(chaDoMago);

        ClienteStandard bruno = new ClienteStandard("Bruno Vieira", "111.111.222-33", 10);
        ClienteStandard bernardo = new ClienteStandard("Bernardo Galvão", "402.888.745-00", 20);
        ClienteStandard lucas = new ClienteStandard("Lucas Renato", "222.222.444-66", 30);
        ClienteVip marcelo = new ClienteVip("Marcelo Vitor", "333.444.555-66", 350);
        ClienteVip thiago = new ClienteVip("Thiago Sousa", "444.555.666-77", 400);

        cadastroClientes.cadastrarCliente(bruno);
        cadastroClientes.cadastrarCliente(bernardo);
        cadastroClientes.cadastrarCliente(lucas);
        cadastroClientes.cadastrarCliente(marcelo);
        cadastroClientes.cadastrarCliente(thiago);

        Atendente profissional1 = new Atendente("André", "001");

        Cliente clientePedido = null;

        System.out.println("Bem-vindo à Cafeteria Geek Byte & Brew!");
        System.out.println("Digite 1 caso já tenha cadastro");
        System.out.println("Digite 2 para se cadastrar como cliente");
        System.out.println("Digite 3 para fazer compra sem cadastro");
        System.out.println("Digite a opção desejada:");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Digite seu CPF:");
                String cpf = scanner.nextLine();

                clientePedido = cadastroClientes.buscarClientePorCpf(cpf);

                if (clientePedido != null) {
                    System.out.println("Bem-vindo, " + clientePedido.getNome() + "!");
                } else {
                    System.out.println("CPF não encontrado. A compra será feita sem cadastro.");
                }

                break;

            case 2:
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();

                System.out.println("Digite seu CPF:");
                String novoCpf = scanner.nextLine();

                clientePedido = new ClienteStandard(nome, novoCpf, 0);
                cadastroClientes.cadastrarCliente(clientePedido);

                System.out.println("Você está cadastrado como cliente Standard. Bem-vindo, " + nome + "!");
                break;

            case 3:
                System.out.println("Você optou por fazer uma compra sem cadastro.");
                break;

            default:
                System.out.println("Opção inválida. Encerrando o sistema.");
                scanner.close();
                return;
        }

        Pedido pedido = new Pedido(profissional1.getNome(), clientePedido);

        boolean continuarComprando = true;

        while (continuarComprando) {
            System.out.println();
            System.out.println("Aqui está o nosso cardápio:");
            System.out.println("1. Lembas Bread - R$12,00");
            System.out.println("2. Portal Cake - R$12,00");
            System.out.println("3. Anéis de Queijo do Poder - R$15,00");
            System.out.println("4. Café do Programador - R$5,00");
            System.out.println("5. Poção de Mana - R$9,00");
            System.out.println("6. Chá mágico do Mago Supremo - R$13,00");
            System.out.println("7. Finalizar pedido");
            System.out.println("Digite o número da opção desejada:");

            int opcaoProduto = scanner.nextInt();
            scanner.nextLine();

            Produto produtoEscolhido = null;

            switch (opcaoProduto) {
                case 1:
                    produtoEscolhido = lembasBread;
                    break;

                case 2:
                    produtoEscolhido = portalCake;
                    break;

                case 3:
                    produtoEscolhido = aneisDoPoder;
                    break;

                case 4:
                    produtoEscolhido = cafeDoProgramador;
                    break;

                case 5:
                    produtoEscolhido = pocaoDeMana;
                    break;

                case 6:
                    produtoEscolhido = chaDoMago;
                    break;

                case 7:
                    continuarComprando = false;
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida do cardápio.");
                    break;
            }
                                                   
            if (produtoEscolhido != null) {
                System.out.println("Digite a quantidade:");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                try {
                    pedido.adicionarProduto(produtoEscolhido, quantidade);
                    System.out.println("Produto adicionado ao pedido.");
                } catch (EstoqueInsuficienteException | IllegalArgumentException erro) {
                    System.out.println("Erro ao adicionar produto: " + erro.getMessage());
                }
            }
        }

        if (pedido.getItens().isEmpty()) {
            System.out.println("Nenhum produto foi adicionado. Pedido encerrado.");
            scanner.close();
            return;
        }

        System.out.println();
        System.out.println("Hoje é Dia de Evento Geek?");
        System.out.println("Digite 1 para sim");
        System.out.println("Digite 2 para não");

        int opcaoPromocao = scanner.nextInt();
        scanner.nextLine();

        if (opcaoPromocao == 1) {
            Promocional promocao = new PromocaoEventoGeek();
            double desconto = promocao.calcularDesconto(pedido);
            pedido.aplicarDescontoManual(desconto);

            System.out.printf("Desconto aplicado: R$ %.2f%n", desconto);
        }

        System.out.printf("Total do pedido: R$ %.2f%n", pedido.calcularValorTotal());

        boolean usarXpComoPagamento = false;

        if (clientePedido instanceof ClienteVip) {
            System.out.println("Deseja pagar o pedido com XP?");
            System.out.println("Digite 1 para sim");
            System.out.println("Digite 2 para não");

            int opcaoXp = scanner.nextInt();
            scanner.nextLine();

            usarXpComoPagamento = opcaoXp == 1;
        }

        try {
            pedido.finalizarPedido(usarXpComoPagamento);

            System.out.println("Pedido finalizado com sucesso!");
            System.out.println("Número do pedido: " + pedido.getNumeroIdentificacao());

            if (clientePedido != null) {
                System.out.println("Saldo XP atual: " + clientePedido.getSaldoXP());
            }
        } catch (EstoqueInsuficienteException | PontosInsuficientesException erro) {
            System.out.println("Erro ao finalizar pedido: " + erro.getMessage());
        }

        scanner.close();
    }
}
```
