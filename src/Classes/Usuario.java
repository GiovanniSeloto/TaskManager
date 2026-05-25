package Classes;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private String nome;
    private String CPF;
    private String email;
    private String cargo;
    private String login;
    private String senha;
    private PerfilUsuarios perfil;

    public Usuario(String nome, String CPF, String email, String cargo, String login, String senha, PerfilUsuarios perfil) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        
        /*System.out.println(	this.nome
        					+ "   " + this.CPF
        					+ "   " + this.email
        					+ "   " + this.cargo
        					+ "   " + this.login
        					+ "   " + this.senha
        					+ "   " + this.perfil);*/
    }
    
    public String getNomeUsuario() {
    	return this.nome;
    }
    
    public String getCPFUsuario() {
    	return this.CPF;
    }

	public String getEmailUsuario() {
		return email;
	}

	public String getCargoUsuario() {
		return cargo;
	}

	public String getLoginUsuario() {
		return login;
	}

	public String getSenhaUsuario() {
		return senha;
	}

	public PerfilUsuarios getPerfil() {
		return perfil;
	}
    
    
}
