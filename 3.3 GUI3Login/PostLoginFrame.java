import javax.swing.*;
import java.awt.*;

/**
 * Ventana simple que se muestra tras un login correcto.
 * (Puedes reemplazarla por tu “ventana principal” real.)
 */
public class PostLoginFrame extends JFrame {
    public PostLoginFrame(String usuario) {
        super("Bienvenido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Contenido minimalista
        var label = new JLabel("Sesión iniciada como: " + usuario, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 16f));
        var panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        setContentPane(panel);
        setMinimumSize(new Dimension(360, 160));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}