import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastroPessoas {
    private final JFrame principal;

    public CadastroPessoas(JFrame principal) {
        this.principal = principal;
    }

    // Método original
    public void exibir() {
        exibir("Cadastro de Pessoas");
    }

    // Método sobrecarregado
    public void exibir(String titulo) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel(titulo, SwingConstants.CENTER);
        dialog.add(tituloLabel, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(new JTextField(60));
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("UF:"));
        painelCampos.add(new JTextField(2));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(new JTextField(20));
        painelCampos.add(new JLabel("Sexo:"));
        painelCampos.add(new JComboBox<>(new String[] { "Masculino", "Feminino" }));

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
