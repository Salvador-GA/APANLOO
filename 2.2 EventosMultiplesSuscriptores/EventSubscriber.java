/**
 * La clase EventSubscriber implementa el listener que reacciona a eventos.
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class EventSubscriber implements EventListener{
    private final String name;

    /**
     * Constructor de EventSubscriber.
     * 
     * @param name el nombre del suscriptor.
     */
    public EventSubscriber(String name) {
        this.name = name;
    }

    /**
     * Método llamado cuando ocurre un evento.
     * 
     * @param event el evento recibido.
     */
    public void onEvent(String event) {
        System.out.println(name + " recibió el evento: " + event);
    }
}