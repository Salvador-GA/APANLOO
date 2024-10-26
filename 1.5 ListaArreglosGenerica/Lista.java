import java.util.ArrayList;

/**
 * Clase Lista, implementada con ArrayList de tipo generico
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Lista<T> {
    private ArrayList<T> lista;
    private int tam;

    /**
     * Constructor que inicializa la lista con la cantidad maxima de datos
     * indicada por tam
     * 
     * @param tam cantidad maxima de datos en la lsita
     */
    public Lista(int tam) {
        lista = new ArrayList<T>(tam);
        this.tam = tam;
    }

    /**
     * Constructor que inicializa la lista con una cantidad maxima de 10 datos
     */
    public Lista() {
        lista = new ArrayList<T>(10);
        tam = 10;
    }

    /**
     * Devuelve verdadero si la lista esta vacia, falso en otro caso
     * 
     * @return verdadero con lista vacia, falso en otro caso
     */
    protected boolean esVacia() {
        return lista.isEmpty();
    }

    /**
     * Devuelve verdadero si la lista esta llena, falso en otro caso
     * 
     * @return verdadero con lista llena, falso en otro caso
     */
    protected boolean esLlena() {
        if (tam == lista.size()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve la longitud de la lista
     * 
     * @return longitud de la lista
     */
    protected int longitud() {
        return lista.size();
    }

    /**
     * Inserta un dato al inicio de la lista
     * 
     * @param dato a ser insertado
     * @return verdadero si se logra insertar, falso en caso contrario
     */
    protected boolean insertarInicio(T dato) {
        if (!esLlena()) {
            lista.add(0, dato);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserta un dato al final de la lista
     * 
     * @param dato a ser insertado
     * @return verdadero si se logra insertar, falso en caso contrario
     */
    protected boolean insertarFinal(T dato) {
        if (!esLlena()) {
            lista.add(lista.size(), dato);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserta un dato en la posicion indicada
     * 
     * @param dato     a ser insertado
     * @param posicion donde se debe insertar
     * @return verdadero si se logra insertar, falso en caso contrario
     */
    protected boolean insertar(T dato, int posicion) {
        if (!esLlena() && posicion >= 0 && posicion <= lista.size()) {
            if (posicion == 0) {
                return insertarInicio(dato);
            } else if (posicion == lista.size()) {
                return insertarFinal(dato);
            } else {
                lista.add(posicion, dato);
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Elimina un dato del inicio de la lista
     * 
     * @return verdadero si se logra eliminar, falso en caso contrario
     */
    protected boolean eliminarInicio() {
        if (!esVacia()) {
            lista.remove(0);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un dato del final de la lista
     * 
     * @return verdadero si se logra eliminar, falso en caso contrario
     */
    protected boolean eliminarFinal() {
        if (!esVacia()) {
            lista.remove(lista.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina el dato de la posicion indicada
     * 
     * @param posicion a eliminar
     * @return verdadero si se logra eliminar, falso en caso contrario
     */
    protected boolean eliminar(int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < lista.size()) {
            if (posicion == 0) {
                return eliminarInicio();
            } else if (posicion == lista.size() - 1) {
                return eliminarFinal();
            } else {
                lista.remove(posicion);
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Busca un dato en la lista
     * 
     * @param dato a buscar
     * @return posicion del dato si se encuentra, -1 en otro caso
     */
    protected int buscar(T dato) {
        if (!esVacia()) {
            return lista.indexOf(dato);
        } else {
            return -1;
        }
    }

    /**
     * Devuelve el dato en la posicion indicada
     * 
     * @param posicion para devolver el dato
     * @return el dato buscado, null si la posicion no es valida o no hay datos
     */
    protected T devolver(int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < lista.size()) {
            return lista.get(posicion);
        } else {
            return null;
        }
    }

    /**
     * Reemplaza un dato en la posicion indicada
     * 
     * @param dato     que reemplazara al de la posicion indicada
     * @param posicion en la que se reemplazara el dato
     * @return verdadero si se logra reemplazar, falso en caso contrario
     */
    protected boolean reemplazar(T dato, int posicion) {
        if (!esVacia() && posicion >= 0 && posicion < lista.size()) {
            lista.set(posicion, dato);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve los datos de la lista en un string
     */
    public String toString() {
        if (!esVacia()) {
            String datos = "[ ";
            for (T t : lista) {
                datos += t.toString() + " ";
            }
            datos += "]";
            return datos;
        } else {
            return "[]";
        }
    }

}
