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
  private int indexAtual = 0;
  private Mecanico m = new Mecanico(0);
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
    /*mecanicos.add(m);*/
    
    mecanicodao.salvar(m);
    
    m = new Mecanico();
    this.listar();
  }
  
  public void listar() {
    mecanicos = mecanicodao.buscar();
  }
  
  public void alterar() {
    for (Mecanico mecanico : mecanicos)
      if (mecanico.getIndex() == mecanicoAlterado.getIndex()) {
        mecanico.setNome(mecanicoAlterado.getNome());
        mecanico.setCpf(mecanicoAlterado.getCpf());
        mecanico.setEndereco(mecanicoAlterado.getEndereco());
        mecanico.setCidade(mecanicoAlterado.getCidade());
        mecanico.setEstado(mecanicoAlterado.getEstado());
        mecanico.setIdEquipe(mecanicoAlterado.getIdEquipe());
      }
  }
  
  public void remover(Mecanico m) {
    mecanicos.remove(m);
  }
}