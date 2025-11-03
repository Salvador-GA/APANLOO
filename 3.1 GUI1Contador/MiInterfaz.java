import javax.swing.*; // Importa los componentes Swing (JFrame, JButton, JLabel, etc.).
import java.awt.*;    // Importa clases AWT usadas por Swing (Layout, Font, Insets, GridBagConstraints).
import java.awt.event.ActionEvent; // Para el tipo del evento de acción del botón "Incrementar".

/**
 * Ventana principal en Swing.
 */
public class MiInterfaz extends JFrame {
    /**
     * JLabel: etiqueta que mostrará el número (contador). SwingConstants.CENTER centra el texto horizontalmente.
     * [LEFT]        "Hola"           -> Hola____________________
     * [CENTER]      "Hola"           -> _________Hola___________
     * [RIGHT]       "Hola"           -> ____________________Hola
     * [LEADING]*    "Hola" (LTR)     -> Hola____________________
     * [TRAILING]*   "Hola" (LTR)     -> ____________________Hola
     * LEADING y TRAILING dependen de la orientación del componente:
     *   - En idiomas LTR (izq→der, p. ej. español/inglés): LEADING ≈ LEFT, TRAILING ≈ RIGHT.
     *   - En RTL (der→izq, p. ej. árabe/hebreo): se invierten.
     */ 
    private JLabel valorLabel = new JLabel("0", SwingConstants.CENTER);

    // JButton: botones de acción para incrementar y reiniciar el contador.
    private JButton incrementarButton = new JButton("Incrementar");
    private JButton reiniciarButton   = new JButton("Reiniciar");

    /**
     * Constructor: configura la ventana (título, cierre, contenido) y la hace visible.
     */
    public MiInterfaz() {
        super("Ventana en Java"); // Llama al constructor de JFrame con el título de la ventana.

        /**
         * Define la operación por defecto al cerrar la ventana:
         * JFrame.DO_NOTHING_ON_CLOSE No hace nada al cerrar (ignora el clic en la X). 
         *      Útil para interceptar el cierre y mostrar un “¿Guardar cambios?” antes de decidir.
         * JFrame.HIDE_ON_CLOSE (valor por defecto en JFrame) Oculta la ventana (setVisible(false)), 
         *      pero la aplicación sigue viva si hay otras ventanas o hilos en ejecución.
         * JFrame.DISPOSE_ON_CLOSE Libera los recursos nativos de la ventana (dispose) y la cierra. 
         *      Si es la única ventana y no quedan hilos, el proceso termina; si hay otras ventanas, la app sigue.
         * JFrame.EXIT_ON_CLOSE Llama a System.exit(0) cuando esa ventana se cierra: 
         *      termina todo el proceso Java. Úsalo solo si esa ventana debe “matar” la app completa.
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establece el panel principal (content pane) con los componentes ya dispuestos por un Layout Manager.
        setContentPane(crearContenido());

        // pack(): calcula el tamaño ideal de la ventana según el tamaño preferido de los componentes y del layout.
        pack();

        //Deja que el SO elija (a veces lo coloca mejor en multi-monitor)
        setLocationByPlatform(true); // antes de setVisible(true)

        // Centra la ventana respecto a la pantalla. Si pasas null, se centra automáticamente.
        // setLocationRelativeTo(null);

        // Muestra la ventana. Siempre al final, cuando todo está configurado.
        setVisible(true);
    }

    /**
     * Crea y devuelve el panel raíz con su Layout y componentes.
     * @return JPanel con los componentes colocados por GridBagLayout.
     */
    private JPanel crearContenido() {
        /**
         * JPanel raíz con GridBagLayout: layout muy flexible, basado en una grilla y restricciones por componente.
         * En GridBagLayout no defines de antemano cuántas columnas/filas hay. La “rejilla” se descubre automáticamente a partir 
         * de cómo coloques cada componente con gridx, gridy, gridwidth, gridheight:
         *      gridx, gridy → coordenadas de columna y fila (empezando en 0).
         *      Cada componente “declara” dónde quiere ir (col, fila).
         * Columnas/filas se acumulan: 
         *      si pones algo en gridx=3, esa columna ahora va a existir aunque antes no hubiera nada ahí. 
         *      Igual para gridy. No hay que “crear” la grilla.
         *      gridwidth / gridheight → cuántas columnas/filas abarca (span). Por defecto 1.
         *      Útil para que un título ocupe toda la fila, etc.
         * Posicionamiento relativo (poco usado): 
         *      gridx = GridBagConstraints.RELATIVE 
         *      coloca a la derecha del anterior en la misma fila; REMAINDER cierra la fila.
         * Distribución del espacio extra:
         *      weightx y weighty deciden qué columnas/filas crecen al agrandar la ventana.
         *      fill controla cómo se estira el componente dentro de su celda (NONE/HORIZONTAL/VERTICAL/BOTH).
         *      Si weightx/weighty son 0, aunque uses fill, no habrá espacio extra que repartir.
         */
        JPanel panelRaiz = new JPanel(new GridBagLayout());

        // Objeto de restricciones que define cómo se coloca cada componente dentro de la grilla.
        GridBagConstraints gbc = new GridBagConstraints();

        // Margen (espacio) alrededor de cada componente: top, left, bottom, right (en píxeles).
        // new Insets(8, 8, 8, 8) -> deja 8 px de espacio en cada lado del componente.
        gbc.insets = new Insets(8, 8, 8, 8);

        /**
         * fill: indica cómo se expande el componente dentro de su celda.
         * Las opciones de GridBagConstraints.fill son cuatro:
         *  - GridBagConstraints.NONE (valor por defecto) No se estira. 
         *      El componente usa su tamaño preferido. 
         *      Si la celda es más grande, queda espacio libre y el componente se coloca según anchor.
         *  - GridBagConstraints.HORIZONTAL Se estira solo a lo ancho para ocupar el ancho disponible de la celda. 
         *      El alto queda en el tamaño preferido (o el que marque el layout).
         *  - GridBagConstraints.VERTICAL Se estira solo a lo alto para ocupar la altura disponible. 
         *      El ancho queda en el tamaño preferido.
         *  - GridBagConstraints.BOTH Se estira en ambas direcciones (ancho y alto) para rellenar toda la celda.
         */
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ---------- Fila 0: etiqueta centrada con el contador ----------
        // Ajusta la fuente de la etiqueta: deriveFont(Font.BOLD, 18f) -> negritas, 18 puntos.
        valorLabel.setFont(valorLabel.getFont().deriveFont(Font.BOLD, 18f));

        // Posición en la grilla: columna (x) y fila (y).
        gbc.gridx = 0; // Columna 0
        gbc.gridy = 0; // Fila 0

        // gridwidth: cuántas columnas ocupa el componente. 2 -> ocupa dos columnas (para que quede centrado arriba).
        gbc.gridwidth = 2;

        // weightx: peso horizontal para distribución cuando hay espacio extra.
        // 1.0 -> este componente puede crecer horizontalmente si la ventana se agranda.
        gbc.weightx = 1.0;

        // Agrega la etiqueta al panel raíz con las restricciones actuales (gbc).
        panelRaiz.add(valorLabel, gbc);

        // ---------- Fila 1: botones lado a lado ----------
        // Botón "Incrementar": registramos un ActionListener usando una referencia a método.
        incrementarButton.addActionListener(this::incrementar);

        // Colocamos el botón "Incrementar" en columna 0, fila 1.
        gbc.gridx = 0;     // Columna 0
        gbc.gridy = 1;     // Fila 1
        gbc.gridwidth = 1; // Ocupa solo 1 columna (ya no 2 como la etiqueta).
        gbc.weightx = 1.0; // Puede crecer un poco en horizontal si hay espacio.
        panelRaiz.add(incrementarButton, gbc);

        // Botón "Reiniciar": usa una lambda simple para poner el contador en "0".
        reiniciarButton.addActionListener(e -> valorLabel.setText("0"));

        // Colocamos el botón "Reiniciar" en columna 1, fila 1.
        gbc.gridx = 1; // Columna 1 (a la derecha del anterior)
        gbc.gridy = 1; // Fila 1
        // gridwidth y weightx ya están bien para un boton de 1 celda.
        panelRaiz.add(reiniciarButton, gbc);

        // Devuelve el panel ya configurado con la etiqueta y los dos botones.
        return panelRaiz;
    }

    /**
     * Maneja el click en "Incrementar".
     * @param e ActionEvent que envía Swing al hacer clic (no lo usamos aquí, pero es la firma estándar).
     */
    private void incrementar(ActionEvent e) {
        // Lee el texto actual de la etiqueta ("0", "1", "2", ...), lo convierte a int y suma 1.
        int contador = Integer.parseInt(valorLabel.getText());
        // Actualiza la etiqueta con el nuevo valor del contador.
        valorLabel.setText(String.valueOf(contador + 1));
    }
}
