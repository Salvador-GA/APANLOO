package EnfoqueHerenciaMVC;

import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;

/**
 * Clase ContadorVista que representa la vista en el patrón MVC.
 * Muestra el valor actual del contador y se actualiza cuando el modelo cambia.
 * 
 * La clase Observer está marcado como obsoleto (deprecated) en las versiones
 * recientes de Java, lo cual indica que esta clase y sus métodos no son
 * recomendados para el desarrollo de nuevas aplicaciones. La API de Observable
 * y Observer ha sido reemplazada en Java por una arquitectura de eventos basada
 * en PropertyChangeListener y PropertyChangeSupport, que ofrece más
 * flexibilidad y es más fácil de mantener.
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class ContadorVista extends Frame implements ActionListener, Observer {
    private Label label;

    /**
     * Constructor que inicializa la interfaz gráfica de la vista.
     */
    public ContadorVista() {
        Frame frame = new Frame("Contador MVC");
        frame.setSize(300, 100);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

        Panel panel = new Panel();
        label = new Label("Valor del contador: 0");
        panel.add(label);
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Método llamado cuando el modelo cambia, actualizando el valor mostrado en la vista.
     * 
     * @param o el objeto Observable
     * @param arg el nuevo valor del contador
     */
    public void update(Observable o, Object arg) {
        label.setText("Valor del contador: " + arg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}