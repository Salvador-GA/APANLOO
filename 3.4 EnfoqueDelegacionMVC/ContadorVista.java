import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Vista (Swing) del contador.
 * - No contiene lógica de negocio (no incrementa ni reinicia el modelo).
 * - Expone métodos para:
 *    a) Registrar listeners (que el Controlador aporta)
 *    b) Actualizar la UI (mostrar valor)
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ContadorVista extends JFrame {
    // Componentes UI (privados). La vista decide cómo se ven y se ordenan.
    private final JLabel lblValor   = new JLabel("0", SwingConstants.CENTER);
    private final JButton btnInc    = new JButton("Incrementar");
    private final JButton btnReset  = new JButton("Reiniciar");

    public ContadorVista() {
        super("Contador (MVC por Delegación)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ---- Layout: GridBag para un ejemplo claro y escalable ----
        JPanel root = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta grande para el valor
        lblValor.setFont(lblValor.getFont().deriveFont(Font.BOLD, 28f));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.weightx = 1.0;
        root.add(lblValor, gbc);

        // Botón Incrementar
        gbc.gridy = 1; gbc.gridwidth = 1; gbc.gridx = 0; gbc.weightx = 1.0;
        root.add(btnInc, gbc);

        // Botón Reiniciar
        gbc.gridx = 1;
        root.add(btnReset, gbc);

        setContentPane(root);
        pack();                        // Calcula tamaño ideal según contenido/layout
        setLocationRelativeTo(null);   // Centra en el monitor principal
        // setVisible(true);           // Lo hace el main (buena práctica)
    }

    /* ---------------- API pública de la Vista ---------------- */

    // Permite que el Controlador “inyecte” la reacción a clic en Incrementar,
    // sin que la Vista conozca la lógica del Modelo.
    public void onIncrementar(ActionListener l) { btnInc.addActionListener(l); }

    // Igual para Reiniciar
    public void onReiniciar(ActionListener l) { btnReset.addActionListener(l); }

    // Actualiza el número mostrado (la Vista decide cómo lo renderiza)
    public void setValor(int nuevoValor) { lblValor.setText(String.valueOf(nuevoValor)); }

    // (Opcional) Enfocar un botón por defecto o atajos de teclado
    public void setDefaultButtonIncrementar() { getRootPane().setDefaultButton(btnInc); }
}
