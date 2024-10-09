import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Cardapio {

    private static List<String[]> produtos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Cardapio().criarTelaInicial());
    }

    public void criarTelaInicial() {
        JFrame frame = new JFrame("Sistema de Cardápio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(0, 1));

        JButton btnCadastroProdutos = new JButton("Cadastro de Produtos");
        JButton btnCardapio = new JButton("Visualizar Cardápio");
        JButton btnCadastroClientes = new JButton("Cadastro de Clientes");
        JButton btnAlterarProduto = new JButton("Alterar Produto");
        JButton btnExcluirProduto = new JButton("Excluir Produto");
        JButton btnAlterarCliente = new JButton("Alterar Cliente");
        JButton btnExcluirCliente = new JButton("Excluir Cliente");
        JButton btnConsultarClientes = new JButton("Consultar Clientes");
        JButton btnSair = new JButton("Sair");

        btnCadastroProdutos.addActionListener(e -> telaCadastroProduto());
        btnCardapio.addActionListener(e -> visualizarCardapio());
        btnCadastroClientes.addActionListener(e -> telaCadastroCliente());
        btnAlterarProduto.addActionListener(e -> alterarProduto());
        btnExcluirProduto.addActionListener(e -> excluirProduto());
        btnAlterarCliente.addActionListener(e -> alterarCliente());
        btnExcluirCliente.addActionListener(e -> excluirCliente());
        btnConsultarClientes.addActionListener(e -> consultarClientes());
        btnSair.addActionListener(e -> System.exit(0));

        frame.add(btnCadastroProdutos);
        frame.add(btnCardapio);
        frame.add(btnCadastroClientes);
        frame.add(btnAlterarProduto);
        frame.add(btnExcluirProduto);
        frame.add(btnAlterarCliente);
        frame.add(btnExcluirCliente);
        frame.add(btnConsultarClientes);
        frame.add(btnSair);

        frame.setVisible(true);
    }

    public void telaCadastroProduto() {
        JFrame cadastroFrame = new JFrame("Cadastro de Produtos");
        cadastroFrame.setSize(300, 200);
        cadastroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtCodigo = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtPreco = new JTextField();

        cadastroFrame.add(new JLabel("Código:"));
        cadastroFrame.add(txtCodigo);
        cadastroFrame.add(new JLabel("Nome:"));
        cadastroFrame.add(txtNome);
        cadastroFrame.add(new JLabel("Preço:"));
        cadastroFrame.add(txtPreco);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            String codigo = txtCodigo.getText();
            String nome = txtNome.getText().toUpperCase();
            String preco = txtPreco.getText();

            if (codigo.matches("[a-zA-Z0-9]{6}") && nome.matches("[a-zA-Z0-9 ]{3,60}") && preco.matches("[0-9]+(\\.[0-9]{1,2})?")) {
                String[] produto = {codigo, nome, preco, "True"};
                produtos.add(produto);
                JOptionPane.showMessageDialog(cadastroFrame, "Produto cadastrado com sucesso!");
                cadastroFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(cadastroFrame, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        cadastroFrame.add(btnSalvar);
        cadastroFrame.setVisible(true);
    }

    public void visualizarCardapio() {
        JFrame cardapioFrame = new JFrame("Cardápio");
        cardapioFrame.setSize(400, 300);
        cardapioFrame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        StringBuilder sb = new StringBuilder();
        sb.append("CÓDIGO\tPRODUTO\t\tVALOR\n");
        sb.append("-----------------------------------------------------\n");

        for (String[] produto : produtos) {
            if (produto[3].equals("True")) {
                sb.append(String.format("%-12s %-30s %.2f%n", produto[0], produto[1], Double.parseDouble(produto[2])));
            }
        }

        textArea.setText(sb.toString());
        cardapioFrame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        cardapioFrame.setVisible(true);
    }

    public void telaCadastroCliente() {
        JFrame cadastroFrame = new JFrame("Cadastro de Clientes");
        cadastroFrame.setSize(300, 300);
        cadastroFrame.setLayout(new GridLayout(0, 2));

        JTextField txtNome = new JTextField();
        JTextField txtCpf = new JTextField();
        JTextField txtLogradouro = new JTextField();
        JTextField txtNumero = new JTextField();
        JTextField txtComplemento = new JTextField();
        JTextField txtBairro = new JTextField();
        JTextField txtCidade = new JTextField();
        JTextField txtCep = new JTextField();
        JTextField txtEstado = new JTextField();
        JTextField txtSexo = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtNascimento = new JTextField();

        cadastroFrame.add(new JLabel("Nome:"));
        cadastroFrame.add(txtNome);
        cadastroFrame.add(new JLabel("CPF:"));
        cadastroFrame.add(txtCpf);
        cadastroFrame.add(new JLabel("Logradouro:"));
        cadastroFrame.add(txtLogradouro);
        cadastroFrame.add(new JLabel("Número:"));
        cadastroFrame.add(txtNumero);
        cadastroFrame.add(new JLabel("Complemento:"));
        cadastroFrame.add(txtComplemento);
        cadastroFrame.add(new JLabel("Bairro:"));
        cadastroFrame.add(txtBairro);
        cadastroFrame.add(new JLabel("Cidade:"));
        cadastroFrame.add(txtCidade);
        cadastroFrame.add(new JLabel("CEP:"));
        cadastroFrame.add(txtCep);
        cadastroFrame.add(new JLabel("Estado:"));
        cadastroFrame.add(txtEstado);
        cadastroFrame.add(new JLabel("Sexo (M/F):"));
        cadastroFrame.add(txtSexo);
        cadastroFrame.add(new JLabel("Telefone:"));
        cadastroFrame.add(txtTelefone);
        cadastroFrame.add(new JLabel("Nascimento (DD/MM/AAAA):"));
        cadastroFrame.add(txtNascimento);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText().toUpperCase();
            String cpf = txtCpf.getText();
            String logradouro = txtLogradouro.getText();
            String numero = txtNumero.getText();
            String complemento = txtComplemento.getText();
            String bairro = txtBairro.getText();
            String cidade = txtCidade.getText();
            String cep = txtCep.getText();
            String estado = txtEstado.getText();
            String sexo = txtSexo.getText().toUpperCase();
            String telefone = txtTelefone.getText();
            String nascimento = txtNascimento.getText();

            Cliente cliente = new Cliente(nome, cpf, logradouro, numero, complemento, bairro, cidade, cep, estado, sexo, telefone, nascimento, true);
            clientes.add(cliente);
            JOptionPane.showMessageDialog(cadastroFrame, "Cliente cadastrado com sucesso!");
            cadastroFrame.dispose();
        });

        cadastroFrame.add(btnSalvar);
        cadastroFrame.setVisible(true);
    }

    public void alterarProduto() {
        String codigo = JOptionPane.showInputDialog("Digite o código do produto que deseja alterar:");
        for (String[] produto : produtos) {
            if (produto[0].equals(codigo)) {
                String novoNome = JOptionPane.showInputDialog("Novo Nome:", produto[1]);
                String novoPreco = JOptionPane.showInputDialog("Novo Preço:", produto[2]);
                produto[1] = novoNome.toUpperCase();
                produto[2] = novoPreco;
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado.");
    }

    public void excluirProduto() {
        String codigo = JOptionPane.showInputDialog("Digite o código do produto que deseja excluir:");
        for (String[] produto : produtos) {
            if (produto[0].equals(codigo)) {
                produtos.remove(produto);
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado.");
    }

    public void alterarCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente que deseja alterar:");
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                String novoNome = JOptionPane.showInputDialog("Novo Nome:", cliente.getNome());
                cliente.nome = novoNome.toUpperCase();
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
    }

    public void excluirCliente() {
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente que deseja excluir:");
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                clientes.remove(cliente);
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
    }

    public void consultarClientes() {
        StringBuilder sb = new StringBuilder("Clientes cadastrados:\n");
        for (Cliente cliente : clientes) {
            sb.append(cliente.getNome()).append(" - ").append(cliente.getCpf()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Consulta de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }

    // Classe Cliente
    public static class Cliente {
        private String nome;
        private String cpf;
        private String logradouro;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String cep;
        private String estado;
        private String sexo;
        private String telefone;
        private String nascimento;
        private boolean autorizado;

        public Cliente(String nome, String cpf, String logradouro, String numero, String complemento,
                       String bairro, String cidade, String cep, String estado, String sexo,
                       String telefone, String nascimento, boolean autorizado) {
            this.nome = nome;
            this.cpf = cpf;
            this.logradouro = logradouro;
            this.numero = numero;
            this.complemento = complemento;
            this.bairro = bairro;
            this.cidade = cidade;
            this.cep = cep;
            this.estado = estado;
            this.sexo = sexo;
            this.telefone = telefone;
            this.nascimento = nascimento;
            this.autorizado = autorizado;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "nome='" + nome + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", logradouro='" + logradouro + '\'' +
                    ", numero='" + numero + '\'' +
                    ", complemento='" + complemento + '\'' +
                    ", bairro='" + bairro + '\'' +
                    ", cidade='" + cidade + '\'' +
                    ", cep='" + cep + '\'' +
                    ", estado='" + estado + '\'' +
                    ", sexo='" + sexo + '\'' +
                    ", telefone='" + telefone + '\'' +
                    ", nascimento='" + nascimento + '\'' +
                    ", autorizado=" + autorizado +
                    '}';
        }
    }
}
