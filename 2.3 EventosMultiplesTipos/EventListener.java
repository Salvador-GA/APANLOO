/**
 * Interfaz que representa un listener para eventos.
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public interface EventListener {
    /**
     * Método que se llama cuando ocurre un evento.
     * 
     * @param event el tipo de evento que será manejado.
     * @param message el mensaje asociado al evento.
     */
    void onEvent(int event, String message);
}