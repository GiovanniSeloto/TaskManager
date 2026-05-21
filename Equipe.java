import java.util.List;

public class Equipe {
    private String nomeEquipe;
    private String descricao;
    private List<Usuario> membros;

    public Equipe(String nomeEquipe, String descricao, List<Usuario> membros) {
        this.nomeEquipe = nomeEquipe;
        this.descricao = descricao;
        this.membros = membros;
    }
}
