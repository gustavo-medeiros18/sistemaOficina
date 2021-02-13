package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.ProdutoServico;

@ManagedBean
@SessionScoped

public class ProdutoServicoBean {
  private ProdutoServico ps = new ProdutoServico();
  private List<ProdutoServico> listaPS = new ArrayList<>();
  
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
    listaPS.add(ps);
    
    /*new CarroDao().salvar(c);*/
    
    ps = new ProdutoServico();
  }
  
  public void remover(ProdutoServico ps) {
    listaPS.remove(ps);
  }
}