package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;

@ManagedBean
@SessionScoped

public class ClienteBean {
  private Cliente c = new Cliente();
  private List<Cliente> clientes = new ArrayList<>();
  
  public Cliente getC() {
    return c;
  }

  public void setC(Cliente c) {
    this.c = c;
  }

  public List<Cliente> getClientes() {
    return clientes;
  }

  public void setCarros(List<Cliente> clientes) {
    this.clientes = clientes;
  }
  
  public void adicionar() {
    clientes.add(c);
    
    /*new CarroDao().salvar(c);*/
    
    c = new Cliente();
  }
  
  public void remover(Cliente c) {
    clientes.remove(c);
  }
}