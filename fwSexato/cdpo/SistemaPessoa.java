import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

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
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Adiciona o menu
        setJMenuBar(new MenuPrincipal(this));

        // Adiciona o rodapé
        JLabel rotuloRodape = new JLabel("Versão: 12.1.2024  Usuário: denys.silva  Data de acesso: 20/09/2024 10:58");
        rotuloRodape.setHorizontalAlignment(SwingConstants.CENTER);
        add(rotuloRodape, BorderLayout.SOUTH);
    }
}

class MenuPrincipal extends JMenuBar {
    private JanelaPrincipal janela;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public MenuPrincipal(JanelaPrincipal janela) {
        this.janela = janela;

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuItemUsuarios = new JMenuItem("Cadastro de Usuários");
        JMenuItem menuItemPessoas = new JMenuItem("Cadastro de Pessoas");
        menuCadastro.add(menuItemUsuarios);
        menuCadastro.add(menuItemPessoas);
        add(menuCadastro);

        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem menuItemListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(menuItemListaPessoas);
        add(menuVisualizacao);

        JMenu menuSair = new JMenu("Sair");
        JMenuItem menuItemSair = new JMenuItem("Sair");
        menuSair.add(menuItemSair);
        add(menuSair);

        // Adiciona listeners
        menuItemUsuarios.addActionListener(e -> abrirCadastroUsuarios());
        menuItemPessoas.addActionListener(e -> abrirCadastroPessoas());
        menuItemListaPessoas.addActionListener(e -> visualizarPessoas());
        menuItemSair.addActionListener(e -> System.exit(0));
    }

    private void abrirCadastroUsuarios() {
        new JanelaCadastroUsuarios(usuarios).setVisible(true);
    }

    private void abrirCadastroPessoas() {
        JOptionPane.showMessageDialog(janela, "Cadastro de Pessoas em desenvolvimento.");
    }

    private void visualizarPessoas() {
        JOptionPane.showMessageDialog(janela, "Visualização de Pessoas em desenvolvimento.");
    }
}

class JanelaCadastroUsuarios extends JFrame {
    private ArrayList<Usuario> usuarios;
    private JTextField nomeField, emailField;
    private JPasswordField senhaField;
    private JCheckBox checkAtivo;
    private JButton botaoIncluir, botaoAlterar, botaoExcluir, botaoConsultar, botaoCancelar, botaoSair;
    private int usuarioSelecionado = -1;

    public JanelaCadastroUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
        setTitle("Cadastro de Usuários");
        setSize(550, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Dados do Usuário"));
        panel.setBackground(new Color(240, 240, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Nome
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        nomeField = new JTextField(20);
        panel.add(nomeField, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // Senha
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        senhaField = new JPasswordField(20);
        panel.add(senhaField, gbc);

        // Checkbox Ativo
        gbc.gridx = 0; gbc.gridy = 3;
        checkAtivo = new JCheckBox("Ativo");
        panel.add(checkAtivo, gbc);

        // Painel de Botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        botaoIncluir = new JButton("Incluir");
        botaoAlterar = new JButton("Alterar");
        botaoExcluir = new JButton("Excluir");
        botaoConsultar = new JButton("Consultar");
        botaoCancelar = new JButton("Cancelar");
        botaoSair = new JButton("Sair");

        buttonPanel.add(botaoIncluir);
        buttonPanel.add(botaoAlterar);
        buttonPanel.add(botaoExcluir);
        buttonPanel.add(botaoConsultar);
        buttonPanel.add(botaoCancelar);
        buttonPanel.add(botaoSair);

        // Ações dos botões
        botaoIncluir.addActionListener(e -> incluirUsuario());
        botaoAlterar.addActionListener(e -> alterarUsuario());
        botaoExcluir.addActionListener(e -> excluirUsuario());
        botaoConsultar.addActionListener(e -> consultarUsuario());
        botaoCancelar.addActionListener(e -> limparCampos());
        botaoSair.addActionListener(e -> dispose());

        // Adiciona tudo à janela
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void incluirUsuario() {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String senha = new String(senhaField.getPassword());
        boolean ativo = checkAtivo.isSelected();
        usuarios.add(new Usuario(nome, email, senha, ativo));
        JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
        limparCampos();
    }

    private void alterarUsuario() {
        if (usuarioSelecionado >= 0) {
            String nome = nomeField.getText();
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());
            boolean ativo = checkAtivo.isSelected();
            usuarios.get(usuarioSelecionado).setNome(nome);
            usuarios.get(usuarioSelecionado).setEmail(email);
            usuarios.get(usuarioSelecionado).setSenha(senha);
            usuarios.get(usuarioSelecionado).setAtivo(ativo);
            JOptionPane.showMessageDialog(this, "Usuário alterado com sucesso!");
            limparCampos();
            usuarioSelecionado = -1;
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum usuário selecionado para alteração.");
        }
    }

    private void excluirUsuario() {
        if (usuarioSelecionado >= 0) {
            usuarios.remove(usuarioSelecionado);
            JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso!");
            limparCampos();
            usuarioSelecionado = -1;
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum usuário selecionado para exclusão.");
        }
    }

    private void consultarUsuario() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do usuário para consultar:");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                usuarioSelecionado = i;
                nomeField.setText(usuario.getNome());
                emailField.setText(usuario.getEmail());
                senhaField.setText(usuario.getSenha());
                checkAtivo.setSelected(usuario.isAtivo());
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Usuário não encontrado.");
    }

    private void limparCampos() {
        nomeField.setText("");
        emailField.setText("");
        senhaField.setText("");
        checkAtivo.setSelected(false);
    }
}

class Usuario {
    private String nome;
    private String email;
    private String senha;
    private boolean ativo;

    public Usuario(String nome, String email, String senha, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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
