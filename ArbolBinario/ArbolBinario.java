package ArbolBinario;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase ArbolBinario, almacena los nodos de un arbol binario, de tal forma que
 * cuando se va a agregar un nodo se necesita indicar cual será el nodo
 * antecesor/padre y luego se intenta agregar primero en el enlace izquierdo, si
 * ya esta ocupado entonces lo intenta agregar en el derecho, si tambiéne esta
 * ocupado indica el error/false.
 * 
 * @param <T>  el tipo del dato que contendrá cada Nodo.
 * @param raiz el nodo raiz del arbol.
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class ArbolBinario<T> {
    private Nodo<T> raiz; // Raíz del árbol binario.

    /**
     * Constructor por defecto, asigna la raiz a null
     */
    public ArbolBinario() {
        raiz = null;
    }

    /**
     * Constructor que crea un nodo con el dato proporcionado
     * 
     * @param dato para la raiz
     */
    public ArbolBinario(T dato) {
        raiz = new Nodo<T>(dato);
    }

    /**
     * Constructor que asigna un nodo raiz al arbol
     * 
     * @param raiz que se asignara al arbol
     */
    public ArbolBinario(Nodo<T> raiz) {
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
     * @param raiz nodo raiz para el arbol
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
        if (actual == null) { // No encontro el dato
            return null;
        } else if (buscado.equals(actual.getDato())) { // Se encontro el dato
            return actual;
        } else {
            /* Buscamos a la izquierda */
            Nodo<T> actualIzq = encontrarNodo(actual.getIzquierdo(), buscado);
            if (actualIzq != null) {
                return actualIzq;
            } else {
                /* Buscamos a la derecha */
                Nodo<T> actualDer = encontrarNodo(actual.getDerecho(), buscado);
                return actualDer;
            }
        }
    }

    /**
     * Funcion que regresa una referencia al nodo que contiene el dato buscado
     * 
     * @param buscado el dato a buscar
     * @return Referencia al nodo con el dato buscado, null si no existe
     */
    public Nodo<T> encontrarNodo(T buscado) {
        return encontrarNodo(raiz, buscado);
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
        if (actual == null) { // No encontro el dato
            return null;
        }
        if (actual.getIzquierdo() != null && buscado.equals(actual.getIzquierdo().getDato())) {
            /* Se encontro en el sucesor izquierdo */
            return actual;
        }
        if (actual.getDerecho() != null && buscado.equals(actual.getDerecho().getDato())) {
            /* Se encontro en el sucesor derecho */
            return actual;
        }
        /* Buscamos a la izquierda */
        Nodo<T> actualIzq = encontrarAntecesor(actual.getIzquierdo(), buscado);
        if (actualIzq != null) {
            return actualIzq;
        } else {
            /* Buscamos a la derecha */
            Nodo<T> actualDer = encontrarAntecesor(actual.getDerecho(), buscado);
            return actualDer;
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
    private int tam(Nodo<T> actual) {
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
     * @return devuelve el tamaño del nodo que contiene a dato o 0 si no existe
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
    private int altura(Nodo<T> actual) {
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
        if (actual != null) {
            return altura(actual);
        } else {
            return 0;
        }
    }

    /**
     * Intenta insertar un dato en el arbol como subarbol del dato antecesor, si el
     * arbol esta vacio entonces el dato se inserta en la raiz, sin tomar en cuenta
     * el parametro antecesor
     * 
     * @param dato      que contendra el nuevo nodo
     * @param antecesor que sera el padre del nuevo nodo
     * @return true si pudo ser insertado correctamente false en caso de existir ya
     *         el dato, o si el antecesor no existe, o si sus enlaces izquierdo y
     *         derecho ya estan ocupados
     */
    public boolean insertarDato(T dato, T antecesor) {
        if (esVacio()) {
            /* Se inserta el nodo en la raiz */
            raiz = new Nodo<T>(dato);
            return true;
        } else {
            /* Verificamos que el dato no exista ya en el arbol */
            if (encontrarNodo(dato) != null) {
                return false;
            } else {
                /* Busca el antecesor */
                Nodo<T> antecesorNodo = encontrarNodo(antecesor);
                if (antecesorNodo == null) {
                    return false;
                } else {
                    Nodo<T> nuevo = new Nodo<T>(dato);
                    if (antecesorNodo.getIzquierdo() == null) {
                        /* Se inserta en el lado izquiero */
                        antecesorNodo.setIzquierdo(nuevo);
                        return true;
                    } else if (antecesorNodo.getDerecho() == null) {
                        /* Se inserta en el lado derecho */
                        antecesorNodo.setDerecho(nuevo);
                        return true;
                    } else {
                        /* El antecesor tiene ambos enlaces ocupados */
                        return false;
                    }
                }
            }
        }
    }

    /**
     * Libera un nodo que se desea eliminar de manera recursiva, si el nodo tiene
     * sucesor izquierdo o derecho, se reemplaza el dato del sucesor al nodo actual
     * y entonces se intenta liberar el nodo sucesor. Si el nodo no tiene sucesores
     * entonces se actualiza al antecesor para que deje de apuntarlo
     * 
     * @param aEliminar el nodo que actualmente se quiere liberar
     * @param antecesor el antecesor de aEliminar
     */
    public void liberarNodo(Nodo<T> aEliminar, Nodo<T> antecesor) {
        if (aEliminar.getIzquierdo() != null) {
            /* Tiene sucesor izquiero */
            aEliminar.setDato(aEliminar.getIzquierdo().getDato());
            liberarNodo(aEliminar.getIzquierdo(), aEliminar);
        } else if (aEliminar.getDerecho() != null) {
            /* Tiene sucesor derecho */
            aEliminar.setDato(aEliminar.getDerecho().getDato());
            liberarNodo(aEliminar.getDerecho(), aEliminar);
        } else {
            if (antecesor == null) {
                /* El nodo a liberar es la raiz */
                raiz = null;
            } else {
                /* El nodo a liberar es una hoja */
                if (antecesor.getIzquierdo() == aEliminar) {
                    antecesor.setIzquierdo(null);
                } else {
                    antecesor.setDerecho(null);
                }
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
     * @return true si el dato existe para poder ser eliminado, false en otro
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
        cola.add(raiz); // Comenzamos con la raiz
        while (!cola.isEmpty()) {
            /* El tamaño actual de la cola es la cantidad de nodos en el nivel */
            int nodosEnNivel = cola.size();
            while (nodosEnNivel > 0) {
                aux = cola.peek();
                /* Imprimimos al siguiente nodo en la cola */
                System.out.print(aux.getDato() + " ");
                if (aux.getIzquierdo() != null) {
                    /* Agregamos al sucesor izquierdo a la cola */
                    cola.add(aux.getIzquierdo());
                }
                if (aux.getDerecho() != null) {
                    /* Agregamos al sucesor derecho a la cola */
                    cola.add(aux.getDerecho());
                }
                cola.remove();
                nodosEnNivel--;
            }
            /* Damos un salto de linea para marcar el fin de un nivel */
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Muestra la estructura arbol de forma horizontal, utilizando la recursividad
     * 
     * @param actual  el nodo que se esta visitando en ese momento
     * @param espacio el numero de espacios a mostrar antes de cada nodo
     */
    private void mostrarArbol(Nodo<T> actual, int espacio) {
        /* Avanzamos 10 espacios para el siguiente nivel */
        espacio += 10;
        if (actual == null) {
            /* Imprimimos los enlaces null para observar la estructura completa */
            System.out.println();
            for (int i = 0; i < espacio; i++) {
                System.out.print(" ");
            }
            System.out.println("null");
            return;
        }
        /* Primero mostramos la estructura del sucesor derecho */
        mostrarArbol(actual.getDerecho(), espacio);
        /* Imprimimos el nodo actual */
        System.out.println();
        for (int i = 0; i < espacio; i++) {
            System.out.print(" ");
        }
        System.out.println(actual.getDato());
        /* Mostramos la estructura del sucesor izquierdo */
        mostrarArbol(actual.getIzquierdo(), espacio);
    }

    /**
     * Invoca la función recursiva para mostrar la estructura del arbol
     */
    public void mostrarArbol() {
        System.out.println("----------------------------------------------------");
        mostrarArbol(raiz, -5);
        System.out.println("----------------------------------------------------");
    }
}
