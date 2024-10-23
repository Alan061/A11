import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SistemaPessoa {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaPrincipal janela = new JanelaPrincipal();
            janela.setVisible(true);
        });
    }
}

class JanelaPrincipal extends JFrame {
    public JanelaPrincipal() {
        setTitle("Sistema de Pessoa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Adiciona o menu
        setJMenuBar(new MenuPrincipal(this));

        // Adiciona o rodapé
        JLabel rotuloRodape = new JLabel("Versão: 12.1.2024  Usuário: denys.silva  Data de acesso: 20/09/2024 10:58");
        add(rotuloRodape, BorderLayout.SOUTH);
    }
}

class MenuPrincipal extends JMenuBar {
    private JanelaPrincipal janela;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public MenuPrincipal(JanelaPrincipal janela) {
        this.janela = janela;

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuItemUsuarios = new JMenuItem("Usuários");
        JMenuItem menuItemPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(menuItemUsuarios);
        menuCadastro.add(menuItemPessoas);
        add(menuCadastro);

        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem menuItemListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem menuItemListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(menuItemListaUsuarios);
        menuVisualizacao.add(menuItemListaPessoas);
        add(menuVisualizacao);

        JMenu menuSair = new JMenu("Sair");
        JMenuItem menuItemSair = new JMenuItem("Sair");
        menuSair.add(menuItemSair);
        add(menuSair);

        // Adiciona listeners
        menuItemUsuarios.addActionListener(e -> abrirCadastroUsuarios());
        menuItemPessoas.addActionListener(e -> abrirCadastroPessoas());
        menuItemListaUsuarios.addActionListener(e -> visualizarUsuarios());
        menuItemListaPessoas.addActionListener(e -> visualizarPessoas());
        menuItemSair.addActionListener(e -> System.exit(0));
    }

    private void abrirCadastroUsuarios() {
        JTextField nomeField = new JTextField();
        JTextField emailField = new JTextField();
        Object[] message = {
            "Nome:", nomeField,
            "Email:", emailField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de Usuário", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String email = emailField.getText();
            usuarios.add(new Usuario(nome, email));
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        }
    }

    private void abrirCadastroPessoas() {
        JTextField nomeField = new JTextField();
        JTextField idadeField = new JTextField();
        Object[] message = {
            "Nome:", nomeField,
            "Idade:", idadeField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Cadastro de Pessoa", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            pessoas.add(new Pessoa(nome, idade));
            JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
        }
    }

    private void visualizarUsuarios() {
        StringBuilder lista = new StringBuilder("Usuários:\n");
        for (Usuario usuario : usuarios) {
            lista.append(usuario.getNome()).append(" - ").append(usuario.getEmail()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Usuários", JOptionPane.INFORMATION_MESSAGE);
    }

    private void visualizarPessoas() {
        StringBuilder lista = new StringBuilder("Pessoas:\n");
        for (Pessoa pessoa : pessoas) {
            lista.append(pessoa.getNome()).append(" - ").append(pessoa.getIdade()).append(" anos\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Pessoas", JOptionPane.INFORMATION_MESSAGE);
    }
}

class Usuario {
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
