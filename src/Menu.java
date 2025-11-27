package ToolsShop;

import java.util.Scanner;

import ToolsShop.conector.Cadastro;
import ToolsShop.conector.Listagem;
import ToolsShop.conector.Atualizar;
import ToolsShop.conector.Deletar;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    private final Cadastro cadastro = new Cadastro();
    private final Listagem listagem = new Listagem();
    private final Atualizar atualizar = new Atualizar();
    private final Deletar deletar = new Deletar();

    public void iniciar() {

        int op;
        do {
            System.out.print("""
                    
                    ===== LOJA DE FERRAMENTAS =====
                    1 - Cadastrar
                    2 - Listar
                    3 - Atualizar
                    4 - Deletar
                    0 - Sair
                    Escolha: """);
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> menuCadastro();
                case 2 -> menuListar();
                case 3 -> menuAtualizar();
                case 4 -> menuDeletar();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (op != 0);
    }

    // ================= SUBMENUS ====================

    private void menuCadastro() {
        int op;
        System.out.print("""
                
                --- CADASTRAR ---
                1 - Cliente
                2 - Ferramenta
                3 - Movimentação (venda/ordem)
                4 - Estoque
                0 - Voltar
                Escolha: """);
        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> cadastrarCliente();
            case 2 -> cadastrarFerramenta();
            case 3 -> cadastrarPedido();
            case 4 -> cadastrarEstoque();
            case 0 -> {}
            default -> System.out.println("Opção inválida!");
        }
    }

    private void menuListar() {
        int op;
        System.out.print("""
                
                --- LISTAR ---
                1 - Clientes
                2 - Ferramentas
                3 - Movimentações
                4 - Estoque
                0 - Voltar
                Escolha: """);
        op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> listagem.cliente();
            case 2 -> listagem.produto();
            case 3 -> listagem.pedido();
            case 4 -> listagem.itemPedido();
            case 0 -> {}
            default -> System.out.println("Opção inválida!");
        }
    }

    private void menuAtualizar() {
        System.out.print("""
                
                --- ATUALIZAR ---
                Tabela: """);
        String tabela = sc.nextLine();

        System.out.print("Campo: ");
        String campo = sc.nextLine();

        System.out.print("Novo valor: ");
        String valor = sc.nextLine();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        atualizar.tabela(tabela, campo, valor, id);
        System.out.println("Atualizado!");
    }

    private void menuDeletar() {
        System.out.print("""
                
                --- DELETAR ---
                Tabela: """);
        String tabela = sc.nextLine();

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        deletar.dados(tabela, id);
        System.out.println("Registro apagado!");
    }

    // ================== FUNÇÕES DE CADASTRO =====================

    private void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String tel = sc.nextLine();

        System.out.print("Endereço: ");
        String end = sc.nextLine();

        Cliente cliente = new Cliente(nome, tel, end);   // ainda representa o cliente
        cliente.cadastrarCliente();
    }

    private void cadastrarFerramenta() {
        System.out.print("Nome da ferramenta: ");
        String nome_produto = sc.nextLine();

        System.out.print("Categoria (ex.: elétrica, manual): ");
        float preco = Float.parseFloat(sc.nextLine());

        System.out.print("Marca: ");
        int estoque = Integer.parseInt(sc.nextLine());

        System.out.print("Tipo de uso (profissional, hobby, pesado, leve): ");
        String tipo = sc.nextLine();

        // usando o método novo da classe Cadastro
        cadastro.produto(nome_produto, preco, estoque, tipo);
        System.out.println("Ferramenta cadastrada!");
    }

    private void cadastrarPedido() {
        System.out.print("Id do Cliente:");
        int id_cliente = Integer.parseInt(sc.nextLine());

        System.out.print("Data do pedido(dd/mes/ano)");
        String data_pedido = sc.nextLine();

        System.out.print("ID da ferramenta: ");
        int fk_produto = sc.nextInt();
        sc.nextLine();

        // Para vincular a um cliente, você pode pedir aqui o ID do cliente
        System.out.print("ID do cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();

        // supondo que você acrescente fk_cliente na tabela movimentacoes,
        // pode criar outro método em Cadastro ou ajustar o existente.
        cadastro.pedido(id_cliente, data_pedido, fk_produto);
        System.out.println("pedido registrado!");
    }

    private void cadastrarEstoque() {
        System.out.print("Pedido: ");
        int id_pedido = Integer.parseInt(sc.nextLine());

        System.out.print("Produto/Ferramenta: ");
        int id_produto = Integer.parseInt(sc.nextLine());

        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        System.out.print("preco_unitario: ");
        int preco_unitario = sc.nextInt();
        sc.nextLine();

        cadastro.item_pedido(id_pedido, id_produto, quantidade, preco_unitario);
        System.out.println("Produto adicionado ao estoque!");
    }
}
