package br.edu.cafeteria.app;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.excecao.PontosInsuficientesException;
import java.util.ArrayList;
import java.util.List;

public class Main {
public static void main(String[] args){

CadastroProdutos cardapio = new CadastroProdutos();

Comida LembasBread = new Comida("C001", "Lembas Bread", 12.00, 10, 30, false, false);
Comida PortalCake = new Comida("C002", "Portal Cake", 12.00, 10, 45, true, false);
Comida AneisdoPoder = new Comida("C003", "Anéis de Queijo do Poder", 15.00, 10, 35, false, false);
Bebida cafeDoProgramador = new Bebida("B001", "Café do Programador", 5.00, 10, "P", 150);
Bebida pocaoDeMana = new Bebida("B002", "Poção de Mana", 9.00, 10, "M", 0);
Bebida chaDoMago = new Bebida("B003", "Chá mágico do Mago Supremo", 13.00, 10, "G", 0);

ClienteStandard Bruno = new ClienteStandard("Bruno Vieira", "111.111.222-33", "150");
ClienteStandard Bernardo = new ClienteStandard("Bernardo Galvão", "402.888.745-00");
ClienteStandard Lucas = new ClienteStandard("Lucas Renato", "222.222.444-66", "115");
ClienteVip Marcelo = new.ClienteVip("Marcelo Vitor", "333.444.555-66", "350");
ClienteVip Thiago = new.ClienteVip("Thiago Sousa", "444.555.666-77");

Atendente profissional1 = new Atendente("André", 01);
Atendente profissional2 = new Atendente("Cristina", 02);

}
}