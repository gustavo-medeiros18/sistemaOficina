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
      PreparedStatement ps = conexao.prepareCall("INSERT INTO `carro`(`placa`, `marca`, `modelo`, `km`, `idCliente`)VALUES(?,?,?,?,?");
      
      ps.setString(1, carro.getPlaca());
      ps.setString(2, carro.getMarca());
      ps.setString(3, carro.getModelo());
      ps.setDouble(4, carro.getKm());
      ps.setInt(5, carro.getIdCliente());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}