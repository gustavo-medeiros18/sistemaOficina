package modelo;

public class OS {
  private Integer numero;
  private int index;
  private String data;
  private int idCarro, idCliente, idEquipe;

  public OS() {
  }

  public OS(int index) {
    this.index = index;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }
  
  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
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