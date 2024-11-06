/**
 * Clase principal que ejecuta el sistema de eventos y busca números primos.
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {

    /**
     * Método que determina si un número es primo.
     * 
     * @param number el número a verificar.
     * @return true si el número es primo, false en caso contrario.
     */
    public static boolean esPrimo(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Método principal que configura el sistema de eventos y busca números primos.
     * 
     * @param args argumentos de línea de comando.
     */
    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();

        // Registrar suscriptores para recibir notificaciones de números primos
        publisher.registerListener(new EventSubscriber("Suscriptor 1"));
        publisher.registerListener(new EventSubscriber("Suscriptor 2"));

        // Buscar números primos entre 2 y 10000 y notificar cada vez que se encuentre
        // uno
        for (int i = 2; i <= 10000; i++) {
            if (esPrimo(i)) {
                publisher.notifyListeners("Número primo encontrado: " + i);
            }
        }
    }
}
