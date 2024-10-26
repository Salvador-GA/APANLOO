import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase GrafoListaAdyacencia que imlpementa la representacion de lista de
 * adyacencias, esta implementacion es para un grafo no dirigido sin pesos
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class GrafoListaAdyancencia {
    private ArrayList<LinkedList<Integer>> listaAdyacencia;
    private int numVertices;

    /**
     * Constructor de la clase, inicializa los atributos
     */
    public GrafoListaAdyancencia() {
        listaAdyacencia = new ArrayList<>();
        numVertices = 0;
    }

    /**
     * Funcion para determinar si el grafo esta vacio
     *
     * @return verdadero si no tiene vertices, falso en caso contrario
     */
    public boolean esVacio() {
        return (numVertices == 0);
    }

    /**
     * Funcion para determinar is un vertice existe en el grafo
     *
     * @param v vertice que se quiere comprobar
     * @return verdadero si v pertenece al grafo, falso en caso contrario
     */
    public boolean existeVertice(int v) {
        return (v >= 0 && v < numVertices);
    }

    /**
     * Funcion para encontrar el grado de un vertice
     *
     * @param v vertice del que se quiere conocer su grado
     * @return grado de v
     */
    public int gradoVertice(int v) {
        if (existeVertice(v)) {
            return listaAdyacencia.get(v).size();
        }
        return 0;
    }

    /**
     * Funcion para devolver el numero de aristas en el grafo
     *
     * @return numero de aristas
     */
    public int numAristas() {
        int numAristas = 0;
        for (LinkedList<Integer> lista : listaAdyacencia) {
            numAristas += lista.size();
        }
        return numAristas / 2;
    }

    /**
     * Funcion para devolver el numero de vertices en el grafo
     *
     * @return numero de vertices
     */
    public int numVertices() {
        return numVertices;
    }

    /**
     * Funcion pa devolver la lista de vertices del grafo
     *
     * @return lista de vertices
     */
    public ArrayList<Integer> getVertices() {
        int vertice = 0;
        ArrayList<Integer> vertices = new ArrayList<>();
        while (vertice < numVertices) {
            vertices.add(vertice++);
        }
        return vertices;
    }

    /**
     * Funcion para devolver las aristas del grafo
     *
     * @return lista de aristas
     */
    public ArrayList<String> getAristas() {
        ArrayList<String> listaDeAristas = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            for (Integer nodo : listaAdyacencia.get(i)) {
                String arista = "(" + nodo + ", " + i + ")";
                boolean existe = false;
                for (String ar : listaDeAristas) {
                    if (ar.equals(arista)) {
                        existe = true;
                    }
                }
                if (!existe) {
                    listaDeAristas.add("(" + i + ", " + nodo + ")");
                }
            }
        }
        return listaDeAristas;
    }

    /**
     * Funcion para devolver la lista de vecinos de un vertice
     *
     * @param v vertice del que se quiere saber sus vecinos
     * @return lista de vecino
     */
    public ArrayList<Integer> getVecinos(int v) {
        ArrayList<Integer> vecinos = new ArrayList<>();
        if (existeVertice(v)) {
            for (Integer nodo : listaAdyacencia.get(v)) {
                vecinos.add(nodo);
            }
        }
        return vecinos;
    }

    /**
     * Metodo para agregar un vertice al grafo
     */
    public void agregarVertice() {
        listaAdyacencia.add(new LinkedList<Integer>());
        numVertices++;
    }

    /**
     * Metodo para agregar una arista al grafo
     *
     * @param v vertice origen
     * @param w vertice destino
     */
    public void agregarArista(int v, int w) {
        if (!existeVertice(v) || !existeVertice(w)) {
            System.out.println("Vértices no válidos");
        } else {
            // como es un grafo no dirigido se agrega la arista en ambos sentidos
            listaAdyacencia.get(v).add(w);
            listaAdyacencia.get(w).add(v);
        }
    }

    /**
     * Metodo para imprimir la representacion en lista de adyacencias del grafo
     */
    public void mostrarGrafo() {
        System.out.print("\nListas de Adyacencia: \n");
        for (LinkedList<Integer> linea : listaAdyacencia) {
            for (Integer nodo : linea) {
                System.out.print(nodo + " ");
            }
            System.out.println();
        }
    }
}