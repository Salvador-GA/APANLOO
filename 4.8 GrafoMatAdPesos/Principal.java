import java.util.ArrayList;

/**
 * Clase Principal para probar las funciones del grafo
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        GrafoMatAdPesos g = new GrafoMatAdPesos();
        // Agregando vertices y aristas al grafo
        for (int i = 0; i < 6; i++) {
            g.agregarVertice();
        }
        g.agregarArista(0, 1, 2);
        g.agregarArista(0, 3, 1);
        g.agregarArista(0, 5, 8);
        g.agregarArista(1, 2, 7);
        g.agregarArista(1, 3, 5);
        g.agregarArista(2, 3, 6);
        g.agregarArista(2, 4, 4);
        g.agregarArista(2, 5, 3);
        g.agregarArista(3, 4, 3);
        g.agregarArista(4, 5, 1);

        // Probamos las funciones del grafo
        System.out.println("Grafo vacío: " + g.esVacio());
        System.out.println("Cantidad de vertices: " + g.numVertices());
        System.out.println("Cantidad de aristas: " + g.numAristas());
        System.out.println("Lista de vertices: " + g.getVertices());
        System.out.println("Lista de aristas: " + g.getAristas());
        System.out.println("Grado del vertice 2: " + g.gradoVertice(2));
        System.out.println("Vecinos del vertice 3: " + g.gradoVertice(3));
        System.out.print("Impresión del grafo:\n");
        g.mostrarGrafo();
        System.out.println("\nRecorrido a partir de 1 primero en profundidad DFS:");
        g.DFS(1);
        System.out.println("\nRecorrido a partir de 1 primero en anchura BFS:");
        g.BFS(1);
        
        System.out.println("\nCaminos más cortos partiendo de 1: ");
        ArrayList<ArrayList<Integer>> caminos = g.Dijkstra(1);
        for (int i=0; i< caminos.size(); i++) {
            System.out.print("Camino mas corto a "+i+": ");
            for (Integer vertice : caminos.get(i)) {
                System.out.print(vertice+" ");
            }
            System.out.println();
        }
    }
}
