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
import javax.swing.JComboBox;
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
    private ArrayList<Pessoa> pessoas;  // Adiciona a lista de pessoas

    public JanelaPrincipal() {
        this.pessoas = new ArrayList<>();  // Inicializa a lista de pessoas
        setTitle("Sistema de Pessoa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Adiciona o menu
        setJMenuBar(new MenuPrincipal(this, pessoas));

        // Adiciona o rodapé
        JLabel rotuloRodape = new JLabel("Versão: 12.1.2024  Usuário: denys.silva  Data de acesso: 20/09/2024 10:58");
        rotuloRodape.setHorizontalAlignment(SwingConstants.CENTER);
        add(rotuloRodape, BorderLayout.SOUTH);
    }
}


class MenuPrincipal extends JMenuBar {
    private JanelaPrincipal janela;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Pessoa> pessoas;  // Adiciona a lista de pessoas

    public MenuPrincipal(JanelaPrincipal janela, ArrayList<Pessoa> pessoas) {
        this.janela = janela;
        this.pessoas = pessoas;  // Recebe a lista de pessoas

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
        new JanelaCadastroPessoas(pessoas).setVisible(true);  // Abre a janela de cadastro de pessoas
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

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSexo() {
        return sexo;
    }
}

class JanelaCadastroPessoas extends JFrame {
    private ArrayList<Pessoa> pessoas;
    private JTextField nomeField, enderecoField, cidadeField, ufField, emailField, telefoneField;
    private JComboBox<String> sexoBox;
    private JButton botaoIncluir, botaoAlterar, botaoExcluir, botaoConsultar, botaoCancelar, botaoSair;
    private int pessoaSelecionada = -1;

    public JanelaCadastroPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
        setTitle("Cadastro de Pessoas");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Dados da Pessoa"));
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

        // Endereço
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Endereço:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        enderecoField = new JTextField(20);
        panel.add(enderecoField, gbc);

        // Cidade
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Cidade:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        cidadeField = new JTextField(20);
        panel.add(cidadeField, gbc);

        // UF
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("UF:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        ufField = new JTextField(2);
        panel.add(ufField, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);

        // Telefone
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        telefoneField = new JTextField(15);
        panel.add(telefoneField, gbc);

        // Sexo
        gbc.gridx = 0; gbc.gridy = 6;
        panel.add(new JLabel("Sexo:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6;
        sexoBox = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});
        panel.add(sexoBox, gbc);

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
        botaoIncluir.addActionListener(e -> incluirPessoa());
        botaoAlterar.addActionListener(e -> alterarPessoa());
        botaoExcluir.addActionListener(e -> excluirPessoa());
        botaoConsultar.addActionListener(e -> consultarPessoa());
        botaoCancelar.addActionListener(e -> limparCampos());
        botaoSair.addActionListener(e -> dispose());

        // Adiciona tudo à janela
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void incluirPessoa() {
        String nome = nomeField.getText();
        String endereco = enderecoField.getText();
        String cidade = cidadeField.getText();
        String uf = ufField.getText();
        String email = emailField.getText();
        String telefone = telefoneField.getText();
        String sexo = (String) sexoBox.getSelectedItem();
        pessoas.add(new Pessoa(nome, endereco, cidade, uf, email, telefone, sexo));
        JOptionPane.showMessageDialog(this, "Pessoa cadastrada com sucesso!");
        limparCampos();
    }

    private void alterarPessoa() {
        if (pessoaSelecionada >= 0) {
            String nome = nomeField.getText();
            String endereco = enderecoField.getText();
            String cidade = cidadeField.getText();
            String uf = ufField.getText();
            String email = emailField.getText();
            String telefone = telefoneField.getText();
            String sexo = (String) sexoBox.getSelectedItem();

            Pessoa pessoa = pessoas.get(pessoaSelecionada);
            pessoa.setNome(nome);
            pessoa.setEndereco(endereco);
            pessoa.setCidade(cidade);
            pessoa.setUf(uf);
            pessoa.setEmail(email);
            pessoa.setTelefone(telefone);
            pessoa.setSexo(sexo);
            JOptionPane.showMessageDialog(this, "Pessoa alterada com sucesso!");
            limparCampos();
            pessoaSelecionada = -1;
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma pessoa selecionada para alteração.");
        }
    }

    private void excluirPessoa() {
        if (pessoaSelecionada >= 0) {
            pessoas.remove(pessoaSelecionada);
            JOptionPane.showMessageDialog(this, "Pessoa excluída com sucesso!");
            limparCampos();
            pessoaSelecionada = -1;
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma pessoa selecionada para exclusão.");
        }
    }

    private void consultarPessoa() {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome da pessoa para consultar:");
        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                pessoaSelecionada = i;
                nomeField.setText(pessoa.getNome());
                enderecoField.setText(pessoa.getEndereco());
                cidadeField.setText(pessoa.getCidade());
                ufField.setText(pessoa.getUf());
                emailField.setText(pessoa.getEmail());
                telefoneField.setText(pessoa.getTelefone());
                sexoBox.setSelectedItem(pessoa.getSexo());
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Pessoa não encontrada.");
    }

    private void limparCampos() {
        nomeField.setText("");
        enderecoField.setText("");
        cidadeField.setText("");
        ufField.setText("");
        emailField.setText("");
        telefoneField.setText("");
        sexoBox.setSelectedIndex(0);
    }
}




