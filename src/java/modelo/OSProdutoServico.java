package modelo;
/**
 * Esta classe representa a entidade OS-Produto/Servico, que
 * por sua vez armazenara os dados (chaves) da relacao entre
 * as entidades Produto/Servico e OS
 */
public class OSProdutoServico {
  private int numeroOS, idProdutoServico;

  public int getNumeroOS() {
    return numeroOS;
  }

  public void setNumeroOS(int numeroOS) {
    this.numeroOS = numeroOS;
  }

  public int getIdProdutoServico() {
    return idProdutoServico;
  }

  public void setIdProdutoServico(int idProdutoServico) {
    this.idProdutoServico = idProdutoServico;
  }
}
