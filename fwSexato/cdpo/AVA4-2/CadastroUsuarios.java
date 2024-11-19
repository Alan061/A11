import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CadastroUsuarios {
    private List<Usuario> usuarios;

    public CadastroUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(String nomeUsuario, String senha, String email, boolean ativo) {
        Usuario usuario = new Usuario(nomeUsuario, senha, email, ativo);
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void exibirListaUsuarios() {
        StringBuilder lista = new StringBuilder();
        for (Usuario usuario : usuarios) {
            lista.append(usuario.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Usuários", JOptionPane.INFORMATION_MESSAGE);
    }
}
