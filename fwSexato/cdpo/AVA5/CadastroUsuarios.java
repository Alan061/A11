import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastroUsuarios {
    private final JFrame principal;

    public CadastroUsuarios(JFrame principal) {
        this.principal = principal;
    }

    // Método original
    public void exibir() {
        exibir("Cadastro de Usuários");
    }

    // Método sobrecarregado
    public void exibir(String titulo) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel(titulo, SwingConstants.CENTER);
        dialog.add(tituloLabel, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        painelCampos.add(new JRadioButton());

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
