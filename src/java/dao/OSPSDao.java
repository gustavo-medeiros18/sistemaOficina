package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.OSProdutoServico;
import util.FabricaConexao;

public class OSPSDao {
  public void salvar(OSProdutoServico osps) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareCall("INSERT INTO `oficina`.`os-produto/servico`(`numeroOS`,`idProdutoServico`)VALUES(?,?)");
      
      ps.setInt(1, osps.getNumeroOS());
      ps.setInt(2, osps.getIdProdutoServico());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}