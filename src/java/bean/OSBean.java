package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.OS;
import dao.OSDao;

@ManagedBean
@SessionScoped

public class OSBean {
  private int indexAtual = 0;
  private OS ordem = new OS(0);
  private OS ordemAlterada = new OS();
  private List<OS> ordens = new ArrayList<>();
  
  public OS getOrdem() {
    return ordem;
  }

  public void setOrdem(OS ordem) {
    this.ordem = ordem;
  }

  public OS getOrdemAlterada() {
    return ordemAlterada;
  }

  public void setOrdemAlterada(OS ordemAlterada) {
    this.ordemAlterada = ordemAlterada;
  }

  public List<OS> getOrdens() {
    return ordens;
  }

  public void setOrdens(List<OS> ordens) {
    this.ordens = ordens;
  }
  
  public void adicionar() {
    ordens.add(ordem);
    
    new OSDao().salvar(ordem);
    
    ordem = new OS(++indexAtual);
  }
  
  public void alterar() {
    for (OS ordem : ordens)
      if (ordem.getIndex() == ordemAlterada.getIndex()) {
        ordem.setData(ordemAlterada.getData());
        ordem.setIdCarro(ordemAlterada.getIdCarro());
        ordem.setIdCliente(ordemAlterada.getIdCliente());
        ordem.setIdEquipe(ordemAlterada.getIdEquipe());
      }
  }
  
  public void remover(OS c) {
    ordens.remove(c);
  }
}