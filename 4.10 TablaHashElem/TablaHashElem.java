import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase TablaHashElem almacena objetos de la clase Elemento en una tabla hash
 * usando la función hashStrin y hashModulo y la tecnica de resolucion de
 * colisiones de encadenamiento separado
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class TablaHashElem<T> {
    private ArrayList<LinkedList<Elemento<T>>> tabla;
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
    public TablaHashElem(int capacidad) {
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
     * Genera un valor hash a partir de un String
     * 
     * @param clave
     * @return valor de la funcion hash
     */
    private int hashString(String clave) {
        int suma = 0;
        for (char c : clave.toCharArray()) {
            suma += c;
        }
        return hashModulo(suma); // Reutilizando hashModulo
    }

    /**
     * Insertar elemento usando una función hash para obtener el indice del arreglo
     * donde se insertara
     * 
     * @param elemento a insertar
     */
    public void insertar(Elemento<T> elemento) {
        int indice = hashString(elemento.getClave());
        tabla.get(indice).add(elemento);
    }

    /**
     * Funcion que determina si existe un elemento en la tabla
     * 
     * @param elemento a buscar
     * @return verdadero si existe, falso en otro caso
     */
    public boolean existe(Elemento<T> elemento) {
        int indice = hashString(elemento.getClave());
        return tabla.get(indice).contains(elemento);
    }

    /**
     * Funcion que determina si existe un elemento en la tabla
     * 
     * @param elemento a buscar
     * @return verdadero si existe, falso en otro caso
     */
    public int buscar(Elemento<T> elemento) {
        int indice = hashString(elemento.getClave());
        return tabla.get(indice).indexOf(elemento);
    }

    /**
     * Elimina un elemento de la tabla, si existe.
     * 
     * @param elemento que se desea eliminar
     */
    public void eliminar(Elemento<T> elemento) {
        int indice = hashString(elemento.getClave());
        tabla.get(indice).remove(elemento);
    }

    /**
     * Imprime todas las listas de la tabla hash
     */
    public void imprimirTabla() {
        for (int i = 0; i < m; i++) {
            System.out.print(i + " [ ");
            for (Elemento<T> elem : tabla.get(i)) {
                System.out.print(elem + " ");
            }
            System.out.println("]");
        }
    }
}
