package EventosMultiples;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase EventPublisher gestiona los eventos y notifica a los listeners registrados.
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.0
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
     * Notifica a los listeners sobre un evento específico.
     * 
     * @param event el tipo de evento que será notificado a los listeners.
     * @param message el mensaje que será enviado a los listeners.
     */
    public void notifyListeners(int event, String message) {
        for (EventListener listener : listeners) {
            listener.onEvent(event, message);
        }
    }
}
