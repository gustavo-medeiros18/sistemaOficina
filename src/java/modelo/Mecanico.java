package modelo;

public class Mecanico {
  /*A PK codigo do mecanico nao sera definida
  como um atributo da classe, pois seu valor
  sera determinado pelo BD, nao pelo usuario*/
  private String nome, cpf, endereco, cidade, estado;
  private int codigoEquipe;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public int getCodigoEquipe() {
    return codigoEquipe;
  }

  public void setCodigoEquipe(int codigoEquipe) {
    this.codigoEquipe = codigoEquipe;
  }
}