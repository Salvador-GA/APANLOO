package ColasPrioridad.ColaPrioridadMonticulo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase ColaPrioMonticulo implementa una cola de prioridad con un monticulo
 * sobre un arreglo
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ColaPrioMonticulo<T> {
    private List<Elemento<T>> monticulo;

    /**
     * Constructor de la clase, inicializa el arrelgo para el monticulo
     */
    public ColaPrioMonticulo() {
        this.monticulo = new ArrayList<>();
    }

    /**
     * Devuelve el indice correspondiente al antecesor del elemento cuyo indice es i
     * 
     * @param i indice del nodo del cual se quiere saber su antecesor
     * @return indice del antecesor de i
     */
    private int getIndiceAntecesor(int i) {
        return (i - 1) / 2;
    }

    /**
     * Devuelve el indice correspondiente al sucesor izquierdo del elemento cuyo
     * indice es i
     * 
     * @param i indice del nodo del cual se quiere saber su sucesor izquierdo
     * @return indice del sucesor izquierdo de i
     */
    private int getIndiceSucIzq(int i) {
        return 2 * i + 1;
    }

    /**
     * Devuelve el indice correspondiente al sucesor derecho del elemento cuyo
     * indice es i
     * 
     * @param i indice del nodo del cual se quiere saber su sucesor derecho
     * @return indice del sucesor derecho de i
     */
    private int getIndiceSucDer(int i) {
        return 2 * i + 2;
    }

    /**
     * Indica si un elemento con indice i tiene sucesor izquierdo
     * 
     * @param i indice del que se verifica si tiene sucesor izquierdo
     * @return true si i tiene sucesor izquierdo, false en caso contrario
     */
    private boolean tieneSucIzq(int i) {
        return getIndiceSucIzq(i) < monticulo.size();
    }

    /**
     * Indica si un elemento con indice i tiene sucesor derecho
     * 
     * @param i indice del que se verifica si tiene sucesor derecho
     * @return true si i tiene sucesor derecho, false en caso contrario
     */
    private boolean tieneSucDer(int i) {
        return getIndiceSucDer(i) < monticulo.size();
    }

    /**
     * Indica si un elemento con indice i tiene antecesor
     * 
     * @param i indice del que se verifica si tiene antecesor
     * @return true si i tiene antecesor, false en caso contrario
     */
    private boolean tieneAntecesor(int i) {
        return getIndiceAntecesor(i) >= 0;
    }

    /**
     * Devuelve el elemento que es sucesor izquierdo de i
     * 
     * @param i indice del que se busca su sucesor izquierdo
     * @return el elemento que es sucesor izquierdo de i
     */
    private Elemento<T> getSucIzq(int i) {
        return monticulo.get(getIndiceSucIzq(i));
    }

    /**
     * Devuelve el elemento que es sucesor derecho de i
     * 
     * @param i indice del que se busca su sucesor derecho
     * @return el elemento que es sucesor derecho de i
     */
    private Elemento<T> getSucDer(int i) {
        return monticulo.get(getIndiceSucDer(i));
    }

    /**
     * Devuelve el elemento que es antecesor de i
     * 
     * @param i indice del que se busca su antecesor
     * @return el elemento que es antecesor de i
     */
    private Elemento<T> getAntecesor(int i) {
        return monticulo.get(getIndiceAntecesor(i));
    }

    /**
     * Intercambia los elementos correspondientes a los indices i, j
     * 
     * @param i primer indice
     * @param j segundo indice
     */
    private void intercambiar(int i, int j) {
        Elemento<T> aux = monticulo.get(i);
        monticulo.set(i, monticulo.get(j));
        monticulo.set(j, aux);
    }

    /**
     * Inserta un dato en la cola de prioridad
     * 
     * @param prioridad prioridad del dato
     * @param dato      dato a insertar
     */
    public void insertar(int prioridad, T dato) {
        Elemento<T> nuevo = new Elemento<>(prioridad, dato);
        monticulo.add(nuevo);
        int actual = monticulo.size() - 1;
        while (tieneAntecesor(actual) && getAntecesor(actual).compareTo(monticulo.get(actual)) > 0) {
            intercambiar(getIndiceAntecesor(actual), actual);
            actual = getIndiceAntecesor(actual);
        }
    }

    /**
     * Devuelve el siguiente dato con la prioridad mas alta posible
     * 
     * @return el siguiente dato con la prioridad mas alta
     */
    public T obtenerSig() {
        if (monticulo.isEmpty())
            return null;
        Elemento<T> siguiente = monticulo.get(0);
        monticulo.set(0, monticulo.get(monticulo.size() - 1));
        monticulo.remove(monticulo.size() - 1);
        verificarMonticuloAbajo(0);
        return siguiente.getDato();
    }

    /**
     * Se verifica que se conserven las propiedades del monticulo a partir del
     * indice
     * 
     * @param indice indice desde donde comenzar la verificación
     */
    private void verificarMonticuloAbajo(int indice) {
        while (tieneSucIzq(indice)) {
            int indiceSucMin = getIndiceSucIzq(indice);
            if (tieneSucDer(indice) && getSucDer(indice).compareTo(getSucIzq(indice)) < 0) {
                indiceSucMin = getIndiceSucDer(indice);
            }
            if (monticulo.get(indice).compareTo(monticulo.get(indiceSucMin)) <= 0) {
                break;
            } else {
                intercambiar(indice, indiceSucMin);
            }
            indice = indiceSucMin;
        }
    }

    /**
     * Devuelve un String con los elementos en el montículo encerrados entre
     * parentesis
     * 
     * @return String con los elementos del monticulo
     */
    public String toString() {
        String cp = "[";
        for (Elemento<T> e : monticulo) {
            cp += "(" + e + ") ";
        }
        return cp + "]";
    }

}
