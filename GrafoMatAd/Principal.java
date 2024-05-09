package GrafoMatAd;

/**
 * Clase Principal para probar las funciones del grafo
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        GrafoMatAdyancencia g = new GrafoMatAdyancencia();
        // Agregando vertices y aristas al grafo
        for (int i = 0; i < 6; i++) {
            g.agregarVertice();
        }
        g.agregarArista(0, 1);
        g.agregarArista(0, 3);
        g.agregarArista(0, 5);
        g.agregarArista(1, 2);
        g.agregarArista(1, 3);
        g.agregarArista(2, 3);
        g.agregarArista(2, 4);
        g.agregarArista(2, 5);
        g.agregarArista(3, 4);
        g.agregarArista(4, 5);

        // Probamos las funciones del grafo
        System.out.println("Grafo vacío: " + g.esVacio());
        System.out.println("Cantidad de vertices: " + g.numVertices());
        System.out.println("Cantidad de aristas: " + g.numAristas());
        System.out.println("Lista de vertices: " + g.getVertices());
        System.out.println("Lista de aristas: " + g.getAristas());
        System.out.print("Impresión del grafo:\n");
        g.mostrarGrafo();
        System.out.println("Grado del vertice 2: " + g.gradoVertice(2));
        System.out.println("Vecinos del vertice 3: " + g.gradoVertice(3));
    }
}
