package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carro;
import util.FabricaConexao;

public class CarroDao {
  public void salvar(Carro carro) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareCall("INSERT INTO `carro`(`modelo`,`fabricante`,`cor`,`ano`)VALUES(?,?,?,?");
      
      ps.setString(1, carro.getModelo());
      ps.setString(2, carro.getFabricante());
      ps.setString(3, carro.getCor());
      ps.setInt(4, carro.getAno());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}