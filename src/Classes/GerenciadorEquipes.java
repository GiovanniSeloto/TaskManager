package Classes;

import java.util.List;

public class GerenciadorEquipes {
	private static BancoDadosEquipe bdEquipe;
	private static BancoDadosUsuario bdUsuario;
	
	public GerenciadorEquipes() {
		if (bdEquipe == null) {
			bdEquipe = new BancoDadosEquipe();
		}
		if (bdUsuario == null) {
			bdUsuario = new BancoDadosUsuario();
		}
	}
	
	public void Criar(String nome, String descricao, List<Usuario> membros) {
		Equipe novaEquipe = new Equipe(nome, descricao, membros);
    	bdEquipe.escreverArquivoData(novaEquipe);
    }

    public void Alterar(Equipe equipe, Equipe equipeAlterado) {
    	bdEquipe.alterarEquipeData(equipe, equipeAlterado);
    }

    public void Deletar(String equipeDeletar) {
    	if(equipeDeletar != null) {
    		Equipe aux = bdEquipe.retornarEquipePeloNome(equipeDeletar);
        	if(aux != null) {
        		bdEquipe.removerEquipeData(aux);
        	}        	
    	}
    }
    
    public List<Usuario> retornoTodosUsuarios(){
    	return bdUsuario.leituraBancoDados();
    }
    
    public Usuario retornoUsuarioNome(String nome) {
    	return bdUsuario.retornarUsuarioPeloNome(nome);
    }
    
    public Equipe retornoEquipeNome(String nome) {
    	return bdEquipe.retornarEquipePeloNome(nome);
    }
    public List<Equipe> retornoTodasEquipes(){
    	return bdEquipe.leituraBancoDados();
    }
}
