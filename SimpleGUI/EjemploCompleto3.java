package SimpleGUI;

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
public class EjemploCompleto3 extends Frame implements ActionListener {
    Label helloLabel;
    Label userLabel;
    TextField userText;
    Label passLabel;
    TextField passText;
    Button helloButton;

    /**
     * Constructor de la clase
     */
    public EjemploCompleto3() {
        super("Login");
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
        userLabel = new Label("Usuario:", Label.RIGHT);
        userLabel.setBounds(10, 40, 80, 25);
        add(userLabel);
        userText = new TextField(50);
        userText.setBounds(95, 38, 195, 24);
        add(userText);
        passLabel = new Label("Contraseña:", Label.RIGHT);
        passLabel.setBounds(10, 80, 80, 25);
        add(passLabel);
        passText = new TextField(50);
        passText.setBounds(95, 78, 195, 24);
        passText.setEchoChar('*');
        add(passText);
        helloButton = new Button("Login");
        helloButton.setBounds(110, 115, 80, 25);
        // Registra la instancia de esta/this clase como listener
        helloButton.addActionListener(this);
        add(helloButton);
        helloLabel = new Label("", Label.CENTER);
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
        String user = userText.getText();
        String pass = passText.getText();
        if (user.equals("admin") && pass.equals("admin")) {
            helloLabel.setText("Login correcto, bienvenido " + user);
            this.setVisible(false);
            new EjemploCompleto1();
        } else {
            helloLabel.setText("Login incorrecto verifique los datos");
        }
    }

    public static void main(String[] args) {
        new EjemploCompleto3();
    }
}
