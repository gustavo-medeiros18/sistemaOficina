package modelo;

public class Equipe {
  /*Neste caso, o id da Equipe sera definido
  como um atributo da classe, pois ao cadastrar
  uma Equipe no sistema, o usuario tera que definir
  qual eh id da Equipe, visto que tanto a classe como a
  entidade Equipe possuem apenas um atributo, que eh
  o seu numero de identificacao (id)*/
  private int id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}