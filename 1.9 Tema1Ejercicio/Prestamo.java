/**
 * @file Prestamo.java
 * @brief Interfaz que define los métodos necesarios para materiales prestables.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public interface Prestamo {
    /**
     * Marca el material como prestado.
     */
    void prestar();

    /**
     * Marca el material como devuelto.
     */
    void devolver();

    /**
     * Verifica si el material está prestado.
     * 
     * @return `true` si el material está prestado, `false` en caso contrario.
     */
    boolean estaPrestado();
}