package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipe;
import util.FabricaConexao;

public class EquipeDao {
  public void salvar(Equipe equipe) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareCall("INSERT INTO `oficina`.`equipe`(`id`)VALUES(?)");
      
      ps.setInt(1, equipe.getId());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}