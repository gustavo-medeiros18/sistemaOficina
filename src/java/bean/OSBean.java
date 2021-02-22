package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.OS;
import dao.OSDao;

@ManagedBean
@SessionScoped

public class OSBean {
  private OS ordem = new OS();
  private List<OS> ordens = new ArrayList<>();
  private OSDao osdao = new OSDao();
  
  public OS getOrdem() {
    return ordem;
  }

  public void setOrdem(OS ordem) {
    this.ordem = ordem;
  }

  public List<OS> getOrdens() {
    return ordens;
  }

  public void setOrdens(List<OS> ordens) {
    this.ordens = ordens;
  }
  
  public void adicionar() {
    osdao.salvar(ordem);
    
    ordem = new OS();
    this.listar();
  }
  
  public void Editar(OS os) {
    this.ordem = os;
  }
  
  public void listar() {
    ordens = osdao.buscar();
  }
  
  public void remover(OS ordem) {
    osdao.remover(ordem);
    
    this.listar();
  }
}