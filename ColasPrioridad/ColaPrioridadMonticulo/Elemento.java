package ColasPrioridad.ColaPrioridadMonticulo;

/**
 * Clase Elemento que contiene la prioridad y el dato para los nodos del
 * monticulo
 * 
 * @author Salvdor Gonzalez Arellano
 * @version 1.0
 */
public class Elemento<T> implements Comparable<Elemento<T>> {
    private int prioridad;
    private T dato;

    /**
     * Constructor de la calse
     * 
     * @param prioridad Es la prioridad del dato
     * @param dato      Es el dato que se va a almacenar
     */
    public Elemento(int prioridad, T dato) {
        this.prioridad = prioridad;
        this.dato = dato;
    }

    /**
     * Devuelve la prioridad
     * 
     * @return prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Devuelve el dato
     * 
     * @return dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * Se sobreescribe la funcion compareTo, para que los elementos se comparen por
     * su prioridad
     * 
     * @return 0 si son iguales, -1 si el elemento es menor y 1 si el elemento es
     *         mayor
     */
    @Override
    public int compareTo(Elemento<T> otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }

    /**
     * Se sobreescribe la función toString para mostrar la informacion de dato entre
     * parentesis
     * 
     * @return String con la información del dato
     */
    @Override
    public String toString() {
        return "(" + prioridad + ", " + dato.toString() + ")";
    }
}
