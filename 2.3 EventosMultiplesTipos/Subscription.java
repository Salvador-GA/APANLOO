/**
 * Clase Subscription, almacena al listener y el tipo de evento al que esta registrado
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public final class Subscription {
    private final EventListener listener;
    private final int type;

    /**
     * Constructor de la clase
     * @param listener
     * @param type
     */
    public Subscription(EventListener listener, int type) {
        this.listener = listener; 
        this.type = type;
    }

    /**
     * Devuelve el listener almacenado
     * @return listener
     */
    public EventListener getListener() { 
        return listener; 
    }

    /**
     * Devuelve el tipo de evento al que esta suscrito
     * @return tipo
     */
    public int getType() { 
        return type; 
    }
}
