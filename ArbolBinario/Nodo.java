package ArbolBinario;

/**
 * Clase nodo para un arbol binario
 * 
 * @param <T>       tipo de los datos que se guardan en el nodo del árbol.
 * @param dato      el valor que se guardará en este nodo
 * @param izquierdo el subarbol/hijo izquierdo del nodo (null si no tiene)
 * @param derecho   el subarbol/hijo derecho del nodo (null si no tiene).
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Nodo<T> {
    private T dato; // Dato del nodo.
    private Nodo<T> izquierdo, derecho; // Referencia a los subarboles.

    /**
     * Constructor que inicializa el nodo con el dato y los subarboles a null
     * 
     * @param dato que almacenara el nodo
     */
    public Nodo(T dato) {
        this.dato = dato;
        izquierdo = null;
        derecho = null;
    }

    /**
     * Devuelve el dato del nodo
     * 
     * @return el dato del nodo
     */
    public T getDato() {
        return dato;
    }

    /**
     * Cambia el dato del nodo
     * 
     * @param dato nuevo dato del nodo
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Devuelve la referencia al subarbol izquierdo
     * 
     * @return referencia al subarbol izquierdo
     */
    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }

    /**
     * Establece el subarbol izquierdo
     * 
     * @param izquierdo subarbol izquierdo a establecer
     */
    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * Devuelve la referencia al subarbol derecho
     * 
     * @return referencia al subarbol derecho
     */
    public Nodo<T> getDerecho() {
        return derecho;
    }

    /**
     * Establece el subarbol derecho
     * 
     * @param derecho subarbol derecho a establecer
     */
    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }

}
