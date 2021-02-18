package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.ProdutoServico;
import dao.ProdutoServicoDao;

@ManagedBean
@SessionScoped

public class ProdutoServicoBean {
  private int indexAtual = 0;
  private ProdutoServico ps = new ProdutoServico(0);
  private ProdutoServico psAlterado = new ProdutoServico();
  private List<ProdutoServico> listaPS = new ArrayList<>();
  
  public ProdutoServico getPS() {
    return ps;
  }

  public void setPS(ProdutoServico ps) {
    this.ps = ps;
  }

  public ProdutoServico getPsAlterado() {
    return psAlterado;
  }

  public void setPsAlterado(ProdutoServico psAlterado) {
    this.psAlterado = psAlterado;
  }

  public List<ProdutoServico> getListaPS() {
    return listaPS;
  }

  public void setListaPS(List<ProdutoServico> listaPS) {
    this.listaPS = listaPS;
  }
  
  public void adicionar() {
    listaPS.add(ps);
    
    new ProdutoServicoDao().salvar(ps);
    
    ps = new ProdutoServico(++indexAtual);
  }
  
  public void alterar() {
    for (ProdutoServico ps : listaPS)
      if (ps.getIndex() == psAlterado.getIndex())
        ps.setNome(psAlterado.getNome());
  }
  
  public void remover(ProdutoServico ps) {
    listaPS.remove(ps);
  }
}