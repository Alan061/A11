public class Pessoa {
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String email;
    private String telefone;
    private String sexo;

    public Pessoa(String nome, String endereco, String cidade, String uf, String email, String telefone, String sexo) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cidade: " + cidade + ", UF: " + uf + ", Email: " + email + ", Telefone: "
                + telefone;
    }
}
