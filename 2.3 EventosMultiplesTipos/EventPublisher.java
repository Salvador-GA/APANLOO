import java.util.ArrayList;
import java.util.List;

/**
 * La clase EventPublisher gestiona los eventos y notifica a los listeners
 * registrados.
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class EventPublisher {
    private final List<Subscription> subscriptions = new ArrayList<>();
    private final List<Integer> eventTypes = new ArrayList<>();

    /**
     * Constructor que inicializa la lista de tipos de eventos disponibles para este publisher
     * @param eventTypes
     */
    public EventPublisher (List<Integer> eventTypes) {
        for(Integer event : eventTypes) {
            this.eventTypes.add(event);
        }
    }

    /**
     * Registra un nuevo listener en la lista de suscriptores, si el tipo de evento es correcto.
     * 
     * @param listener el listener que será registrado.
     * @param type tipo de evento al que será registrado
     */
    public void registerSubscription(EventListener listener, int type) {
        if (eventTypes.contains(type)){
            subscriptions.add(new Subscription(listener, type));
        } else {
            System.out.println("El tipo de evento "+type+" no pertenece a la lista de eventos conocidos por el publisher");
            System.out.println("No se genero la suscripcion");
        }
    }

    /**
     * Notifica a los listeners sobre un evento específico, siempre que el tipo
     * de evento corresponda al de interes del listener.
     * 
     * @param event   el tipo de evento que será notificado a los listeners.
     * @param message el mensaje que será enviado a los listeners.
     */
    public void notifyListeners(int event, String message) {
        for (Subscription subscription : subscriptions) {
            if (subscription.getType() == event) {
                subscription.getListener().onEvent(event, message);
            }
        }
    }
}
