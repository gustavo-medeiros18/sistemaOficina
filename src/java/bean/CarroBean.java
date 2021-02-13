package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Carro;

@ManagedBean
@SessionScoped

public class CarroBean {
  private Carro c = new Carro();
  private List<Carro> carros = new ArrayList<>();
  
  public Carro getC() {
    return c;
  }

  public void setC(Carro c) {
    this.c = c;
  }

  public List<Carro> getCarros() {
    return carros;
  }

  public void setCarros(List<Carro> carros) {
    this.carros = carros;
  }
  
  public void adicionar() {
    carros.add(c);
    
    /*new CarroDao().salvar(c);*/
    
    c = new Carro();
  }
  
  public void remover(Carro c) {
    carros.remove(c);
  }
}