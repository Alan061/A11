import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroPessoas {
    private List<Pessoa> pessoas;

    public CadastroPessoas() {
        pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, String endereco, String cidade, String uf, String email, String telefone,
            String sexo) {
        Pessoa pessoa = new Pessoa(nome, endereco, cidade, uf, email, telefone, sexo);
        pessoas.add(pessoa);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void exibirListaPessoas() {
        StringBuilder lista = new StringBuilder();
        for (Pessoa pessoa : pessoas) {
            lista.append(pessoa.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Pessoas", JOptionPane.INFORMATION_MESSAGE);
    }
}
