import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Clase GrafoMatAdPesos que imlpementa la representacion de matriz de
 * adyacencias, esta implementacion es para un grafo no dirigido con pesos
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class GrafoMatAdPesos {
    private ArrayList<ArrayList<Integer>> matrizAdyacencia;
    private int numVertices;

    /**
     * Constructor de la clase, inicializa los atributos
     */
    public GrafoMatAdPesos() {
        matrizAdyacencia = new ArrayList<>();
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
        int grado = 0;
        if (existeVertice(v)) {
            for (Integer celda : matrizAdyacencia.get(v)) {
                if (celda > 0) {
                    grado++;
                }
            }
        }
        return grado;
    }

    /**
     * Funcion para devolver el numero de aristas en el grafo
     *
     * @return numero de aristas
     */
    public int numAristas() {
        int numAristas = 0;
        for (ArrayList<Integer> fila : matrizAdyacencia) {
            for (Integer celda : fila) {
                if (celda > 0) {
                    numAristas++;
                }
            }
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
            for (int j = i + 1; j < numVertices; j++) {
                if (matrizAdyacencia.get(i).get(j) > 0) {
                    listaDeAristas.add("[(" + i + ", " + j + "), " + matrizAdyacencia.get(i).get(j) + "]");
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
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia.get(v).get(i) > 0) {
                    vecinos.add(i);
                }
            }
        }
        return vecinos;
    }

    /**
     * Metodo para agregar un vertice al grafo
     */
    public void agregarVertice() {
        for (ArrayList<Integer> fila : matrizAdyacencia) {
            fila.add(0); // Añadir un nuevo elemento a cada fila existente
        }
        ArrayList<Integer> nuevaFila = new ArrayList<>();
        for (int i = 0; i <= numVertices; i++) {
            nuevaFila.add(0); // Crear una nueva fila para el nuevo vértice
        }
        matrizAdyacencia.add(nuevaFila);
        numVertices++;
    }

    /**
     * Metodo para agregar una arista al grafo
     *
     * @param v vertice origen
     * @param w vertice destino
     */
    public void agregarArista(int v, int w, int peso) {
        if (!existeVertice(v) || !existeVertice(w) || peso <= 0) {
            System.out.println("Vértices o peso no válidos");
        } else {
            matrizAdyacencia.get(v).set(w, peso);
            matrizAdyacencia.get(w).set(v, peso);
        }
    }

    /**
     * Metodo recursivo para imprimir el recorrido DFS
     * 
     * @param actual    vertice con el que se trabaja actualmente
     * @param visitados arreglo que indica que vertices han sido visitados
     */
    private void DFS(int actual, boolean[] visitados) {
        if (!visitados[actual]) {
            visitados[actual] = true;
            System.out.println("Vertice " + actual + " visitado");
            ArrayList<Integer> vecinos = getVecinos(actual);
            for (Integer vecino : vecinos) {
                if (!visitados[vecino]) {
                    DFS(vecino, visitados);
                }
            }
        }
    }

    /**
     * Metodo que imprime el recorrido primero en profundidad DFS
     * 
     * @param inicio vertice del cual inicia el recorrido
     */
    public void DFS(int inicio) {
        boolean[] visitados = new boolean[numVertices];
        DFS(inicio, visitados);
    }

    /**
     * Metodo que imprime el recorrido primero en anchura BFS
     * 
     * @param inicio vertice del cual inicia el recorrido
     */
    public void BFS(int inicio) {
        boolean[] visitados = new boolean[numVertices];
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);
        visitados[inicio] = true;
        System.out.println("Vertice " + inicio + " visitado");

        while (!cola.isEmpty()) {
            int v = cola.poll();
            ArrayList<Integer> vecinos = getVecinos(v);
            for (Integer vecino : vecinos) {
                if (!visitados[vecino]) {
                    visitados[vecino] = true;
                    System.out.println("Vertice " + vecino + " visitado");
                    cola.add(vecino);
                }
            }
        }
    }

    /**
     * Algoritmo de Dijkstra para devolver los caminos más cortos desde el nodo
     * origen a todos los demás nodos
     * 
     * @param origen El vértice de inicio
     * @return Una lista de listas, donde cada lista representa el camino más corto
     *         desde el origen hasta cada nodo
     */
    public ArrayList<ArrayList<Integer>> Dijkstra(int origen) {
        int[] distancias = new int[numVertices];
        int[] predecesores = new int[numVertices];
        boolean[] visitados = new boolean[numVertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(predecesores, -1);
        distancias[origen] = 0;

        PriorityQueue<Integer> cola = new PriorityQueue<>((v1, v2) -> distancias[v1] - distancias[v2]);
        cola.add(origen);

        while (!cola.isEmpty()) {
            int actual = cola.poll();

            if (!visitados[actual]) {
                visitados[actual] = true;
                ArrayList<Integer> vecinos = getVecinos(actual);
                for (Integer vecino : vecinos) {
                    if (!visitados[vecino]) {
                        int nuevaDistancia = distancias[actual] + matrizAdyacencia.get(actual).get(vecino);
                        if (nuevaDistancia < distancias[vecino]) {
                            distancias[vecino] = nuevaDistancia;
                            predecesores[vecino] = actual;
                            cola.add(vecino);
                        }
                    }
                }
            }
        }

        return reconstruirCaminos(predecesores, origen, distancias);
    }

    /**
     * Reconstruye todos los caminos más cortos desde el origen usando el arreglo de
     * predecesores
     * 
     * @param predecesores El array de predecesores generado por el algoritmo de
     *                     Dijkstra
     * @param origen       El nodo de origen desde el cual se calcularon los caminos
     * @return Una lista de listas de enteros, donde cada lista representa un camino
     *         desde el origen hasta cada nodo
     */
    private ArrayList<ArrayList<Integer>> reconstruirCaminos(int[] predecesores, int origen, int[] distancias) {
        ArrayList<ArrayList<Integer>> caminos = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            ArrayList<Integer> camino = new ArrayList<>();
            if (distancias[i] != Integer.MAX_VALUE) { // Hay un camino
                for (int actual = i; actual != -1; actual = predecesores[actual]) {
                    camino.add(0, actual);
                }
            }
            caminos.add(camino);
        }

        return caminos;
    }

    /**
     * Metodo para imprimir la representacion en lista de adyacencias del grafo
     */
    public void mostrarGrafo() {
        System.out.print("\nMatriz de Adyacencia: \n");
        for (ArrayList<Integer> linea : matrizAdyacencia) {
            for (Integer celda : linea) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }
}