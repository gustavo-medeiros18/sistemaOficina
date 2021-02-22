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
  private ProdutoServico ps = new ProdutoServico();
  private List<ProdutoServico> listaPS = new ArrayList<>();
  private ProdutoServicoDao psdao = new ProdutoServicoDao();
  
  public ProdutoServico getPS() {
    return ps;
  }

  public void setPS(ProdutoServico ps) {
    this.ps = ps;
  }

  public List<ProdutoServico> getListaPS() {
    return listaPS;
  }

  public void setListaPS(List<ProdutoServico> listaPS) {
    this.listaPS = listaPS;
  }
  
  public void adicionar() {
    psdao.salvar(ps);
    
    ps = new ProdutoServico();
    this.listar();
  }
  
  public void editar(ProdutoServico ps) {
    this.ps = ps;
  }
  
  public void listar() {
    listaPS = psdao.buscar();
  }
  
  public void remover(ProdutoServico ps) {
    psdao.remover(ps);
    
    this.listar();
  }
}