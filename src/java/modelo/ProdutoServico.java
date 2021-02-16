package modelo;

/**
 * Esta classe representa a entidade Produto/Servico, que por sua vez
 * armazenara os dados de produtos e/ou servicos da oficina.
 */
public class ProdutoServico {
  /*A PK id de Produto/Servico nao sera
  definida como um atributo da classe, pois
  ela sera determinada pelo BD, nao pelo
  usuario*/
  private int index;
  private String nome;

  public ProdutoServico(int index) {
    this.index = index;
  }

  public ProdutoServico() {
  }
  
  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
  
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
