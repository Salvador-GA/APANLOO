import javax.swing.*;

/** Punto de entrada. Fija L&F y lanza el login en el EDT. */
public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignore) {}
            new LoginFrame();
        });
    }
}