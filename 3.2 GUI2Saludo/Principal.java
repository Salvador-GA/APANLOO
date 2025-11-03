import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Si no quieres el aspecto del sistema, puedes quitar esto o forzar "Nimbus".
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignore) {}

            new SaludoFrame();
        });
    }
}