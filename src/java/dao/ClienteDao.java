package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import util.FabricaConexao;

public class ClienteDao {
  public void salvar(Cliente cliente) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareCall("INSERT INTO `oficina`.`cliente`(`nome`,`endereco`,`cidade`,`estado`)VALUES(?,?,?,?)");
      
      ps.setString(1, cliente.getNome());
      ps.setString(2, cliente.getEndereco());
      ps.setString(3, cliente.getCidade());
      ps.setString(4, cliente.getEstado());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}