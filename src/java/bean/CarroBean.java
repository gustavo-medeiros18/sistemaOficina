package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Carro;
import dao.CarroDao;

@ManagedBean
@SessionScoped

public class CarroBean {
  private int indexAtual = 0;
  private Carro c = new Carro(0);
  private Carro carroAlterado = new Carro();
  private List<Carro> carros = new ArrayList<>();
  private CarroDao carrodao= new CarroDao(); 
  
  public Carro getC() {
    return c;
  }

  public void setC(Carro c) {
    this.c = c;
  }

  public Carro getCarroAlterado() {
    return carroAlterado;
  }

  public void setCarroAlterado(Carro carroAlterado) {
    this.carroAlterado = carroAlterado;
  }
  
  public List<Carro> getCarros() {
    return carros;
  }

  public void setCarros(List<Carro> carros) {
    this.carros = carros;
  }
  
  public void adicionar() {
    /*carros.add(c);*/
   
    carrodao.salvar(c);
    
    c = new Carro();
    this.listar();
  }
  
  public void listar() {
    carros = carrodao.buscar();
  }
  
  public void alterar() {
    for (Carro carro : carros) {
      if (carro.getIndex() == carroAlterado.getIndex()) {
        carro.setPlaca(carroAlterado.getPlaca());
        carro.setMarca(carroAlterado.getMarca());
        carro.setModelo(carroAlterado.getModelo());
        carro.setKm(carroAlterado.getKm());
        carro.setIdCliente(carroAlterado.getIdCliente());
      }
    }
  }
  
  public void remover(Carro c) {
    carros.remove(c);
  }
}