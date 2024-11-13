package EnfoqueDelegacionMVC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase ContadorControlador que representa el controlador en el patrón MVC.
 * Gestiona la interacción entre la vista y el modelo, permitiendo incrementar el contador.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ContadorControlador {
    /**
     * Constructor que inicializa el controlador, conectando el modelo y configurando el botón de incremento.
     * 
     * @param modelo el modelo del contador
     */
    public ContadorControlador(Contador modelo) {
        Frame frame = new Frame("Controlador de Contador");
        frame.setSize(300, 100);
        frame.setLayout(null);

        Panel panel = new Panel();
        panel.setBounds(50, 30, 200, 40);

        Button btnIncrementar = new Button("Incrementar");
        btnIncrementar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.incrementar();
            }
        });

        panel.add(btnIncrementar);
        frame.add(panel);

        frame.setVisible(true);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}

