package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author André
 */
public class CriaConexao {
    
    public static Connection getConexao() throws SQLException {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Conectado ao banco");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/padaria?serverTimezone=UTC","root", "");
            
  return conn;
        }
        catch (ClassNotFoundException e) {
            
            throw new SQLException(e.getMessage());
            
        }
    
    
    }
    
}
