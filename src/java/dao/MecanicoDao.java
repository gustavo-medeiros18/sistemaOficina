package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Mecanico;
import util.FabricaConexao;

public class MecanicoDao {
  public void salvar(Mecanico mecanico) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps; 
      
      if (mecanico.getId() == null)
        ps = conexao.prepareCall("INSERT INTO `oficina`.`mecanico`(`nome`,`cpf`,`endereco`,`cidade`,`estado`,`idEquipe`)VALUES(?,?,?,?,?,?)");
      else {
        ps = conexao.prepareCall("UPDATE `oficina`.`mecanico` SET nome = ?, cpf = ?, endereco = ?, cidade = ?, estado = ?, idEquipe = ? WHERE id = ?");
        
        ps.setInt(7, mecanico.getId());
      }
      
      ps.setString(1, mecanico.getNome());
      ps.setString(2, mecanico.getCpf());
      ps.setString(3, mecanico.getEndereco());
      ps.setString(4, mecanico.getCidade());
      ps.setString(5, mecanico.getEstado());
      ps.setInt(6, mecanico.getIdEquipe());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void remover(Mecanico mecanico) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("DELETE FROM `oficina`.`mecanico` WHERE id = ?");
      
      ps.setInt(1, mecanico.getId());
      ps.execute();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(MecanicoDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    FabricaConexao.fecharConexao();
  }
  
  public List<Mecanico> buscar() {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("select * from oficina.mecanico");
      ResultSet resultSet = ps.executeQuery();
      
      List<Mecanico> mecanicos = new ArrayList<>();
      
      while (resultSet.next()) {
        Mecanico mecanico = new Mecanico();
        
        mecanico.setId(resultSet.getInt("id"));
        mecanico.setNome(resultSet.getString("nome"));
        mecanico.setCpf(resultSet.getString("cpf"));
        mecanico.setEndereco(resultSet.getString("endereco"));
        mecanico.setCidade(resultSet.getString("cidade"));
        mecanico.setEstado(resultSet.getString("estado"));
        mecanico.setIdEquipe(resultSet.getInt("idEquipe"));
        
        mecanicos.add(mecanico);
      }
      
      FabricaConexao.fecharConexao();
      
      return mecanicos;
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
      FabricaConexao.fecharConexao();
      
      return null;
    }
  }
}