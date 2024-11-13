package EnfoqueHerenciaMVC;

import java.util.Observable;

/**
 * Clase Contador que representa el modelo en el patrón MVC.
 * Gestiona el valor de un contador y notifica a los observadores cuando cambia.
 * 
 * La clase Observable está marcado como obsoleto (deprecated) en las versiones
 * recientes de Java, lo cual indica que esta clase y sus métodos no son
 * recomendados para el desarrollo de nuevas aplicaciones. La API de Observable
 * y Observer ha sido reemplazada en Java por una arquitectura de eventos basada
 * en PropertyChangeListener y PropertyChangeSupport, que ofrece más
 * flexibilidad y es más fácil de mantener.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class Contador extends Observable {
    private int valor;

    /**
     * Constructor que inicializa el contador en 0.
     */
    public Contador() {
        valor = 0;
    }

    /**
     * Incrementa el valor del contador en 1 y notifica a los observadores.
     */
    public void incrementar() {
        valor++;
        setChanged();
        notifyObservers(valor);
    }

    /**
     * Reinicia el valor del contador a 0 y notifica a los observadores.
     */
    public void reset() {
        valor = 0;
        setChanged();
        notifyObservers(valor);
    }

    /**
     * Obtiene el valor actual del contador.
     * 
     * @return el valor del contador
     */
    public int getValor() {
        return valor;
    }
}