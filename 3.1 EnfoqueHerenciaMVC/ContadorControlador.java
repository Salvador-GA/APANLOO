package EnfoqueHerenciaMVC;

import java.awt.*;
import java.awt.event.*;
/**
 * Clase ContadorControlador que representa el controlador en el patrón MVC.
 * Gestiona la interacción entre la vista y el modelo, permitiendo incrementar y resetear el contador.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ContadorControlador implements ActionListener {

    /**
     * Constructor que inicializa el controlador, conectando el modelo y la vista.
     * 
     * @param modelo el modelo del contador
     * @param vista la vista del contador
     */
    @SuppressWarnings("deprecation")
    public ContadorControlador(Contador modelo, ContadorVista vista) {

        modelo.addObserver(vista);

        Frame frame = new Frame("Contador - Controlador");
        frame.setSize(300, 100);
        Panel panel = new Panel();

        Button btnIncrementar = new Button("Incrementar");
        Button btnReset = new Button("Reset");

        btnIncrementar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.incrementar();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.reset();
            }
        });

        panel.add(btnIncrementar);
        panel.add(btnReset);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}