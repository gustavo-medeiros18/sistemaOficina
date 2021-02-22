package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.OSProdutoServico;
import dao.OSPSDao;

@ManagedBean
@SessionScoped

public class OSPSBean {
  private OSProdutoServico osps = new OSProdutoServico();
  private List<OSProdutoServico> listaOSPS = new ArrayList<>();
  private OSPSDao ospsDao = new OSPSDao();
  
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
    ospsDao.salvar(osps);
    
    osps = new OSProdutoServico();
    this.listar();
  }
  
  public void editar(OSProdutoServico osps) {
    this.osps = osps;
  }
  
  public void listar() {
    listaOSPS = ospsDao.buscar();
  }
  
  public void remover(OSProdutoServico osps) {
    ospsDao.excluir(osps);
    
    this.listar();
  }
}