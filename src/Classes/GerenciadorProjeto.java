package Classes;

import java.util.List;

public class GerenciadorProjeto{
    
	private static BancoDadosProjeto bdProjeto;
	
	public GerenciadorProjeto() {
		if (bdProjeto == null) {
			bdProjeto = new BancoDadosProjeto();
		}
	}
	
	public void Criar(String nomeProjeto, String descricaoProjeto, int diaInicioProjeto, int mesInicioProjeto, int anoInicioProjeto,
			int diaTerminoProjeto, int mesTerminoProjeto, int anoTerminoProjeto, StatusProjeto statusProjeto, Usuario gerenteProjeto) {
		Projeto novoProjeto = new Projeto(nomeProjeto, descricaoProjeto, diaInicioProjeto, mesInicioProjeto, anoInicioProjeto, diaTerminoProjeto, mesTerminoProjeto, anoTerminoProjeto, statusProjeto, gerenteProjeto);
		bdProjeto.escreverArquivoData(novoProjeto);
    }

    public void Alterar(Projeto projetoAntigo, Projeto projetoNovo) {
    	bdProjeto.alterarUsuarioData(projetoAntigo, projetoNovo);
    }

    public void Deletar(String projetoDeletar) {
    	if(projetoDeletar != null) {
    		Projeto aux = bdProjeto.retornarUsuarioPeloNome(projetoDeletar);
        	if(aux != null) {
        		bdProjeto.removerProjetoData(aux);
        	}        	
    	}
    }
    
    public List<Usuario> retornarUsuariosGerente(){
    	return bdProjeto.retornarUsuariosGerente();
    }
    
    public List<Projeto> retornarTodosProjetos(){
    	return bdProjeto.retornarTodosProjetos();
    }
    
    public Projeto retornoProjetoNome(String nome) {
    	return bdProjeto.retornarProjetoPeloNome(nome);
    }
}
