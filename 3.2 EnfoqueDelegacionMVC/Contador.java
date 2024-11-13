package EnfoqueDelegacionMVC;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Clase Contador que representa el modelo en el patrón MVC.
 * Gestiona el valor de un contador y notifica a los listeners cuando cambia.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Contador {
    private int valor;
    private PropertyChangeSupport support;

    /**
     * Constructor que inicializa el contador en 0 y prepara el sistema de listeners.
     */
    public Contador() {
        valor = 0;
        support = new PropertyChangeSupport(this);
    }

    /**
     * Agrega un listener para escuchar cambios en el valor del contador.
     * 
     * @param listener el listener que recibirá notificaciones cuando el valor cambie
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Incrementa el valor del contador en 1 y notifica a los listeners.
     */
    public void incrementar() {
        int oldValor = valor;
        valor++;
        support.firePropertyChange("valor", oldValor, valor);
    }

    /**
     * Obtiene el valor actual del contador.
     * 
     * @return el valor actual del contador
     */
    public int getValor() {
        return valor;
    }
}

