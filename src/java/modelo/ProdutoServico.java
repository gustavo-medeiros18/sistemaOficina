package modelo;

/**
 * Esta classe representa a entidade Produto/Servico, que por sua vez
 * armazenara os dados de produtos e/ou servicos da oficina.
 */
public class ProdutoServico {
  private Integer id;
  private String nome;

  public ProdutoServico() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
