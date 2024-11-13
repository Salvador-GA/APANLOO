package EnfoqueHerenciaMVC;

/**
 * Clase Principal que ejecuta la aplicación MVC de contador.
 * Crea e inicializa el modelo, vista y controlador del patrón MVC.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        // Crear el modelo
        Contador modelo = new Contador();
        
        // Crear la vista
        ContadorVista vista = new ContadorVista();
        
        // Crear el controlador, conectando el modelo y la vista
        new ContadorControlador(modelo, vista);
    }
}
