package bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Equipe;
import dao.EquipeDao;

@ManagedBean
@SessionScoped

public class EquipeBean {
  private Equipe e = new Equipe();
  private Equipe equipeAlterada = new Equipe();
  private List<Equipe> equipes = new ArrayList<>();
  private EquipeDao equipedao = new EquipeDao();
  
  public Equipe getE() {
    return e;
  }

  public void setE(Equipe e) {
    this.e = e;
  }

  public Equipe getEquipeAlterada() {
    return equipeAlterada;
  }

  public void setEquipeAlterada(Equipe equipeAlterada) {
    this.equipeAlterada = equipeAlterada;
  }

  public List<Equipe> getEquipes() {
    return equipes;
  }

  public void setEquipes(List<Equipe> equipes) {
    this.equipes = equipes;
  }
  
  public void adicionar() {
    equipedao.salvar(e);
    
    e = new Equipe();
    this.listar();
  }
  
  public void editar(Equipe e) {
    this.e = e;
  }
  
  public void listar() {
    equipes = equipedao.buscar();
  }
  
  public void remover(Equipe e) {
    equipes.remove(e);
  }
}