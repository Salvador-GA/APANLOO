import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase ArbolAVL, almacena los nodos de un arbol binario, de tal forma que para
 * cualquier nodo del arbol se cumple que todos los nodos del subarbol izquierdo
 * son menores y todos los nodos del subarbol derecho son mayores, por
 * simplicidad no se admiten nodos repetidos. Además mantiene balanceado el
 * arbol, la diferencia de alturas entre el subarbol izquierdo y el subarbol
 * derecho para cualquier no no es mayor a 1
 * 
 * @param <T>  El tipo del dato que contendrá cada Nodo.
 * @param raiz El nodo raiz del arbol.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class ArbolAVL<T extends Comparable<T>> {
    private Nodo<T> raiz; // Raíz del árbol AVL.

    /**
     * Constructor por defecto, asigna la raiz a null
     */
    public ArbolAVL() {
        raiz = null;
    }

    /**
     * Constructor que crea un nodo con el dato proporionado
     * 
     * @param dato para la raiz
     */
    public ArbolAVL(T dato) {
        raiz = new Nodo<T>(dato);
    }

    /**
     * Constructor que asigna un nodo raiz al arbol
     * 
     * @param raiz que se asignara al arbol
     */
    public ArbolAVL(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Devuelve la referencia a la raiz
     * 
     * @return raiz del arbol
     */
    public Nodo<T> getRaiz() {
        return raiz;
    }

    /**
     * Establece la raiz del arbol
     * 
     * @param r nodo raiz para el arbol
     */
    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    /**
     * Verifica si el arbol esta vacio
     * 
     * @return true si es vacia, false en caso contrario
     */
    public boolean esVacio() {
        return raiz == null;
    }

    /**
     * Función recursiva para buscar un dato en el arbol, incialmente se llama con
     * los parametros actual=raiz y el dato buscado, por simplicidad el arbol no
     * contiene datos repetidos
     * 
     * @param actual  nodo en el cual se esta trabajando
     * @param buscado dato a buscar en el arbol
     * @return la referencia al nodo si existe, null en caso contrario
     */
    private Nodo<T> encontrarNodo(Nodo<T> actual, T buscado) {
        if (actual == null) {
            /* No encontro el dato */
            return null;
        } else if (buscado.equals(actual.getDato())) {
            /* Se encontro el dato */
            return actual;
        } else if (actual.getDato().compareTo(buscado) > 0) {
            /* Buscamos a la izquierda */
            return encontrarNodo(actual.getIzquierdo(), buscado);
        } else {
            /* Buscamos a la derecha */
            return encontrarNodo(actual.getDerecho(), buscado);
        }
    }

    /**
     * Función que regresa una referencia al nodo que contiene el dato buscado
     * 
     * @param buscado el dato a buscar
     * @return Referencia al nodo con el dato buscado, null si no existe
     */
    public Nodo<T> encontrarNodo(T buscado) {
        return encontrarNodo(raiz, buscado);
    }

    /**
     * Devuelve la referencia del descendiente con el dato mas chico del nodo actual
     * 
     * @param actual nodod del cual se quiere conocer su decendiente minimo
     * @return referencia al descendiente minimo, nulo si actual es nulo
     */
    public Nodo<T> entontrarDescendienteMin(Nodo<T> actual) {
        if (actual == null) {
            return null;
        } else {
            while (actual.getIzquierdo() != null) {
                /* Nos movemos lo mas a la izquierda posible */
                actual = actual.getIzquierdo();
            }
            /* actual apunta al nodo con el valor minimo */
            return actual;
        }
    }

    /**
     * Devuelve la referencia del descendiente con el dato mas grande del nodo
     * actual
     * 
     * @param actual nodod del cual se quiere conocer su decendiente maximo
     * @return referencia al descendiente maximo, nulo si actual es nulo
     */
    public Nodo<T> entontrarDescendienteMax(Nodo<T> actual) {
        if (actual == null) {
            return null;
        } else {
            while (actual.getDerecho() != null) {
                /* Nos movemos lo mas a la derecha posible */
                actual = actual.getDerecho();
            }
            /* actual apunta al nodo con el valor maximo */
            return actual;
        }
    }

    /**
     * Función recursiva para buscar al ancestro de un dato en el arbol, incialmente
     * se llama con los parametros actual=raiz y el dato buscado, por simplicidad el
     * arbol no contiene datos repetidos
     * 
     * @param actual  nodo en el cual se esta trabajando
     * @param buscado dato a buscar en el arbol
     * @return la referencia al antecesor si existe, null en caso contrario
     */
    private Nodo<T> encontrarAntecesor(Nodo<T> actual, T buscado) {
        if (actual == null) {
            /* No encontro el dato */
            return null;
        }
        if (actual.getIzquierdo() != null && buscado.equals(actual.getIzquierdo().getDato())) {
            /* Se encontro el dato en el descendiente izquierdo */
            return actual;
        }
        if (actual.getDerecho() != null && buscado.equals(actual.getDerecho().getDato())) {
            /* Se encontro el dato en el descendiente derecho */
            return actual;
        }
        if (actual.getDato().compareTo(buscado) > 0) {
            /* Buscamos a la izquierda */
            return encontrarAntecesor(actual.getIzquierdo(), buscado);
        } else {
            /* Buscamos a la derecha */
            return encontrarAntecesor(actual.getDerecho(), buscado);
        }
    }

    /**
     * Funcion que regresa la referencia del antecesor del dato buscado
     * 
     * @param buscado dato para buscar su antecesor
     * @return la referencia al antecesor si existe, null en caso contrario
     */
    public Nodo<T> encontrarAntecesor(T buscado) {
        return encontrarAntecesor(raiz, buscado);
    }

    /**
     * Función recursiva para regresar el tamaño de un nodo
     * 
     * @param actual nodo sobre el cual se trabaja actualmente
     * @return devuelve el tamaño del nodo actual
     */
    public int tam(Nodo<T> actual) {
        if (actual != null) {
            return tam(actual.getIzquierdo()) + tam(actual.getDerecho()) + 1;
        } else {
            return 0;
        }
    }

    /**
     * Devuelve el tamaño del nodo que contiene a dato
     * 
     * @param dato del nodo que se quiere saber su tamaño
     * @return devuelve el tamaño del nodo que contiene a dato o -1 si no existe
     *         dicho nodo
     */
    public int tam(T dato) {
        Nodo<T> actual = encontrarNodo(dato);
        return tam(actual);
    }

    /**
     * Devuelve la altura del nodo actual
     * 
     * @param actual nodo con el que se esta trabajando
     * @return la altura del nodo
     */
    public int altura(Nodo<T> actual) {
        if (actual != null) {
            int alturaIzq = altura(actual.getIzquierdo());
            int alturaDer = altura(actual.getDerecho());
            if (alturaIzq > alturaDer) {
                return 1 + alturaIzq;
            } else {
                return 1 + alturaDer;
            }
        } else {
            return -1;
        }
    }

    /**
     * Devuelve la altura del nodo que contiene a dato
     * 
     * @param dato del cual se quiere saber su altura
     * @return La altura del nodo que contiene a dato. Si este nodo no existe,
     *         devuelve 0.
     */
    public int altura(T dato) {
        Nodo<T> actual = encontrarNodo(dato);
        return altura(actual);
    }

    /**
     * Intenta insertar un dato en el arbol en el lugar que le corresponde
     * 
     * @param dato que contendra el nuevo nodo
     * @return true si pudo ser insertado correctamente false en caso de existir ya
     *         el dato
     */
    private Nodo<T> insertarDato(Nodo<T> actual, T dato) {
        if (actual == null) {
            return new Nodo<T>(dato);
        } else if (actual.getDato().compareTo(dato) > 0) {
            actual.setIzquierdo(insertarDato(actual.getIzquierdo(), dato));
        } else {
            actual.setDerecho(insertarDato(actual.getDerecho(), dato));
        }
        /* Se rebalancea el nodo actual y se regresa */
        return rebalancear(actual);
    }

    /**
     * Si el dato no existe entonces lo inserta de manera recursiva en su lugar
     * correspondiente
     * 
     * @param dato a insertar
     * @return verdadero si se logra insertar, falso en otro caso
     */
    public boolean insertarDato(T dato) {
        if (encontrarNodo(dato) == null) {
            raiz = insertarDato(raiz, dato);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Libera un nodo que se desea eliminar de manera recursiva, si el nodo tiene
     * sucesor izquierdo o derecho, se reemplaza el dato del sucesor al nodo actual
     * y entonces se intenta liberar el nodo sucesor. Si el nodo no tiene sucesores
     * entonces se actualiza al antecesor para que deje de apuntarlo
     * 
     * @param aEliminar el nodo que actualmente se quiere liberar
     * @param antecesor el antecesor del nodo a liberar
     */
    public void liberarNodo(Nodo<T> aEliminar, Nodo<T> antecesor) {
        Nodo<T> sustituto = entontrarDescendienteMax(aEliminar.getIzquierdo());
        if (sustituto != null) {
            /* Si existe un sustituto del lado izquierdo, entonces lo usamos */
            antecesor = encontrarAntecesor(sustituto.getDato());
            aEliminar.setDato(sustituto.getDato());
            liberarNodo(sustituto, antecesor);
        } else {
            sustituto = entontrarDescendienteMin(aEliminar.getDerecho());
            if (sustituto != null) {
                /* Si existe un sustituto del lado derecho, entonces lo usamos */
                antecesor = encontrarAntecesor(sustituto.getDato());
                aEliminar.setDato(sustituto.getDato());
                liberarNodo(sustituto, antecesor);
            } else if (antecesor == null) {
                /* El nodo a libnerar es la raiz */
                raiz = null;
            } else {
                /* Caso semilla */
                if (antecesor.getIzquierdo() == aEliminar) {
                    antecesor.setIzquierdo(null);
                } else {
                    antecesor.setDerecho(null);
                }
                /*
                 * al borrarse una hoja rebalanceamos a partir del antecesor hasta
                 * la raiz, para asegurarnos que no quede desbalanceado el arbol
                 */
                rebalanceHaciaArriba(antecesor);
            }
            aEliminar = null;
        }
    }

    /**
     * Se buscaa al nodo que contiene el dato que se desea eliminar, si existe se
     * busca a su antecesor (puede ser null si es la raiz la que se quiere eliminar)
     * y se libera el nodo
     * 
     * @param dato que se desea eliminar
     * @return verdadero si el dato existe para poder ser eliminado, falso en otro
     *         caso
     */
    public boolean eliminarDato(T dato) {
        Nodo<T> aEliminar = encontrarNodo(dato);
        if (aEliminar != null) {
            Nodo<T> antecesor = encontrarAntecesor(raiz, dato);
            liberarNodo(aEliminar, antecesor);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Procesa el recorrido InOrden del arbol
     * 
     * @param actual nodo actual de la recursion
     */
    private void recorrerInorden(Nodo<T> actual) {
        if (actual != null) {
            recorrerInorden(actual.getIzquierdo());
            System.out.print(actual.getDato() + " ");
            recorrerInorden(actual.getDerecho());
        }
    }

    /**
     * Invoca la funcion recursiva del recorrido InOrden, al final agrega un salto
     * de linea
     */
    public void recorrerInorden() {
        recorrerInorden(raiz);
        System.out.println();
    }

    /**
     * Procesa el recorrido PreOrden del arbol
     * 
     * @param actual nodo actual de la recursion
     */
    private void recorrerPreorden(Nodo<T> actual) {
        if (actual != null) {
            System.out.print(actual.getDato() + " ");
            recorrerPreorden(actual.getIzquierdo());
            recorrerPreorden(actual.getDerecho());
        }
    }

    /**
     * Invoca la funcion recursiva del recorrido PreOrden, al final agrega un salto
     * de linea
     */
    public void recorrerPreorden() {
        recorrerPreorden(raiz);
        System.out.println();
    }

    /**
     * Procesa el recorrido PostOrden del arbol
     * 
     * @param actual nodo actual de la recursion
     */
    private void recorrerPostorden(Nodo<T> actual) {
        if (actual != null) {
            recorrerPostorden(actual.getIzquierdo());
            recorrerPostorden(actual.getDerecho());
            System.out.print(actual.getDato() + " ");
        }
    }

    /**
     * Invoca la funcion recursiva del recorrido PostOrden, al final agrega un salto
     * de linea
     */
    public void recorrerPostorden() {
        recorrerPostorden(raiz);
        System.out.println();
    }

    /**
     * Imprime los datos del arbol por nivel, utilizando una cola como auxiliar
     */
    public void recorrerNivel() {
        Queue<Nodo<T>> cola = new LinkedList<>();
        Nodo<T> aux;
        cola.add(raiz);
        while (!cola.isEmpty()) {
            int nodosEnNivel = cola.size();
            while (nodosEnNivel > 0) {
                aux = cola.peek();
                System.out.print(aux.getDato() + " ");
                if (aux.getIzquierdo() != null) {
                    cola.add(aux.getIzquierdo());
                }
                if (aux.getDerecho() != null) {
                    cola.add(aux.getDerecho());
                }
                cola.remove();
                nodosEnNivel--;
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * muestra la estructura arbol de forma horizontal, utilizando la recursividad
     * 
     * @param actual  el nodo que se esta visitando en ese momento
     * @param espacio el numero de espacios a mostrar antes de cada nodo
     */
    private void mostrarArbol(Nodo<T> actual, int espacio) {
        espacio += 10;
        if (actual == null) {
            System.out.println();
            for (int i = 0; i < espacio; i++) {
                System.out.print(" ");
            }
            System.out.println("null");
            return;
        }
        mostrarArbol(actual.getDerecho(), espacio);
        System.out.println();
        for (int i = 0; i < espacio; i++) {
            System.out.print(" ");
        }
        System.out.println(actual.getDato());
        mostrarArbol(actual.getIzquierdo(), espacio);
    }

    /**
     * invoca la función recursiva para mostrar la estructura del arbol
     */
    public void mostrarArbol() {
        System.out.println("----------------------------------------------------");
        mostrarArbol(raiz, -5);
        System.out.println("----------------------------------------------------");
    }

    /**
     * Hace una rotación a la izquierda del nodo actual con su descendiente derecho
     * 
     * @param actual el nodo al cual se le realizara la rotacion
     * @return devuelve el nuevo valor de raiz para este subarbol
     */
    private Nodo<T> rotacionIzq(Nodo<T> actual) {
        Nodo<T> aux = actual.getDerecho();
        actual.setDerecho(aux.getIzquierdo());
        aux.setIzquierdo(actual);
        return aux;
    }

    /**
     * Hace una rotación a la derecha del nodo actual con su descendiente izquierdo
     * 
     * @param actual el nodo al cual se le realizara la rotacion
     * @return devuelve el nuevo valor de raiz para este subarbol
     */
    private Nodo<T> rotacionDer(Nodo<T> actual) {
        Nodo<T> aux = actual.getIzquierdo();
        actual.setIzquierdo(aux.getDerecho());
        aux.setDerecho(actual);
        return aux;
    }

    /**
     * Calcula el Factor de Equilibrio (FE) del nodo, haciendo la altura del
     * subarbol derecho menos la altura del subarbol izquierdo los posibles
     * resultados son:
     * FE < -1, el nodo está desbalanceado hacia la izquierda
     * FE = -1, el nodo está cargado hacia la izquierda, pero no desbalanceado
     * FE = 0, el nodo está balanceado, no está cargado hacia ningún lado
     * FE = 1, el nodo está cargado hacia la derecha, pero no desbalanceado
     * FE > 1, el nodo está desbalanceado hacia la derecha
     * 
     * @param actual el nodo del que se quiere saber su factor de balance
     * @return devuelve el factor de balance del nodo
     */
    private int factorEquilibrio(Nodo<T> actual) {
        if (actual == null) {
            return 0;
        } else {
            return altura(actual.getDerecho()) - altura(actual.getIzquierdo());
        }
    }

    /**
     * Rebalancea el subarbol que tiene como raiz el nodo actual
     * 
     * @param actual el nodo que actua como raiz del subarbol a rebalancear
     * @return la nueva raiz del subarbol rebalanceado
     */
    private Nodo<T> rebalancear(Nodo<T> actual) {
        int factorEq = factorEquilibrio(actual);
        if (factorEq < -1 && factorEquilibrio(actual.getIzquierdo()) <= 0) {
            /* Caso izquierda-izquierda */
            return rotacionDer(actual);
        } else if (factorEq < -1 && factorEquilibrio(actual.getIzquierdo()) > 0) {
            /* Caso izquierda-derecha */
            actual.setIzquierdo(rotacionIzq(actual.getIzquierdo()));
            return rotacionDer(actual);
        } else if (factorEq > 1 && factorEquilibrio(actual.getDerecho()) >= 0) {
            /* Caso derecha-derecha */
            return rotacionIzq(actual);
        } else if (factorEq > 1 && factorEquilibrio(actual.getDerecho()) < 0) {
            /* Caso derecha-izquierda */
            actual.setDerecho(rotacionDer(actual.getDerecho()));
            return rotacionIzq(actual);
        }
        return actual;
    }

    /**
     * Realiza el rebalanceo a partir del nodo actual y hasta la raiz
     * 
     * @param actual El nodo desde donde comenzar el rebalanceo
     */
    private void rebalanceHaciaArriba(Nodo<T> actual) {
        if (actual != null) {
            Nodo<T> antecesor = encontrarAntecesor(actual.getDato());
            if (antecesor != null && antecesor.getIzquierdo() == actual) {
                /* se rebalancea y actualiza el subarbol izquierdo de antecesor */
                antecesor.setIzquierdo(rebalancear(actual));
            } else if (antecesor != null) {
                /* se rebalancea y actualiza el subarbol derecho de antecesor */
                antecesor.setDerecho(rebalancear(actual));
            } else {
                /* se rebalancea y actualiza la raiz */
                raiz = rebalancear(actual);
            }
            rebalanceHaciaArriba(antecesor);
        }
    }

}
