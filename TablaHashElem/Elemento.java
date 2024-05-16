package TablaHashElem;

/**
 * Clase Elemento, almacena una clave de tipo String y un dato de tipo generico
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Elemento<T> {
    private String clave;
    private T dato;

    /**
     * Constructor de la clase que inicializa los atributos
     * 
     * @param clave
     * @param dato
     */
    public Elemento(String clave, T dato) {
        this.clave = clave;
        this.dato = dato;
    }

    /**
     * Devuelve la clave del elemento
     * 
     * @return clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Devuelve el dato del elemento
     * 
     * @return dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * Devuelve la clave y el dato en un string entre parentesis
     * 
     * @return (clave, dato)
     */
    public String toString() {
        return "(" + clave + " " + dato + ")";
    }

    /**
     * Sobreescribe el metodo equals de Object
     * 
     * @return verdader si los objetos son iguales, falso en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            Elemento<?> otro = (Elemento<?>) o;
            return (this.clave.equals(otro.getClave()) && this.dato.equals(otro.getDato()));
        }
    }
}
