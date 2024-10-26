/**
 * @file Caja.java
 * @brief Clase genérica Caja que almacena un objeto de cualquier tipo.
 */

/**
 * Clase genérica que puede almacenar y manipular objetos de cualquier tipo.
 * 
 * @tparam T El tipo de objeto que se almacenará en la caja.
 */
public class Caja<T> {
    // Atributo genérico de tipo T
    private T contenido;

    /**
     * Constructor que inicializa la caja con un contenido.
     * 
     * @param contenido El objeto de tipo T que se almacenará en la caja.
     */
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    /**
     * Método que obtiene el contenido almacenado en la caja.
     * 
     * @return El contenido de la caja, de tipo T.
     */
    public T getContenido() {
        return contenido;
    }

    /**
     * Método que establece un nuevo contenido en la caja.
     * 
     * @param contenido El nuevo contenido de tipo T que se almacenará en la caja.
     */
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    /**
     * Método que muestra el contenido almacenado en la caja en forma de cadena.
     * 
     * @return Una cadena representando el contenido de la caja.
     */
    @Override
    public String toString() {
        return "Contenido de la caja: " + contenido.toString();
    }
}