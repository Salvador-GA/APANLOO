import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que ejecuta el sistema de eventos con dos tipos de eventos.
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.2
 */
public class Principal {

    /**
     * Método que determina si un número es primo.
     * 
     * @param number el número a verificar.
     * @return true si el número es primo, false en caso contrario.
     */
    public static boolean esPrimo(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> types = new ArrayList<>();
        types.add(1); // es primo
        types.add(2); // no es primo
        EventPublisher publisher = new EventPublisher(types);

        // Crear y registrar suscriptores
        EventSubscriber suscriptor1 = new EventSubscriber("Suscriptor 1", true, true); // Recibe ambos eventos
        EventSubscriber suscriptor2 = new EventSubscriber("Suscriptor 2", true, false); // Solo Evento Tipo 1
        EventSubscriber suscriptor3 = new EventSubscriber("Suscriptor 3", false, true); // Solo Evento Tipo 2

        // Se registran las suscripciones
        publisher.registerSubscription(suscriptor1, 1);
        publisher.registerSubscription(suscriptor1, 2);
        publisher.registerSubscription(suscriptor1, 3);
        publisher.registerSubscription(suscriptor2, 1);
        publisher.registerSubscription(suscriptor3, 2);

        // Enviar eventos
        for (int i = 2; i <= 20; i++) {
            if (esPrimo(i)) {
                publisher.notifyListeners(1, "Número primo encontrado: " + i);
            } else {
                publisher.notifyListeners(2, "Número no primo: " + i);
            }
            // ponemos a dormir al hilo, para simular un retardo en calcular el siguiente
            // número primo
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}