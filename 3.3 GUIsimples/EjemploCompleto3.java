package SimpleGUI;

import java.awt.*;
import java.awt.event.*;

/**
 * Una ventana, centrada en la pantalla y que termina la aplicación al cerrarse
 * que contiene dos cajas de texto, tres etiquetas y realiza una accion al
 * presionar un boton
 * 
 * @author Salvador Gonzalez Arellano
 * @version 2.0
 */
public class EjemploCompleto3 extends Frame implements ActionListener {
    Label mensajeLabel;
    Label usuarioLabel;
    TextField usuarioText;
    Label passLabel;
    TextField passText;
    Button loginButton;

    /**
     * Constructor de la clase
     */
    public EjemploCompleto3() {
        super("Login");
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

        usuarioLabel = new Label("Usuario:", Label.RIGHT);
        usuarioLabel.setBounds(10, 40, 80, 25);
        add(usuarioLabel);

        usuarioText = new TextField(50);
        usuarioText.setBounds(95, 38, 195, 24);
        usuarioText.addActionListener(this);
        add(usuarioText);

        passLabel = new Label("Contraseña:", Label.RIGHT);
        passLabel.setBounds(10, 80, 80, 25);
        add(passLabel);

        passText = new TextField(50);
        passText.setBounds(95, 78, 195, 24);
        passText.setEchoChar('*');
        passText.addActionListener(this);
        add(passText);

        loginButton = new Button("Login");
        loginButton.setBounds(110, 115, 80, 25);
        // Registra la instancia de esta/this clase como listener
        loginButton.addActionListener(this);
        add(loginButton);

        mensajeLabel = new Label("", Label.CENTER);
        mensajeLabel.setBounds(10, 150, 280, 25);
        add(mensajeLabel);

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
        String usuario = usuarioText.getText();
        String pass = passText.getText();
        if (usuario.equals("admin") && pass.equals("admin")) {
            mensajeLabel.setText("Login correcto, bienvenido " + usuario);
            this.setVisible(false);
            new EjemploCompleto1();
        } else {
            mensajeLabel.setText("Login incorrecto verifique los datos");
        }
    }

    public static void main(String[] args) {
        new EjemploCompleto3();
    }
}
