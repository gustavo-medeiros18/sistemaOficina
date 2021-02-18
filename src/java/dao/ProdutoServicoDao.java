package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ProdutoServico;
import util.FabricaConexao;

public class ProdutoServicoDao {
  public void salvar(ProdutoServico produtoServico) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareCall("INSERT INTO `oficina`.`produto/servico`(`nome`)VALUES(?)");
      
      ps.setString(1, produtoServico.getNome());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}