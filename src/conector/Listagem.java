package ToolsShop.conector;

import java.sql.SQLException;

// Classe que faz a listagem dos conteúdos nas tabelas
public class Listagem extends Conexao {

    // Lista o conteúdo da tabela cliente
    public void cliente() {
        try {
            conectar();
            pStatement = conn.prepareStatement(
                    "SELECT id, nome, email, telefone FROM cliente"
            );
            resultSet = pStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Id: " + resultSet.getInt("id") +
                                ", Nome: " + resultSet.getString("nome") +
                                ", Email: " + resultSet.getString("email") +
                                ", Telefone: " + resultSet.getString("telefone")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    // Lista o conteúdo da tabela produto
    public void produto() {
        try {
            conectar();
            pStatement = conn.prepareStatement(
                    "SELECT id, nome, preco, estoque, tipo FROM produto"
            );
            resultSet = pStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Id: " + resultSet.getInt("id") +
                                ", Nome: " + resultSet.getString("nome") +
                                ", Preço: " + resultSet.getBigDecimal("preco") +
                                ", Estoque: " + resultSet.getInt("estoque") +
                                ", Tipo: " + resultSet.getString("tipo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    // Lista pedidos com dados do cliente
    public void pedido() {
        try {
            conectar();
            pStatement = conn.prepareStatement(
                    "SELECT p.id, p.data_pedido, c.nome AS cliente, c.telefone " +
                            "FROM pedido p " +
                            "INNER JOIN cliente c ON p.id_cliente = c.id"
            );
            resultSet = pStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Pedido: " + resultSet.getInt("id") +
                                ", Data: " + resultSet.getTimestamp("data_pedido") +
                                ", Cliente: " + resultSet.getString("cliente") +
                                ", Telefone: " + resultSet.getString("telefone")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    // Lista itens de pedido com dados do pedido e do produto
    public void itemPedido() {
        try {
            conectar();
            pStatement = conn.prepareStatement(
                    "SELECT ip.id, ip.id_pedido, ip.quantidade, ip.preco_unitario, " +
                            "       p.nome AS produto, ped.data_pedido, c.nome AS cliente " +
                            "FROM item_pedido ip " +
                            "INNER JOIN produto p ON ip.id_produto = p.id " +
                            "INNER JOIN pedido ped ON ip.id_pedido = ped.id " +
                            "INNER JOIN cliente c ON ped.id_cliente = c.id"
            );
            resultSet = pStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(
                        "Item: " + resultSet.getInt("id") +
                                ", Pedido: " + resultSet.getInt("id_pedido") +
                                ", Produto: " + resultSet.getString("produto") +
                                ", Quantidade: " + resultSet.getInt("quantidade") +
                                ", Preço Unitário: " + resultSet.getBigDecimal("preco_unitario") +
                                ", Cliente: " + resultSet.getString("cliente") +
                                ", Data Pedido: " + resultSet.getTimestamp("data_pedido")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }
}
