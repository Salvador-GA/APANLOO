/**
 * @file CajaMezclada.java
 * @brief Clase genérica que almacena dos elementos de diferentes tipos.
 */

/**
 * Clase genérica que almacena dos elementos de diferentes tipos.
 * Utiliza dos tipos genéricos: T1 para el primer elemento y T2 para el segundo
 * elemento.
 * 
 * @tparam T1 Tipo del primer elemento.
 * @tparam T2 Tipo del segundo elemento.
 */
public class CajaMezclada<T1, T2> {
    private T1 primerElemento;
    private T2 segundoElemento;

    /**
     * Constructor de la clase CajaMezclada.
     * 
     * @param primerElemento  El primer elemento de tipo T1.
     * @param segundoElemento El segundo elemento de tipo T2.
     */
    public CajaMezclada(T1 primerElemento, T2 segundoElemento) {
        this.primerElemento = primerElemento;
        this.segundoElemento = segundoElemento;
    }

    /**
     * Obtiene el primer elemento de la caja.
     * 
     * @return El primer elemento, de tipo T1.
     */
    public T1 getPrimerElemento() {
        return primerElemento;
    }

    /**
     * Establece un nuevo valor para el primer elemento.
     * 
     * @param primerElemento El nuevo valor del primer elemento, de tipo T1.
     */
    public void setPrimerElemento(T1 primerElemento) {
        this.primerElemento = primerElemento;
    }

    /**
     * Obtiene el segundo elemento de la caja.
     * 
     * @return El segundo elemento, de tipo T2.
     */
    public T2 getSegundoElemento() {
        return segundoElemento;
    }

    /**
     * Establece un nuevo valor para el segundo elemento.
     * 
     * @param segundoElemento El nuevo valor del segundo elemento, de tipo T2.
     */
    public void setSegundoElemento(T2 segundoElemento) {
        this.segundoElemento = segundoElemento;
    }

    /**
     * Método que representa la información de la caja como una cadena.
     * 
     * @return Una cadena que muestra los dos elementos de la caja.
     */
    @Override
    public String toString() {
        return "Primer Elemento: " + primerElemento.toString() + ", Segundo Elemento: " + segundoElemento.toString();
    }
}