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
  private int indexAtual = 0;
  private OSProdutoServico osps = new OSProdutoServico(0);
  private OSProdutoServico ospsAlterado = new OSProdutoServico();
  private List<OSProdutoServico> listaOSPS = new ArrayList<>();
  
  public OSProdutoServico getOSPS() {
    return osps;
  }

  public void setOSPS(OSProdutoServico osps) {
    this.osps = osps;
  }

  public OSProdutoServico getOspsAlterado() {
    return ospsAlterado;
  }

  public void setOspsAlterado(OSProdutoServico ospsAlterado) {
    this.ospsAlterado = ospsAlterado;
  }

  public List<OSProdutoServico> getListaOSPS() {
    return listaOSPS;
  }

  public void setListaOSPS(List<OSProdutoServico> listaOSPS) {
    this.listaOSPS = listaOSPS;
  }
  
  public void adicionar() {
    listaOSPS.add(osps);
    
    new OSPSDao().salvar(osps);
    
    osps = new OSProdutoServico(++indexAtual);
  }
  
  public void alterar() {
    for (OSProdutoServico osps : listaOSPS)
      if (osps.getIndex() == ospsAlterado.getIndex()) {
        osps.setNumeroOS(ospsAlterado.getIdProdutoServico());
        osps.setIdProdutoServico(ospsAlterado.getIdProdutoServico());
      }
  }
  
  public void remover(OSProdutoServico osps) {
    listaOSPS.remove(osps);
  }
}