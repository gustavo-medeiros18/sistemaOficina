package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.OSProdutoServico;
import util.FabricaConexao;

public class OSPSDao {
  public void salvar(OSProdutoServico osps) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps;
      
      if (osps.getIdOSPS() == null)
        ps = conexao.prepareStatement("INSERT INTO `oficina`.`os-produto/servico`(`numeroOS`,`idProdutoServico`)VALUES(?,?)");
      else {
        ps = conexao.prepareStatement("UPDATE `oficina`.`os-produto/servico` SET numeroOS = ?, idProdutoServico = ? WHERE idOSPS = ?");
        
        ps.setInt(3, osps.getIdOSPS());
      }
      
      ps.setInt(1, osps.getNumeroOS());
      ps.setInt(2, osps.getIdProdutoServico());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public List<OSProdutoServico> buscar() {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("SELECT * FROM oficina.`os-produto/servico`");
      ResultSet resultSet = ps.executeQuery();
      
      List<OSProdutoServico> listaOSPS = new ArrayList<>();
      
      while (resultSet.next()) {
        OSProdutoServico osps = new OSProdutoServico();
        
        osps.setIdOSPS(resultSet.getInt("idOSPS"));
        osps.setNumeroOS(resultSet.getInt("numeroOS"));
        osps.setIdProdutoServico(resultSet.getInt("idProdutoServico"));
  
        listaOSPS.add(osps);
      }
      
      return listaOSPS;
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
      
      return null;
    }
  }
}