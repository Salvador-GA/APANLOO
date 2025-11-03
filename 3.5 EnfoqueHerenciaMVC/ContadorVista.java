import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Enfoque MVC por HERENCIA:
 * - La vista extiende JFrame y también implementa ActionListener (actúa como controlador).
 * - Contiene una referencia al Modelo (Contador).
 * - Maneja eventos de sus propios botones (this como listener).
 *
 * Notas:
 * - En proyectos grandes es preferible la DELEGACIÓN (controlador separado).
 * - Esto es útil para demos o ejercicios breves.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ContadorVista extends JFrame implements ActionListener {

    /* --------- Modelo --------- */
    private final Contador modelo;

    /* --------- Componentes UI --------- */
    private final JLabel lblValor = new JLabel("0", SwingConstants.CENTER);
    private final JButton btnInc  = new JButton("Incrementar");
    private final JButton btnRes  = new JButton("Reiniciar");

    public ContadorVista(Contador modelo) {
        super("Contador (MVC por Herencia)");
        this.modelo = modelo; // La vista conoce al modelo en este enfoque

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Construye el panel de contenido con GridBagLayout (evita setBounds)
        setContentPane(crearContenido());

        // Registra esta misma vista como listener (herencia -> this)
        // Ambos botones delegan a actionPerformed(...) de ESTA clase.
        btnInc.addActionListener(this);
        btnRes.addActionListener(this);

        // Botón por defecto (ENTER hará "click" en Incrementar)
        getRootPane().setDefaultButton(btnInc);

        pack();                      // Calcula tamaño ideal según layout
        setLocationRelativeTo(null); // Centra en la pantalla (monitor principal)
        // setVisible(true) // Lo hace el main cuando todo está listo
    }

    private JPanel crearContenido() {
        JPanel root = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Márgenes alrededor de cada componente (top, left, bottom, right).
        gbc.insets = new Insets(8, 8, 8, 8);

        // fill define cómo se expande el componente dentro de su celda.
        // HORIZONTAL -> ocupa el ancho disponible, alto preferido.
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ----- Fila 0: Etiqueta de valor ocupando dos columnas -----
        lblValor.setFont(lblValor.getFont().deriveFont(Font.BOLD, 28f));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 1.0;
        root.add(lblValor, gbc);

        // ----- Fila 1: Botón Incrementar -----
        gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 1.0;

        gbc.gridx = 0;
        root.add(btnInc, gbc);

        // ----- Fila 1: Botón Reiniciar -----
        gbc.gridx = 1;
        root.add(btnRes, gbc);

        return root;
    }

    /* ----------------- Controlador (herencia) ----------------- */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnInc) {
            // 1) Cambia el modelo
            modelo.incrementar();
            // 2) Refresca la vista
            lblValor.setText(String.valueOf(modelo.get()));
        } else if (src == btnRes) {
            modelo.reiniciar();
            lblValor.setText(String.valueOf(modelo.get()));
        }
    }

    /* ------------- Utilidad opcional ------------- */
    // Por si quieres exponer una forma segura de refrescar desde fuera
    public void refrescar() {
        lblValor.setText(String.valueOf(modelo.get()));
    }
}
