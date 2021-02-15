package modelo;

public class Carro {
  /*A PK id do carro nao sera
  definida como um atributo da classe,
  pois seu valor sera determinado pelo BD,
  nao pelo usuario*/
  private int index; /*Indice de identificacao, para alterar o carro*/
  private String placa, marca, modelo;
  private Double km;
  private int idCliente;
   
  public Carro() {
  
  }
  
  public Carro(int index) {
    this.setIndex(index);
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
}