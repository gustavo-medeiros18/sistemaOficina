package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.OSProdutoServico;

@ManagedBean
@SessionScoped

public class OSPSBean {
  private OSProdutoServico osps = new OSProdutoServico();
  private List<OSProdutoServico> listaOSPS = new ArrayList<>();
  
  public OSProdutoServico getOSPS() {
    return osps;
  }

  public void setOSPS(OSProdutoServico osps) {
    this.osps = osps;
  }

  public List<OSProdutoServico> getListaOSPS() {
    return listaOSPS;
  }

  public void setListaOSPS(List<OSProdutoServico> listaOSPS) {
    this.listaOSPS = listaOSPS;
  }
  
  public void adicionar() {
    listaOSPS.add(osps);
    
    /*new CarroDao().salvar(c);*/
    
    osps = new OSProdutoServico();
  }
  
  public void remover(OSProdutoServico osps) {
    listaOSPS.remove(osps);
  }
}