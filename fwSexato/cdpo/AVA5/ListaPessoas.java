import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ListaPessoas {
    private final JFrame principal;

    public ListaPessoas(JFrame principal) {
        this.principal = principal;
    }

    // Método original
    public void exibir() {
        exibir("Lista de Pessoas", "Exemplo de lista de pessoas...");
    }

    // Método sobrecarregado
    public void exibir(String titulo, String listaConteudo) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(750, 650);
        dialog.setLayout(new BorderLayout());

        dialog.add(new JLabel(titulo, SwingConstants.CENTER), BorderLayout.NORTH);
        dialog.add(new JTextArea(listaConteudo), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnFechar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
