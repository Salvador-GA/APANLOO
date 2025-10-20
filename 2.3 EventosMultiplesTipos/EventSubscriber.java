/**
 * Clase EventSubscriber que implementa el listener y define acciones basadas en el tipo de evento.
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class EventSubscriber implements EventListener {
    private final String name;
    private final boolean recibeEventoPrimo;
    private final boolean recibeEventoNoPrimo;

    /**
     * Constructor de EventSubscriber.
     * 
     * @param name el nombre del suscriptor.
     * @param recibeEventoPrimo indica si el suscriptor recibe eventos para primos.
     * @param recibeEventoNoPrimo indica si el suscriptor recibe eventos para no primos.
     */
    public EventSubscriber(String name, boolean recibeEventoPrimo, boolean recibeEventoNoPrimo) {
        this.name = name;
        this.recibeEventoPrimo = recibeEventoPrimo;
        this.recibeEventoNoPrimo = recibeEventoNoPrimo;
    }

    /**
     * Método que reacciona al evento en función del tipo de evento.
     * Si recibe por error un tipo de evento que no le interesa, no hace nada.
     * 
     * @param event el tipo de evento recibido, 1 es número primo, 2 es número no primo.
     * @param message el mensaje del evento.
     */
    @Override
    public void onEvent(int event, String message) {
        if (event == 1 && recibeEventoPrimo) {
            System.out.println(name + " recibió Evento Tipo 1 " + message);
        } else if (event == 2 && recibeEventoNoPrimo) {
            System.out.println(name + " recibió Evento Tipo 2 " + message);
        } 
    }
}
