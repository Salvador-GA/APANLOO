package EnfoqueDelegacionMVC;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Clase ContadorVista que representa la vista en el patrón MVC.
 * Muestra el valor actual del contador y se actualiza automáticamente cuando el modelo cambia.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ContadorVista implements PropertyChangeListener {
    private Label label;

    /**
     * Constructor que inicializa la interfaz gráfica de la vista.
     */
    public ContadorVista() {
        Frame frame = new Frame("Contador MVC");
        frame.setSize(300, 100);
        frame.setLayout(null);

        Panel panel = new Panel();
        panel.setBounds(50, 30, 200, 40);
        label = new Label("Valor del contador: 0");

        panel.add(label);
        frame.add(panel);

        frame.setVisible(true);

        // Agregar ventana de cierre manual, ya que AWT no incluye setDefaultCloseOperation
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    /**
     * Método que se llama cuando el modelo cambia, actualizando el valor mostrado en la vista.
     * 
     * @param evt el evento de cambio de propiedad
     */
    public void propertyChange(PropertyChangeEvent evt) {
        label.setText("Valor del contador: " + evt.getNewValue());
    }
}
