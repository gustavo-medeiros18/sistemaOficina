package modelo;

public class Equipe {
  private Integer id;
  private int index;
  
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}