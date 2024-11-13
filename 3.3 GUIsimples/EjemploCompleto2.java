package SimpleGUI;

import java.awt.*;
import java.awt.event.*;

/**
 * Una ventana, centrada en la pantalla y que termina la aplicación al cerrarse
 * que contiene dos cajas de texto, tres etiquetas y realiza una accion al
 * presionar un boton
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class EjemploCompleto2 extends Frame implements ActionListener {
    Label saludoLabel;
    Label nombreLabel;
    TextField nombreText;
    Label apellidosLabel;
    TextField apellidosText;
    Button saludoButton;

    /**
     * Constructor de la clase
     */
    public EjemploCompleto2() {
        super("Ventana que da un saludo");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evento) {
                System.exit(0);
            }
        });
        inicializar();
    }

    /**
     * Inicializa los componentes gráficos de la ventana y agrega el
     * ActionListener al boton
     */
    private void inicializar() {
        setSize(300, 200);
        setLayout(null);

        nombreLabel = new Label("Nombre:", Label.RIGHT);
        nombreLabel.setBounds(10, 40, 70, 25);
        add(nombreLabel);

        nombreText = new TextField(50);
        nombreText.setBounds(85, 38, 200, 24);
        add(nombreText);

        apellidosLabel = new Label("Apellidos:", Label.RIGHT);
        apellidosLabel.setBounds(10, 80, 70, 25);
        add(apellidosLabel);

        apellidosText = new TextField(50);
        apellidosText.setBounds(85, 78, 200, 24);
        add(apellidosText);

        saludoButton = new Button("Saludar");
        saludoButton.setBounds(110, 115, 80, 25);
        // Registra la instancia de esta/this clase como listener
        saludoButton.addActionListener(this);
        add(saludoButton);

        saludoLabel = new Label("Esperando nombre...", Label.CENTER);
        saludoLabel.setBounds(10, 150, 280, 25);
        add(saludoLabel);

        centrar();
        setVisible(true);
    }

    /**
     * Centra la ventana con respecto a las dimesiones de la pantalla
     */
    public void centrar() {
        Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamVentana = this.getSize();
        // Se ajusta el tamaño de la ventana, si es mayor al de la pantalla
        if (tamVentana.height > tamPantalla.height)
            tamVentana.height = tamPantalla.height;
        if (tamVentana.width > tamPantalla.width)
            tamVentana.width = tamPantalla.width;
        // Se centra la ventana
        this.setLocation((tamPantalla.width - tamVentana.width) / 2,
                (tamPantalla.height - tamVentana.height) / 2);
    }

    /**
     * Concatena los valores de las cajas de texto y muestra un saludo en la
     * etiqueta
     * 
     * @param evento
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        String nombre = nombreText.getText();
        String apellidos = apellidosText.getText();
        saludoLabel.setText("Hola " + nombre + " " + apellidos + "!");
    }

    public static void main(String[] args) {
        new EjemploCompleto2();
    }
}
