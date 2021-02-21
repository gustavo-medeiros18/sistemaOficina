package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;;
import modelo.ProdutoServico;
import util.FabricaConexao;

public class ProdutoServicoDao {
  public void salvar(ProdutoServico produtoServico) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps;
      
      if (produtoServico.getId() == null)
        ps = conexao.prepareCall("INSERT INTO `oficina`.`produto/servico`(`nome`)VALUES(?)");
      else {
        ps = conexao.prepareStatement("UPDATE `oficina`.`produto/servico` SET nome = ? WHERE id = ?");
        
        ps.setInt(2, produtoServico.getId());
      }
      
      ps.setString(1, produtoServico.getNome());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public List<ProdutoServico> buscar() {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("SELECT * FROM oficina.`produto/servico`");
      ResultSet resultSet = ps.executeQuery();
      
      List<ProdutoServico> listaprodutoservico = new ArrayList<>();
      
      while (resultSet.next()) {
        ProdutoServico produtoservico = new ProdutoServico();
        
        produtoservico.setId(resultSet.getInt("id"));
        produtoservico.setNome(resultSet.getString("nome"));
      
        listaprodutoservico.add(produtoservico);
      }
      
      return listaprodutoservico;
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
      
      return null;
    }
  }
}