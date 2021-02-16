package modelo;

public class OS {
  /*A PK numero da OS nao sera
  definida como um atributo da classe,
  pois seu valor sera determinado pelo BD,
  nao pelo usuario*/
  private int index;
  private String data;
  private String placaCarro;
  private int idCliente, idEquipe;

  public OS() {
  }

  public OS(int index) {
    this.index = index;
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

  public String getPlacaCarro() {
    return placaCarro;
  }

  public void setPlacaCarro(String placaCarro) {
    this.placaCarro = placaCarro;
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