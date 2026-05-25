package Classes;

import java.util.List;

public class GerenciadorUsuarios {

	private static BancoDadosUsuario bdUsuario;
	
	public GerenciadorUsuarios() {
		if (bdUsuario == null) {
			bdUsuario = new BancoDadosUsuario();
		}
	}
	
	public void Criar(String nome, String CPF, String email, String cargo, String login, String senha, PerfilUsuarios perfil) {
		Usuario novoUsuario = new Usuario(nome, CPF, email, cargo, login, senha, perfil);
    	bdUsuario.escreverArquivoData(novoUsuario);
    }

    public void Alterar(Usuario user, Usuario userAlterado) {
    	bdUsuario.alterarUsuarioData(user, userAlterado);
    }

    public void Deletar(String usuarioDeletar) {
    	if(usuarioDeletar != null) {
    		Usuario aux = bdUsuario.retornarUsuarioPeloNome(usuarioDeletar);
        	if(aux != null) {
        		bdUsuario.removerUsuarioData(aux);
        	}        	
    	}
    }
    
    public List<Usuario> retornoTodosUsuarios(){
    	return bdUsuario.leituraBancoDados();
    }
    
    public static Usuario retornoUsuarioNome(String nome) {
    	return bdUsuario.retornarUsuarioPeloNome(nome);
    }
}
