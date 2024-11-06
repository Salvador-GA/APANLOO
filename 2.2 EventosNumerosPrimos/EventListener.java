/**
 * Interfaz que representa un listener para eventos.
 */
public interface EventListener {
    /**
     * Método que se llama cuando ocurre un evento.
     * 
     * @param event el evento que será manejado.
     */
    void onEvent(String event);
}