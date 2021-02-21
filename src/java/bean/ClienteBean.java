package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import dao.ClienteDao;

@ManagedBean
@SessionScoped

public class ClienteBean {
  private Cliente c = new Cliente();
  private Cliente clienteAlterado = new Cliente();
  private List<Cliente> clientes = new ArrayList<>();
  private ClienteDao clientedao = new ClienteDao();
  
  public Cliente getC() {
    return c;
  }

  public void setC(Cliente c) {
    this.c = c;
  }

  public Cliente getClienteAlterado() {
    return clienteAlterado;
  }

  public void setClienteAlterado(Cliente clienteAlterado) {
    this.clienteAlterado = clienteAlterado;
  }

  public List<Cliente> getClientes() {
    return clientes;
  }

  public void setCarros(List<Cliente> clientes) {
    this.clientes = clientes;
  }
  
  public void adicionar() {
    clientedao.salvar(c);
    
    c = new Cliente();
    this.listar();
  }
  
  public void editar(Cliente c) {
    this.c = c;
  }
  
  public void listar() {
    clientes = clientedao.buscar();
  }
  
  public void remover(Cliente c) {
    clientes.remove(c);
  }
}