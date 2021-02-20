package modelo;

/**
 * Esta classe representa a entidade Produto/Servico, que por sua vez
 * armazenara os dados de produtos e/ou servicos da oficina.
 */
public class ProdutoServico {
  private Integer id;
  private int index;
  private String nome;

  public ProdutoServico(int index) {
    this.index = index;
  }

  public ProdutoServico() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
