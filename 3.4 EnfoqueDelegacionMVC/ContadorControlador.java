/**
 * Controlador: conecta Vista ↔ Modelo.
 * - Registra listeners en la Vista.
 * - Al recibir eventos de UI, actualiza el Modelo y luego refresca la Vista.
 * - La Vista sigue “tonta”: no conoce el Modelo.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ContadorControlador {
    private final Contador modelo;
    private final ContadorVista vista;

    public ContadorControlador(Contador modelo, ContadorVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        // Wiring (delegación): la Vista emite eventos, el Controlador reacciona.
        this.vista.onIncrementar(e -> {
            modelo.incrementar();             // 1) Cambia el estado del Modelo
            vista.setValor(modelo.get());     // 2) Refresca la Vista
        });

        this.vista.onReiniciar(e -> {
            modelo.reiniciar();
            vista.setValor(modelo.get());
        });

        // (Opcional) Botón por defecto = Incrementar al presionar ENTER
        this.vista.setDefaultButtonIncrementar();

        // Asegura que la Vista arranque mostrando el estado actual del Modelo.
        this.vista.setValor(modelo.get());
    }
}
