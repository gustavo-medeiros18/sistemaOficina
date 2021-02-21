package modelo;

public class OS {
  private Integer numero;
  private String data;
  private int idCarro, idCliente, idEquipe;

  public OS() {
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public int getIdCarro() {
    return idCarro;
  }

  public void setIdCarro(int idCarro) {
    this.idCarro = idCarro;
  }

  public int getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(int idCliente) {
    this.idCliente = idCliente;
  }

  public int getIdEquipe() {
    return idEquipe;
  }

  public void setIdEquipe(int idEquipe) {
    this.idEquipe = idEquipe;
  }
}