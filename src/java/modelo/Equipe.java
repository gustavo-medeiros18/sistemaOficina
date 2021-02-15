package modelo;

public class Equipe {
  /*Neste caso, o id da Equipe sera definido
  como um atributo da classe, pois ao cadastrar
  uma Equipe no sistema, o usuario tera que definir
  qual eh id da Equipe, visto que tanto a classe como a
  entidade Equipe possuem apenas um atributo, que eh
  o seu numero de identificacao (id). O atributo index
  eh utilizado como meio de identificacao da equipe para
  sua alteracao*/
  private int index, id;
  
  public Equipe(int index) {
    this.setIndex(index);
  }
  
  public Equipe() {
  
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}