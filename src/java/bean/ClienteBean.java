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
  private int indexAtual = 0;
  private Cliente c = new Cliente(0);
  private Cliente clienteAlterado = new Cliente();
  private List<Cliente> clientes = new ArrayList<>();
  
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
    clientes.add(c);
    
    indexAtual++;
    
    new ClienteDao().salvar(c);
    
    c = new Cliente(indexAtual);
  }
  
  public void alterar() {
    for (Cliente cliente : clientes)
      if (cliente.getIndex() == clienteAlterado.getIndex()) {
        cliente.setNome(clienteAlterado.getNome());
        cliente.setCidade(clienteAlterado.getCidade());
        cliente.setEndereco(clienteAlterado.getEndereco());
        cliente.setEstado(clienteAlterado.getEstado());
      }
  }
  
  public void remover(Cliente c) {
    clientes.remove(c);
  }
}