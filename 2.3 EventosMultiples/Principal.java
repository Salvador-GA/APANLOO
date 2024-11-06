/**
 * Clase principal que ejecuta el sistema de eventos con dos tipos de eventos.
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
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();

        // Crear y registrar suscriptores
        EventSubscriber suscriptor1 = new EventSubscriber("Suscriptor 1", true, true); // Recibe ambos eventos
        EventSubscriber suscriptor2 = new EventSubscriber("Suscriptor 2", true, false); // Solo Evento Tipo 1
        EventSubscriber suscriptor3 = new EventSubscriber("Suscriptor 3", false, true); // Solo Evento Tipo 2

        publisher.registerListener(suscriptor1);
        publisher.registerListener(suscriptor2);
        publisher.registerListener(suscriptor3);

        // Enviar eventos
        System.out.println("Enviando eventos Tipo 1 (Número Primo Encontrado)");
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
