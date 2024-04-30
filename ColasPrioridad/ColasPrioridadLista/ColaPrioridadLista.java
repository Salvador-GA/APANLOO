package ColasPrioridad.ColasPrioridadLista;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Clase ColaPrioridadArreglos implementada como una lista de colas donde la
 * lista[0] es la de prioridad mas alta, cada cola se maneja conforme a la
 * prioridad FIFO
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ColaPrioridadLista<T> {
    private int num_prioridades; // total de prioridades
    private List<Queue<T>> colaP = new LinkedList<>(); // Cola de prioridades, la lista 0 contiene la prioridad más alta

    /**
     * Constructor de la clase, crea un total de num_prioridades de colas
     * 
     * @param num_prioridades el total de prioridades que tendra la lista de colas
     */
    public ColaPrioridadLista(int num_prioridades) {
        this.num_prioridades = num_prioridades;
        for (int i = 0; i < num_prioridades; i++) {
            colaP.add(new LinkedList<T>());
        }
    }

    /**
     * Inserta un dato en la cola que corresponda a la prioridad indicada
     * 
     * @param prioridad La prioridad del dato a insertar
     * @param dato      El dato a insertar
     * @return verdadero si la prioridad es valida, falso en otro caso
     */
    public boolean insertar(int prioridad, T dato) {
        if (prioridad < 0 || prioridad >= num_prioridades) {
            return false;
        } else {
            colaP.get(prioridad).add(dato);
            return true;
        }
    }

    /**
     * Devuelve el dato con la prioridad más alta de todas las colas disponibles, si
     * hay varios datos con la misma prioridad, entonces devuelve el primero que se
     * encolo
     * 
     * @return el dato con la priridad mas alta
     */
    public T obtenerSig() {
        for (Queue<T> cola : colaP) {
            if (!cola.isEmpty()) {
                return cola.poll();
            }
        }
        return null;
    }

    /**
     * Devuelve un string con la información de cada una de las colas
     * 
     * @return el string con la informacion de todas las colas
     */
    public String toString() {
        String cp = "";
        int prioridad = 0;
        for (Queue<T> cola : colaP) {
            cp += prioridad + " [";
            for (T elemento : cola) {
                cp += "(" + elemento + ") ";
            }
            cp += "]\n";
            prioridad++;
        }
        return cp;
    }
}
