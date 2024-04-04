package SimpleGUI;

import java.awt.*;
import java.awt.event.*;

/**
 * Una ventana, centrada en la pantalla y que termina la aplicación al cerrarse
 * que contiene dos botones y una etiqueta
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class VentanaConElementos extends Frame {
    Label valueLabel;
    Button incrementButton;
    Button resetButton;

    /**
     * Constructor de la clase
     */
    public VentanaConElementos() {
        super("Un incrementador");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evento) {
                System.exit(0);
            }
        });
        initialize();
    }

    /**
     * Inicializa los componentes gráficos de la ventana
     */
    private void initialize() {
        setSize(250, 100);
        this.setLayout(null);
        incrementButton = new Button("Incrementar");
        incrementButton.setBounds(30, 40, 85, 25);
        add(incrementButton);
        resetButton = new Button("Reiniciar");
        resetButton.setBounds(135, 40, 85, 25);
        add(resetButton);
        valueLabel = new Label("0", Label.CENTER);
        valueLabel.setBounds(100, 70, 50, 25);
        add(valueLabel);
        center();
        setVisible(true);
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
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    public static void main(String[] args) {
        new VentanaConElementos();
    }
}
