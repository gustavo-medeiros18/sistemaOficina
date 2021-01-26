package modelo;

/**
 * Esta classe representa a entidade Produto/Servico, que por sua vez
 * armazenara os dados de produtos e/ou servicos da oficina.
 */
public class ProdutoServico {
  /*A PK codigo de Produto/Servico nao sera
  definido como um atributo da classe, pois
  ela sera determinada pelo BD, nao pelo
  usuario*/
  private String nome;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
