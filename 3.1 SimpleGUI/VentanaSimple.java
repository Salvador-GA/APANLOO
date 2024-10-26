import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Una ventana, centrada en la pantalla y que termina la aplicación al cerrarse
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class VentanaSimple extends Frame {

    /**
     * Constructor de la clase
     */
    public VentanaSimple() {
        super("Una ventana simple"); // Crea la ventana con un titulo
        setSize(300, 200);
        // Se agrega el listener para el evento que ocurre al cerrar la ventana se
        // termine la aplicacion
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evento) {
                System.exit(0);
            }
        });
        center();
        setVisible(true); // Se hace visible la ventana
    }

    /**
     * Centra la ventana con respecto a las dimesiones de la pantalla
     */
    public void center() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        // Se ajusta el tamaño de la ventana, si es mayor al de la pantalla
        if (frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;
        if (frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;
        // Se centra la ventana
        this.setLocation((screenSize.width - frameSize.width) / 2, 
                         (screenSize.height - frameSize.height) / 2);
    }

    public static void main(String[] args) {
        new VentanaSimple();
    }
}
