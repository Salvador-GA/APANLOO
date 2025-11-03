import javax.swing.*;

/**
 * Arranque de la app:
 * - Establece Look & Feel (opcional).
 * - Crea Modelo, Vista y Controlador.
 * - Muestra la Vista en el EDT (Event Dispatch Thread).
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Look & Feel nativo del SO (opcional): mejora integración visual.
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignore) {}

            Contador modelo = new Contador();          // Estado y reglas
            ContadorVista vista = new ContadorVista(); // Interfaz de usuario (sin lógica)
            new ContadorControlador(modelo, vista);    // Conecta ambos

            vista.setVisible(true); // Mostrar al final, ya con listeners conectados
        });
    }
}


