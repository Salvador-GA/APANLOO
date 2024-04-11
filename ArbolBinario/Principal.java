package ArbolBinario;

/**
 * Clase principal para probar los metodos de la clase ArbolBinario.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<Integer>();
        arbol.insertarDato(1, null);
        arbol.insertarDato(2, 1);
        arbol.insertarDato(3, 1);
        arbol.insertarDato(4, 2);
        arbol.insertarDato(5, 2);
        arbol.insertarDato(6, 3);
        arbol.insertarDato(7, 3);
        arbol.insertarDato(8, 4);
        arbol.insertarDato(9, 5);
        arbol.insertarDato(10, 7);
        System.out.println("La estructura del arbol es: ");
        arbol.mostrarArbol();
        System.out.println("La altura del arbol es: "+arbol.altura(1));
        System.out.println("El tamaño del nodo 3 es: "+arbol.tam(3));
        System.out.println("El recorrido InOrden: ");
        arbol.recorrerInorden();
        System.out.println("Eliminamos la raiz (1)");
        arbol.eliminarDato(1);
        System.out.println("La estructura del arbol es: ");
        arbol.mostrarArbol();
    }
}
