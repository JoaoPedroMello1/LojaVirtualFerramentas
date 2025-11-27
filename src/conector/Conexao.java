package ToolsShop.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Classe responsável por se conectar ao banco
public class Conexao {

    // Dados de validação para a conexão com o banco externo
    protected String url  = "jdbc:mysql://200.152.191.217:3306/loja_ferramentas?useSSL=false&serverTimezone=UTC";
    protected String user = "root";
    protected String pass = "1205";

    // Objetos usados na conexão e nas queries
    protected Connection       conn       = null;
    protected PreparedStatement pStatement = null;
    protected ResultSet         resultSet  = null;

    // Método de conexão
    protected void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexão efetuada");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cl) {
            cl.printStackTrace();
        }
        // não fecha aqui, pois as subclasses ainda usam a conexão
    }

    // Método para fechar conexão e recursos
    protected void fecharConexao() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (pStatement != null) {
                pStatement.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
