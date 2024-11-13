package EnfoqueDelegacionMVC;

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
        
        // Crear la vista y registrar como listener del modelo
        ContadorVista vista = new ContadorVista();
        modelo.addPropertyChangeListener(vista);
        
        // Crear el controlador
        new ContadorControlador(modelo);
    }
}

