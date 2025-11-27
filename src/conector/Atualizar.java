package ToolsShop.conector;

import java.sql.SQLException;

// Metodo para atualizar o conteudo nas tabelas linha a linha
public class Atualizar extends Conexao {

    public void tabela(String tabela, String campo, String valor, int id) {
        try {
            conectar();

            // ATENÇÃO:
            // tabela e campo ainda vêm de String livre (entrada do usuario),
            // então é importante validar antes de chamar este método
            // (ex.: permitir apenas: cliente, produto, pedido, item_pedido
            // e campos existentes em cada uma delas).
            String sql = "UPDATE " + tabela + " SET " + campo + " = ? WHERE id = ?";
            pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, valor);
            pStatement.setInt(2, id);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }
}
