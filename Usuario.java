public class Usuario {
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
    }
}
