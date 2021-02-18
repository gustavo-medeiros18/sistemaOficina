package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Mecanico;
import util.FabricaConexao;

public class MecanicoDao {
  public void salvar(Mecanico mecanico) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareCall("INSERT INTO `oficina`.`mecanico`(`nome`,`cpf`,`endereco`,`cidade`,`estado`,`idEquipe`)VALUES(?,?,?,?,?,?)");
      
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
}