package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Mecanico;

@ManagedBean
@SessionScoped

public class MecanicoBean {
  private Mecanico m = new Mecanico();
  private List<Mecanico> mecanicos = new ArrayList<>();
  
  public Mecanico getM() {
    return m;
  }

  public void setM(Mecanico m) {
    this.m = m;
  }

  public List<Mecanico> getMecanicos() {
    return mecanicos;
  }

  public void setMecanicos(List<Mecanico> mecanicos) {
    this.mecanicos = mecanicos;
  }
  
  public void adicionar() {
    mecanicos.add(m);
    
    /*new CarroDao().salvar(c);*/
    
    m = new Mecanico();
  }
  
  public void remover(Mecanico m) {
    mecanicos.remove(m);
  }
}