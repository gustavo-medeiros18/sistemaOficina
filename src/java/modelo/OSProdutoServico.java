package modelo;
/**
 * Esta classe representa a entidade OS-Produto/Servico, que
 * por sua vez armazenara os dados (chaves) da relacao entre
 * as entidades Produto/Servico e OS
 */
public class OSProdutoServico {
  private Integer numeroOS, idProdutoServico, idOSPS;

  public Integer getNumeroOS() {
    return numeroOS;
  }

  public void setNumeroOS(Integer numeroOS) {
    this.numeroOS = numeroOS;
  }

  public Integer getIdProdutoServico() {
    return idProdutoServico;
  }

  public void setIdProdutoServico(Integer idProdutoServico) {
    this.idProdutoServico = idProdutoServico;
  }

  public Integer getIdOSPS() {
    return idOSPS;
  }

  public void setIdOSPS(Integer idOSPS) {
    this.idOSPS = idOSPS;
  }
}
