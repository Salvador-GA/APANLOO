import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase TablaHashInt almacena enteros en una tabla hash usando la función
 * modulo y la tecnica de resolucion de colisiones de encadenamiento separado,
 * el elemento que se guarda tambien hace la funcion de la clave
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class TablaHashInt {
    private ArrayList<LinkedList<Integer>> tabla;
    private int m; // valor que se utiliza para el modulo y determina la capacidad real

    /**
     * Constructor de la clase, encuentra el primo mas grande m que sea menor a la
     * capacidad deseada y crea la tabla con capacidad m, de cualquier forma las
     * listas a partir de m hasta capacidad quedarian sin utilizarse por lo que no
     * es necesario crearlas
     * 
     * @param capacidad capacidad deseada para la tabla, aunque en realidad la
     *                  capacidad sera igual al primo mas grande menor que capacidad
     */
    public TablaHashInt(int capacidad) {
        encontrarPrimo(capacidad);
        tabla = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tabla.add(new LinkedList<>());
        }
    }

    /**
     * Metodo para encontrar el primo mas grande menor que la capacidad deseada
     * 
     * @param capacidad capacidad deseada para la tabla, aunque en realidad la
     *                  capacidad sera igual al primo mas grande menor que capacidad
     */
    private void encontrarPrimo(int capacidad) {
        for (int i = capacidad; i > 0; i--) {
            boolean esPrimo = true;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                m = i;
                break;
            }
        }
    }

    /**
     * Funcion hash que utiliza la operacion modulo para devolver el valor de la
     * funcion hash
     * 
     * @param clave de la cual se desea su valor de la funcion hash
     * @return valor de la funcion hash
     */
    private int hashModulo(Integer clave) {
        return Math.abs(clave % m);
    }

    /**
     * Insertar elemento usando una función hash para obtener el indice del arreglo
     * donde se insertara
     * 
     * @param elemento a insertar
     */
    public void insertar(int elemento) {
        int indice = hashModulo(elemento);
        tabla.get(indice).add(elemento);
    }

    /**
     * Funcion que determina si existe un elemento en la tabla
     * 
     * @param elemento a buscar
     * @return verdadero si existe, falso en otro caso
     */
    public boolean existe(int elemento) {
        int indice = hashModulo(elemento);
        for (Integer elem : tabla.get(indice)) {
            if (elem.equals(elemento)) {
                return true;
            }
        }
        return false; // No encontrado
    }

    /**
     * Elimina un elemento de la tabla, si existe.
     * 
     * @param elemento que se desea eliminar
     */
    public void eliminar(int elemento) {
        int indice = hashModulo(elemento);
        tabla.get(indice).remove((Integer) elemento);
    }

    /**
     * Imprime todas las listas de la tabla hash
     */
    public void imprimirTabla() {
        for (int i = 0; i < m; i++) {
            System.out.print(i + "[ ");
            for (Integer elem : tabla.get(i)) {
                System.out.print(elem + " ");
            }
            System.out.println("]");
        }
    }
}
