/**
 * Clase principal que ejecuta el sistema de eventos.
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    /**
     * Método principal que configura el sistema de eventos y envía notificaciones.
     * 
     * @param args argumentos de línea de comando.
     */
    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();

        publisher.registerListener(new EventSubscriber("suscriptor 1"));
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                publisher.notifyListeners("i vale 3");
            }
        }
    }
}
