package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.OS;
import util.FabricaConexao;

public class OSDao {
  public void salvar(OS ordem) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareCall("INSERT INTO `oficina`.`os`(`data`,`idCarro`,`idCliente`,`idEquipe`)VALUES(?,?,?,?)");
      
      ps.setString(1, ordem.getData());
      ps.setInt(2, ordem.getIdCarro());
      ps.setInt(3, ordem.getIdCliente());
      ps.setInt(4, ordem.getIdEquipe());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}