package GrafoMatAd;

import java.util.ArrayList;

/**
 * Clase GrafoMatAdyacencia que imlpementa la representacion de matriz de
 * adyacencias, esta implementacion es para un grafo no dirigido sin pesos
 *
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class GrafoMatAdyancencia {
    private ArrayList<ArrayList<Integer>> matrizAdyacencia;
    private int numVertices;

    /**
     * Constructor de la clase, inicializa los atributos
     */
    public GrafoMatAdyancencia() {
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
                    listaDeAristas.add("(" + i + ", " + j + ")");
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
    public void agregarArista(int v, int w) {
        if (!existeVertice(v) || !existeVertice(w)) {
            System.out.println("Vértices no válidos");
        } else {
            matrizAdyacencia.get(v).set(w, 1);
            matrizAdyacencia.get(w).set(v, 1);
        }
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