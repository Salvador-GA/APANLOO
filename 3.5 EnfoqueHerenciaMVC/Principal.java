import javax.swing.*;

/**
 * Punto de entrada: fija (opcional) el Look&Feel y lanza la vista en el EDT.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Look & Feel nativo (opcional).
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignore) {}

            // Modelo
            Contador modelo = new Contador();

            // Vista (que también actúa como controlador por herencia)
            ContadorVista vista = new ContadorVista(modelo);

            // Muestra la ventana al final (ya configurada)
            vista.setVisible(true);
        });
    }
}
