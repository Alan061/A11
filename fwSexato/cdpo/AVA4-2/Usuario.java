public class Usuario {
    private String nomeUsuario;
    private String senha;
    private String email;
    private boolean ativo;

    public Usuario(String nomeUsuario, String senha, String email, boolean ativo) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.email = email;
        this.ativo = ativo;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return "Usuário: " + nomeUsuario + ", Email: " + email + ", Ativo: " + ativo;
    }
}
