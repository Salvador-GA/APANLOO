import java.awt.*;
import java.awt.event.*;

/**
 * Una ventana, centrada en la pantalla y que termina la aplicación al cerrarse
 * que contiene dos botones y una etiqueta y realiza acciones al presionar los
 * botones
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class EjemploCompleto1 extends Frame implements ActionListener {
    Label valueLabel;
    Button incrementButton;
    Button resetButton;

    /**
     * Constructor de la clase
     */
    public EjemploCompleto1() {
        super("Un incrementador");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        initialize();
    }

    /**
     * Inicializa los componentes gráficos de la ventana y agrega los
     * ActionListeners a los botones
     */
    private void initialize() {
        setSize(250, 100);
        this.setLayout(null);
        incrementButton = new Button("Increment");
        incrementButton.setBounds(40, 40, 75, 25);
        // Registra la instancia de esta/this clase como listener
        incrementButton.addActionListener(this);
        add(incrementButton);
        resetButton = new Button("Reset");
        resetButton.setBounds(135, 40, 75, 25);
        // Registra la instancia de esta/this clase como listener
        resetButton.addActionListener(this);
        add(resetButton);
        valueLabel = new Label("0", Label.CENTER);
        valueLabel.setBounds(100, 70, 50, 25);
        add(valueLabel);
        center();
        setVisible(true);
    }

    /**
     * Incrementa el valor de la etiqueta si la accion realizada fue sobre el boton
     * incrementButton, establece el valor de la etiqueta a 0 si la accion realizada
     * fue sobre el boton resetButton
     * 
     * @param evento
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == incrementButton) {
            int value = Integer.parseInt(valueLabel.getText());
            valueLabel.setText(String.valueOf(value + 1));
        } else if (evento.getSource() == resetButton) {
            valueLabel.setText("0");
        }
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
        new EjemploCompleto1();
    }
}
