package Classes;
import java.io.Serializable;
import java.util.List;

public class Equipe implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nomeEquipe;
    private String descricao;
    private List<Usuario> membros;

    public Equipe(String nomeEquipe, String descricao, List<Usuario> membros) {
        this.nomeEquipe = nomeEquipe;
        this.descricao = descricao;
        this.membros = membros;
    }
    
    public String getNomeEquipe() {
		return nomeEquipe;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Usuario> getMembros() {
		return membros;
	}
}
