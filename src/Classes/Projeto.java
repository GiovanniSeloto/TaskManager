package Classes;

import java.io.Serializable;

public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String nomeProjeto;
    private String descricao;
    private int dataInicio_dia;
    private int dataInicio_mes;
    private int dataInicio_ano;
    private int dataTerminoPrevista_dia;
    private int dataTerminoPrevista_mes;
    private int dataTerminoPrevista_ano;
    private StatusProjeto status;
    private Usuario gerenteResponsavel;

    public Projeto(String nomeProjeto, 
    				String descricao, 
    				int dataInicio_dia,
    				int dataInicio_mes,
    				int dataInicio_ano,
    				int dataTerminoPrevista_dia,
    				int dataTerminoPrevista_mes,
    				int dataTerminoPrevista_ano,
    				StatusProjeto status, 
    				Usuario gerente) {
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
        this.dataInicio_dia = dataInicio_dia;
        this.dataInicio_mes = dataInicio_mes;
        this.dataInicio_ano = dataInicio_ano;
        this.dataTerminoPrevista_dia = dataTerminoPrevista_dia;
        this.dataTerminoPrevista_mes = dataTerminoPrevista_mes;
        this.dataTerminoPrevista_ano = dataTerminoPrevista_ano;
        this.status = status;
        this.gerenteResponsavel = gerente;
    }
    
    public String getNomeProjeto() {
    	return this.nomeProjeto;
    }

	public String getDescricao() {
		return descricao;
	}

	public int getDataInicio_dia() {
		return dataInicio_dia;
	}

	public int getDataInicio_mes() {
		return dataInicio_mes;
	}

	public int getDataInicio_ano() {
		return dataInicio_ano;
	}

	public int getDataTerminoPrevista_dia() {
		return dataTerminoPrevista_dia;
	}

	public int getDataTerminoPrevista_mes() {
		return dataTerminoPrevista_mes;
	}

	public int getDataTerminoPrevista_ano() {
		return dataTerminoPrevista_ano;
	}

	public StatusProjeto getStatus() {
		return status;
	}

	public Usuario getGerenteResponsavel() {
		return gerenteResponsavel;
	}
}
