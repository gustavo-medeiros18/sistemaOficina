package bean;

/*import dao.CarroDao;*/
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Equipe;

@ManagedBean
@SessionScoped

public class EquipeBean {
  private int indexAtual = 0;
  private Equipe e = new Equipe(0);
  private Equipe equipeAlterada = new Equipe();
  private List<Equipe> equipes = new ArrayList<>();
  
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
    equipes.add(e);
    
    indexAtual++;
    
    /*new CarroDao().salvar(c);*/
    
    e = new Equipe(indexAtual);
  }
  
  public void alterar() {
    for (Equipe equipe : equipes)
      if (equipe.getIndex() == equipeAlterada.getIndex())
        equipe.setId(equipeAlterada.getId());
  }
  
  public void remover(Equipe e) {
    equipes.remove(e);
  }
}