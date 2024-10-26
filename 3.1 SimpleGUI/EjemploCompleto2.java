import java.awt.*;
import java.awt.event.*;

/**
 * Una ventana, centrada en la pantalla y que termina la aplicación al cerrarse
 * que contiene dos cajas de texto, tres etiquetas y realiza una accion al
 * presionar un boton
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class EjemploCompleto2 extends Frame implements ActionListener {
    Label helloLabel;
    Label nameLabel;
    TextField nameText;
    Label surnamesLabel;
    TextField surnamesText;
    Button helloButton;

    /**
     * Constructor de la clase
     */
    public EjemploCompleto2() {
        super("Ventana que saluda");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        initialize();
    }

    /**
     * Inicializa los componentes gráficos de la ventana y agrega el
     * ActionListener al boton
     */
    private void initialize() {
        setSize(300, 200);
        this.setLayout(null);
        nameLabel = new Label("Nombre:", Label.RIGHT);
        nameLabel.setBounds(10, 40, 70, 25);
        add(nameLabel);
        nameText = new TextField(50);
        nameText.setBounds(85, 38, 200, 24);
        add(nameText);
        surnamesLabel = new Label("Apellidos:", Label.RIGHT);
        surnamesLabel.setBounds(10, 80, 70, 25);
        add(surnamesLabel);
        surnamesText = new TextField(50);
        surnamesText.setBounds(85, 78, 200, 24);
        add(surnamesText);
        helloButton = new Button("Saludar");
        helloButton.setBounds(110, 115, 80, 25);
        // Registra la instancia de esta/this clase como listener
        helloButton.addActionListener(this);
        add(helloButton);
        helloLabel = new Label("Esperando nombre...", Label.CENTER);
        helloLabel.setBounds(10, 150, 280, 25);
        add(helloLabel);
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

    /**
     * Concatena los valores de las cajas de texto y muestra un saludo en la
     * etiqueta
     * 
     * @param evento
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        String name = nameText.getText();
        String surname = surnamesText.getText();
        helloLabel.setText("Hola " + name + " " + surname + "!");
    }

    public static void main(String[] args) {
        new EjemploCompleto2();
    }
}
