import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Ventana (Swing) con dos cajas de texto, tres etiquetas y un botón.
 * Muestra "Hola <nombre> <apellidos>!" al presionar el botón o Enter.
 */
public class SaludoFrame extends JFrame {
    // Alineación HORIZONTAL del texto dentro del JLabel:
    // El segundo parámetro del constructor es un SwingConstants (LEFT/CENTER/RIGHT/LEADING/TRAILING).
    // Aquí usamos RIGHT para “pegar” la palabra "Nombre:"/“Apellidos:” al campo que está a la derecha.
    private final JLabel nombreLabel    = new JLabel("Nombre:",    SwingConstants.RIGHT);
    private final JLabel apellidosLabel = new JLabel("Apellidos:", SwingConstants.RIGHT);

    private final JTextField nombreText    = new JTextField(20);   // 20 = "columnas" (ancho sugerido, no fijo)
    private final JTextField apellidosText = new JTextField(20);   // El layout puede hacerlo crecer si hay espacio

    private final JButton saludoButton = new JButton("Saludar");

    // Etiqueta de salida: la centramos horizontalmente para que el mensaje luzca uniforme
    private final JLabel saludoLabel = new JLabel("Esperando nombre...", SwingConstants.CENTER);

    public SaludoFrame() {
        super("Ventana que da un saludo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(crearContenido());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel crearContenido() {
        JPanel panelRaiz = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        // ---------- Fila 0: etiqueta "Nombre:" y caja ----------
        gbc.gridy = 0;

        // Columna 0: etiqueta
        gbc.gridx = 0;
        gbc.weightx = 0;                    // esta columna NO “pide” espacio extra al crecer la ventana
        gbc.fill = GridBagConstraints.NONE; // la etiqueta no necesita estirarse
        panelRaiz.add(nombreLabel, gbc);

        // Columna 1: campo de texto
        gbc.gridx = 1;
        gbc.weightx = 1.0;                        // esta columna sí puede recibir espacio extra (se expandirá)
        gbc.fill = GridBagConstraints.HORIZONTAL; // el JTextField se estira a lo ancho si hay espacio
        panelRaiz.add(nombreText, gbc);

        // ---------- Fila 1: etiqueta "Apellidos:" y caja ----------
        gbc.gridy = 1;

        // Columna 0: etiqueta
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panelRaiz.add(apellidosLabel, gbc);

        // Columna 1: campo de texto
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelRaiz.add(apellidosText, gbc);

        // ---------- Fila 2: botón centrado (ocupa 2 columnas) ----------
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;                     // SPAN: este componente ocupa DOS columnas (0 y 1)
        gbc.weightx = 1.0;                     // permite que su celda consuma ancho extra si lo hay
        gbc.fill = GridBagConstraints.NONE;    // el botón mantiene su tamaño preferido (no se deforma)
        gbc.anchor = GridBagConstraints.CENTER;// ¿dónde colocarlo dentro de la celda? → centrado

        // “Botón por defecto” de la ventana: al presionar ENTER en cualquier campo, se dispara este botón.
        // Útil para UX: el usuario no necesita hacer clic con el mouse.
        getRootPane().setDefaultButton(saludoButton);

        saludoButton.addActionListener(this::saludar);
        panelRaiz.add(saludoButton, gbc);

        // ---------- Fila 3: etiqueta de salida (ocupa 2 columnas) ----------
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;                      // también abarca todo el ancho de la rejilla (dos columnas)
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // el label se estira a lo ancho para que el texto respire

        saludoLabel.setFont(saludoLabel.getFont().deriveFont(Font.BOLD, 14f));
        panelRaiz.add(saludoLabel, gbc);

        return panelRaiz;
    }

    private void saludar(ActionEvent e) {
        // Limpieza y validación mínima de entradas:
        // trim() elimina espacios al inicio/fin, evitando saludos con “dobles espacios” o cadenas vacías aparentes.
        String nombre = nombreText.getText().trim();
        String apellidos = apellidosText.getText().trim();

        if (nombre.isEmpty() && apellidos.isEmpty()) {
            // Mensaje guía si no hay nada escrito (mejor UX que dejarlo silencioso)
            saludoLabel.setText("Por favor, escribe tu nombre.");
        } else {
            // (nombre + " " + apellidos).trim(): si falta uno, evitamos el espacio “colgante”
            saludoLabel.setText("Hola " + (nombre + " " + apellidos).trim() + "!");
        }
    }
}
