package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.OS;

@ManagedBean
@SessionScoped

public class OSBean {
  private OS ordem = new OS();
  private List<OS> ordens = new ArrayList<>();
  
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
    ordens.add(ordem);
    
    /*new CarroDao().salvar(c);*/
    
    ordem = new OS();
  }
  
  public void remover(OS c) {
    ordens.remove(c);
  }
}