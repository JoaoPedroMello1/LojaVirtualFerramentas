package ToolsShop.conector;

import java.sql.SQLException;

// Classe para deletar o conteúdo das tabelas linha a linha
public class Deletar extends Conexao {

    // tabela deve ser validada antes de chamar (cliente, produto, pedido, item_pedido)
    public void dados(String tabela, int id) {
        try {
            conectar();

            String sql = "DELETE FROM " + tabela + " WHERE id = ?";
            pStatement = conn.prepareStatement(sql);
            pStatement.setInt(1, id);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }
}
