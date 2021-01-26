package modelo;

import java.sql.Date;

public class OS {
  private Date data;
  private String placaCarro;
  private int codigoCliente, codigoEquipe;

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getPlacaCarro() {
    return placaCarro;
  }

  public void setPlacaCarro(String placaCarro) {
    this.placaCarro = placaCarro;
  }

  public int getCodigoCliente() {
    return codigoCliente;
  }

  public void setCodigoCliente(int codigoCliente) {
    this.codigoCliente = codigoCliente;
  }

  public int getCodigoEquipe() {
    return codigoEquipe;
  }

  public void setCodigoEquipe(int codigoEquipe) {
    this.codigoEquipe = codigoEquipe;
  }
}