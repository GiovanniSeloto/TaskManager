import java.util.Date;

public class Projeto {
    private String nomeProjeto;
    private String descricao;
    private Date dataInicio;
    private Date dataTerminoPrevista;
    private StatusProjeto status;
    private Usuario gerenteResponsavel;

    public Projeto(String nomeProjeto, String descricao, Date dataInicio, Date dataTerminoPrevista, StatusProjeto status, Usuario gerente) {
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTerminoPrevista = dataTerminoPrevista;
        this.status = status;
        this.gerenteResponsavel = gerente;
    }
}
