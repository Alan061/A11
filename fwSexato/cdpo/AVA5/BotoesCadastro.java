import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BotoesCadastro {
    private final JDialog dialog;

    public BotoesCadastro(JDialog dialog) {
        this.dialog = dialog;
    }

    // Método original
    public JPanel criar() {
        return criar(new String[] { "Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair" });
    }

    // Método sobrecarregado
    public JPanel criar(String[] labels) {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        for (String label : labels) {
            JButton button = new JButton(label);
            if ("Sair".equals(label)) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}
