package LocadoraDeCarros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LocadoraDeCarrosConexao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/locadora_de_carros";
    private static final String USER = "root";
    private static final String PASSWORD = "andreza";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao!", ex);
            
        }
    }
}
