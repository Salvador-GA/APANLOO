package EventosEntregaDirecta;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase EventPublisher gestiona los eventos y notifica a los listeners registrados.
 */
public class EventPublisher {
    private final List<EventListener> listeners = new ArrayList<>();

    /**
     * Registra un nuevo listener en la lista de suscriptores.
     * 
     * @param listener el listener que será registrado.
     */
    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    /**
     * Notifica a todos los listeners registrados sobre un evento específico.
     * 
     * @param event el evento que será notificado a los listeners.
     */
    public void notifyListeners(String event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}