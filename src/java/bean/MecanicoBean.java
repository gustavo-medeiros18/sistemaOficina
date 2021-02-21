package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Mecanico;
import dao.MecanicoDao;

@ManagedBean
@SessionScoped

public class MecanicoBean {
  private Mecanico m = new Mecanico();
  private Mecanico mecanicoAlterado = new Mecanico();
  private List<Mecanico> mecanicos = new ArrayList<>();
  private MecanicoDao mecanicodao = new MecanicoDao();
  
  public Mecanico getM() {
    return m;
  }

  public void setM(Mecanico m) {
    this.m = m;
  }

  public Mecanico getMecanicoAlterado() {
    return mecanicoAlterado;
  }

  public void setMecanicoAlterado(Mecanico mecanicoAlterado) {
    this.mecanicoAlterado = mecanicoAlterado;
  }

  public List<Mecanico> getMecanicos() {
    return mecanicos;
  }

  public void setMecanicos(List<Mecanico> mecanicos) {
    this.mecanicos = mecanicos;
  }
  
  public void adicionar() {
    mecanicodao.salvar(m);
    
    m = new Mecanico();
    this.listar();
  }
  
  public void editar(Mecanico mecanico) {
    this.m = mecanico;
  }
  
  public void listar() {
    mecanicos = mecanicodao.buscar();
  }
  
  public void remover(Mecanico m) {
    mecanicos.remove(m);
  }
}