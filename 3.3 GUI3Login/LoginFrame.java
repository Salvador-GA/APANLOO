import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Ventana de Login (Swing):
 * - Usuario (JTextField) y contraseña (JPasswordField).
 * - Botón "Login" y etiqueta de mensaje.
 * - Acepta ENTER en los campos (botón por defecto).
 * - Si las credenciales son "admin"/"admin", muestra otra ventana y cierra esta.
 */
public class LoginFrame extends JFrame {
    // Etiquetas con alineación a la derecha para “pegarse” a los campos de la derecha.
    private final JLabel usuarioLabel = new JLabel("Usuario:",   SwingConstants.RIGHT);
    private final JLabel passLabel    = new JLabel("Contraseña:", SwingConstants.RIGHT);

    // JTextField: campo de texto normal.
    private final JTextField usuarioText = new JTextField(20);

    // JPasswordField: campo seguro que guarda internamente un char[] y enmascara con un eco.
    // Por defecto ya enmascara; podrías personalizar el eco con setEchoChar('*') si lo deseas.
    private final JPasswordField passText = new JPasswordField(20);

    private final JButton loginButton = new JButton("Login");

    // Etiqueta de mensajes al usuario (centrada y con letra un poco más notoria).
    private final JLabel mensajeLabel = new JLabel("", SwingConstants.CENTER);

    public LoginFrame() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(crearContenido()); // Construye el “formulario” con GridBagLayout.

        // IMPORTANTE: Establece un “botón por defecto” en el root pane.
        // Con esto, al presionar ENTER en cualquier campo de texto,
        // Swing invoca “doClick()” sobre este botón (UX más fluida).
        getRootPane().setDefaultButton(loginButton);

        pack();                    // Calcula tamaño ideal según el layout y contenido.
        setLocationRelativeTo(null); // Centra en la pantalla (monitor principal).
        setVisible(true);          // Muestra al final, cuando todo está listo.
    }

    private JPanel crearContenido() {
        JPanel root = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);         // Margen alrededor de cada control.
        gbc.fill = GridBagConstraints.HORIZONTAL;   // Por defecto, que los campos ocupen el ancho.

        // ---------- Fila 0: Usuario ----------
        gbc.gridy = 0;

        // Columna 0: etiqueta “Usuario:”
        gbc.gridx = 0; gbc.weightx = 0; // esta columna no crece
        root.add(usuarioLabel, gbc);

        // Columna 1: campo de texto
        gbc.gridx = 1; gbc.weightx = 1.0; // esta columna puede crecer
        root.add(usuarioText, gbc);

        // Además del “botón por defecto”, puedes hacer que ENTER en este campo dispare login:
        // Esto es útil si NO quieres “default button”, o si quieres lógica específica.
        usuarioText.addActionListener(this::hacerLogin); // ENTER en usuario → intentar login

        // ---------- Fila 1: Contraseña ----------
        gbc.gridy = 1;

        // Columna 0: etiqueta “Contraseña:”
        gbc.gridx = 0; gbc.weightx = 0;
        root.add(passLabel, gbc);

        // Columna 1: JPasswordField
        gbc.gridx = 1; gbc.weightx = 1.0;
        root.add(passText, gbc);

        // ENTER en el campo de password también intentará login.
        passText.addActionListener(this::hacerLogin);

        // NOTA sobre JPasswordField:
        // - Usa internamente char[] para que puedas “borrar” el contenido de memoria más fácilmente.
        // - El texto aparece enmascarado (eco). Puedes alterar el eco:
        //   passText.setEchoChar('*'); // ejemplo

        // ---------- Fila 2: Botón centrado (ocupa 2 columnas) ----------
        gbc.gridy = 2;
        gbc.gridx = 0; gbc.gridwidth = 2; // span de DOS columnas
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;          // el botón NO se estira
        gbc.anchor = GridBagConstraints.CENTER;      // se ubica al centro de su celda

        loginButton.addActionListener(this::hacerLogin);
        root.add(loginButton, gbc);

        // ---------- Fila 3: Mensaje (ocupa 2 columnas) ----------
        gbc.gridy = 3;
        gbc.gridx = 0; gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;    // la etiqueta sí se estira a lo ancho
        mensajeLabel.setFont(mensajeLabel.getFont().deriveFont(Font.BOLD, 13f));
        root.add(mensajeLabel, gbc);

        return root;
    }

    /**
     * Acción de intento de login.
     * Se invoca desde:
     *  - Click en el botón
     *  - ENTER en usuarioText o passText (por addActionListener)
     *  - ENTER global gracias a getRootPane().setDefaultButton(loginButton)
     */
    private void hacerLogin(ActionEvent e) {
        String usuario = usuarioText.getText().trim();

        // Con JPasswordField, la forma recomendada es getPassword() -> char[].
        // Razón: un String es inmutable y podría quedar en memoria más tiempo;
        // en cambio el char[] puedes “limpiarlo” sobrescribiéndolo.
        char[] passChars = passText.getPassword();
        String pass = new String(passChars).trim(); // Para este ejemplo sencillo, construimos el String.

        // (Opcional) Limpia el arreglo por seguridad básica:
        java.util.Arrays.fill(passChars, '\0');

        if (usuario.equals("admin") && pass.equals("admin")) {
            mensajeLabel.setText("Login correcto, bienvenido " + usuario);
            // Sugerencia: dispose() libera la ventana y sus recursos nativos.
            // setVisible(false) la oculta pero no libera; mejor usar dispose() al pasar a otra ventana.
            dispose();

            // Abrir la siguiente ventana (ej. un menú o la ventana principal).
            new PostLoginFrame(usuario);
            //new GUI1Contador.MiInterfaz();
        } else {
            mensajeLabel.setText("Login incorrecto, verifique los datos");
            // (Opcional) Seleccionar todo el password para reescribir rápido:
            passText.selectAll();
            passText.requestFocusInWindow();
        }
    }
}