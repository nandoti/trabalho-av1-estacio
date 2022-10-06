
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Conexao() {
    }
// Tentei conectar
    public static Connection getConexao() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3000/crud", "root", "");
            System.out.println("conectado com sucesso!");
            return connection;
        } catch (SQLException var1) {
            System.out.println("Erro ao conectar com o banco de dados!\nErro: " + var1);
            return null;
        }
    }
}
