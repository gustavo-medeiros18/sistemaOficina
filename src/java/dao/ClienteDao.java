package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import util.FabricaConexao;

public class ClienteDao {
  public void salvar(Cliente cliente) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps; 
      
      if (cliente.getId() == null)
        ps= conexao.prepareCall("INSERT INTO `oficina`.`cliente`(`nome`,`endereco`,`cidade`,`estado`)VALUES(?,?,?,?)");
      else {
        ps = conexao.prepareStatement("UPDATE oficina.cliente SET nome = ?, endereco = ?, cidade = ?, estado = ? WHERE id = ?;");
        
        ps.setInt(5, cliente.getId());
      }
      
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
  
  public List<Cliente> buscar() {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("select * from cliente");
      ResultSet resultSet = ps.executeQuery();
      
      List<Cliente> clientes = new ArrayList<>();
      
      while (resultSet.next()) {
        Cliente cliente = new Cliente();
        
        cliente.setId(resultSet.getInt("id"));
        cliente.setNome(resultSet.getString("nome"));
        cliente.setEndereco(resultSet.getString("endereco"));
        cliente.setCidade(resultSet.getString("cidade"));
        cliente.setEstado(resultSet.getString("estado"));
      
        
        clientes.add(cliente);
      }
      
      return clientes;
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
      
      return null;
    }
  }
}