package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {
  private static Connection conexao;
  private static final String URL_CONEXAO = "jdbc:mysql://localhost/sistema-carros";
  private static final String USUARIO = "root";
  private static final String SENHA = "190601";

  public static Connection getConexao() {
    if (conexao == null) {
      try {
        Class.forName("com.mysql.jdbc.driver");
        
        conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
      }
      
      catch (SQLException | ClassNotFoundException ex) {
        Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    return conexao;
  }
  
  public static void fecharConexao() {
    if (conexao != null) {
      try {
        conexao.close();
        
        conexao = null;
      }
      
      catch (SQLException ex) {
        Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
