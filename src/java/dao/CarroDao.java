package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carro;
import util.FabricaConexao;

public class CarroDao {
  public void salvar(Carro carro) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps;
      
      if (carro.getId() == null)
        ps = conexao.prepareStatement("INSERT INTO `oficina`.`carro`(`placa`,`marca`,`modelo`,`km`,`idCliente`)VALUES(?,?,?,?,?)");
      else {
        ps = conexao.prepareStatement("update carro set placa=?, marca=?, modelo=?, km=?, idCliente=? where id=?");
        
        ps.setInt(6, carro.getId());
      }
        
      ps.setString(1, carro.getPlaca());
      ps.setString(2, carro.getMarca());
      ps.setString(3, carro.getModelo());
      ps.setDouble(4, carro.getKm());
      ps.setInt(5, carro.getIdCliente());
      ps.execute();
      
      FabricaConexao.fecharConexao();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void excluir(Carro carro) {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("DELETE FROM `oficina`.`carro` WHERE id = ?");
      
      ps.setInt(1, carro.getId());
      ps.execute();
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    FabricaConexao.fecharConexao();
  }
  
  public List<Carro> buscar() {
    try {
      Connection conexao = FabricaConexao.getConexao();
      PreparedStatement ps = conexao.prepareStatement("select * from carro");
      ResultSet resultSet = ps.executeQuery();
      
      List<Carro> carros = new ArrayList<>();
      
      while (resultSet.next()) {
        Carro carro = new Carro();
        
        carro.setId(resultSet.getInt("id"));
        carro.setPlaca(resultSet.getString("placa"));
        carro.setMarca(resultSet.getString("marca"));
        carro.setModelo(resultSet.getString("modelo"));
        carro.setKm(resultSet.getDouble("km"));
        carro.setIdCliente(resultSet.getInt("idCliente"));
        
        carros.add(carro);
      }
      
      FabricaConexao.fecharConexao();
      
      return carros;
    }
    
    catch (SQLException ex) {
      Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
      FabricaConexao.fecharConexao();
      
      return null;
    }
  }
}