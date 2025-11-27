package ToolsShop.conector;
import java.sql.SQLException;

// Classe responsavel por efetuar os cadastros no banco de dados
public class Cadastro extends Conexao{

    // dados cliente
    private String nome_cliente;
    private String email;
    private String telefone;

    // dados produto
    private String nome_produto;
    private float preco;
    private int estoque;
    private String tipo;

    // dados pedido
    private int id_cliente;
    private String data_pedido;

    // dados item_pedido
    private int id_pedido;
    private int id_produto;
    private int quantidade;
    private float preco_unitario;



    // Metodo responsavel pelo cadastro do cliente
    public void cliente(String nome_cliente, String telefone, String email){

        this.nome_cliente = nome_cliente;
        this.telefone = telefone;
        this. email = email;

        try {
            conectar();

            pStatement = conn.prepareStatement("insert into clientes (nome, telefone, endereco) values (?, ?, ?)");
            pStatement.setString(1, nome_cliente);
            pStatement.setString(2, telefone);
            pStatement.setString(3, email);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // Metodo responsavel pelo cadastro do animal
    public void produto(String nome_produto , float preco, int estoque, String tipo){

        this.nome_produto = nome_produto;
        this.preco = preco;
        this.estoque = estoque;
        this.tipo = tipo;

        try {
            conectar();

            pStatement = conn.prepareStatement("insert into produto (nome, preco, estoque, tipo, fk_cliente) values (?, ?, ?, ?, ?)");
            pStatement.setString(1, nome_produto);
            pStatement.setFloat(2, preco);
            pStatement.setInt(3, estoque);
            pStatement.setString(4, tipo);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // Metodo que faz o pedido
    public void pedido(int id_cliente, String data_pedido, int fk_produto){

        this.id_cliente = id_cliente;
        this.data_pedido = data_pedido;

        try{
            conectar();

            pStatement = conn.prepareStatement("insert into pedido (id_cliente, data_pedido, fk_produto) values (?, ?, ?)");
            pStatement.setInt(1, id_cliente);
            pStatement.setString(2, data_pedido);
            pStatement.setInt(3, fk_produto);
            pStatement.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Metodo para cadastrar os produtos no estoque
    public void item_pedido(int id_pedido, int id_produto, int quantidade, float preco_unitario){

        this.id_pedido = id_pedido;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;

        try {
            conectar();

            pStatement = conn.prepareStatement("insert into item_pedido (id_pedido, id_produto, quantidade, preco_unitario) values (? , ?, ?, ?)");
            pStatement.setInt(1, id_pedido);
            pStatement.setInt(2, id_produto);
            pStatement.setInt(3, quantidade);
            pStatement.setFloat(4, preco_unitario);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
