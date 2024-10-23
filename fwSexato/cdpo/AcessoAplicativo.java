
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AcessoAplicativo extends JFrame implements ActionListener {
    // Componentes da GUI
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JButton confirmarButton, cancelarButton;
    
    // Credenciais de login
    private final String USUARIO_CORRETO = "denys.silva";
    private final String SENHA_CORRETA = "Teste@2024";

    // Construtor da classe
    public AcessoAplicativo() {
        // Configuração da janela
        setTitle("Acesso ao aplicativo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Painel para os campos de usuário e senha
        JPanel painel = new JPanel(new GridLayout(3, 2));
        
        // Adicionando componentes ao painel
        painel.add(new JLabel("Usuário:"));
        usuarioField = new JTextField(15);
        painel.add(usuarioField);
        
        painel.add(new JLabel("Senha:"));
        senhaField = new JPasswordField(15);
        painel.add(senhaField);
        
        // Botões Confirmar e Cancelar
        cancelarButton = new JButton("Cancelar");
        confirmarButton = new JButton("Confirmar");
        painel.add(cancelarButton);
        painel.add(confirmarButton);
        
        
        // Adicionando painel à janela
        add(painel);
        
        // Associando os botões aos eventos
        confirmarButton.addActionListener(this);
        cancelarButton.addActionListener(this);
    }

    // Método responsável por tratar os eventos dos botões
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmarButton) {
            String usuario = usuarioField.getText();
            String senha = new String(senhaField.getPassword());

            // Verifica as credenciais
            if (usuario.equals(USUARIO_CORRETO) && senha.equals(SENHA_CORRETA)) {
                JOptionPane.showMessageDialog(this, "Acesso confirmado!");
                dispose(); // Fecha a janela
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválido.");
            }
        } else if (e.getSource() == cancelarButton) {
            dispose(); // Fecha a janela
        }
    }

    // Método principal para execução
    public static void main(String[] args) {
        // Executa o programa e mostra a janela
        SwingUtilities.invokeLater(() -> {
            AcessoAplicativo frame = new AcessoAplicativo();
            frame.setVisible(true);
        });
    }
}
