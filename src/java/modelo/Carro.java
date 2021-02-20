package modelo;

import java.util.Objects;

public class Carro {
  private Integer id;
  private int index; /*Indice de identificacao, para alterar o carro*/
  private String placa, marca, modelo;
  private Double km;
  private int idCliente;
   
  public Carro() {
  
  }
  
  public Carro(int index) {
    this.setIndex(index);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Double getKm() {
    return km;
  }

  public void setKm(Double km) {
    this.km = km;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.id);
    
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    
    final Carro other = (Carro) obj;
    
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    
    return true;
  }
}