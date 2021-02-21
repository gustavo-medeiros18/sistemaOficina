package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipe;
import util.FabricaConexao;

public class EquipeDao {
  public void salvar(Equipe equipe) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps; 
      
      if (equipe.getId() == null) {
        ps = conexao.prepareCall("INSERT INTO `oficina`.`equipe`(`id`)VALUES(?)");
        
        ps.setInt(1, equipe.getId());
      }
      else {
        int idAntes = equipe.getId();
        
        ps = conexao.prepareStatement("UPDATE oficina.equipe SET id = ? WHERE id = ?");
        
        ps.setInt(1, equipe.getId());
        ps.setInt(2, idAntes);
      }
                
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public List<Equipe> buscar() {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("select * from equipe");
      ResultSet resultSet = ps.executeQuery();
      
      List<Equipe> equipes = new ArrayList<>();
      
      while (resultSet.next()) {
        Equipe equipe = new Equipe();
        
        equipe.setId(resultSet.getInt("id"));
       
        equipes.add(equipe);
      }
      
      return equipes;
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
      
      return null;
    }
  }
}