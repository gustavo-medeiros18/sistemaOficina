package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.OS;
import util.FabricaConexao;

public class OSDao {
  public void salvar(OS ordem) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps;
      
      if (ordem.getNumero() == null)
        ps = conexao.prepareCall("INSERT INTO `oficina`.`os`(`data`,`idCarro`,`idCliente`,`idEquipe`)VALUES(?,?,?,?)");
      else {
        ps = conexao.prepareStatement("UPDATE `oficina`.`os` SET data = ?, idCarro = ?, idCliente = ?, idEquipe = ? WHERE numero = ?");
        
        ps.setInt(5, ordem.getNumero());
      }
      
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
  
  public void remover(OS ordem) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("DELETE FROM `oficina`.`os` WHERE numero = ?");
      
      ps.setInt(1, ordem.getNumero());
      ps.execute();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(OSDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    FabricaConexao.fecharConexao();
  }
  
  public List<OS> buscar() {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("select * from os");
      ResultSet resultSet = ps.executeQuery();
      
      List<OS> listaos = new ArrayList<>();
      
      while (resultSet.next()) {
        OS os = new OS();
        
        os.setNumero(resultSet.getInt("numero"));
        os.setData(resultSet.getString("data"));
        os.setIdCarro(resultSet.getInt("idCarro"));
        os.setIdCliente(resultSet.getInt("idCliente"));
        os.setIdEquipe(resultSet.getInt("idEquipe"));
        
        listaos.add(os);
      }
      
      FabricaConexao.fecharConexao();
      return listaos;
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
      
      FabricaConexao.fecharConexao();
      return null;
    }
  }
}