package ArbolAVL;

/**
 * Clase principal para probar los metodos de la clase ArbolAVL.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        ArbolAVL<Integer> arbol = new ArbolAVL<Integer>();
        arbol.insertarDato(0);
        arbol.insertarDato(2);
        arbol.insertarDato(3);
        arbol.insertarDato(4);
        arbol.insertarDato(6);
        arbol.insertarDato(8);
        arbol.insertarDato(7);
        arbol.insertarDato(5);
        arbol.insertarDato(9);
        arbol.insertarDato(10);
        arbol.insertarDato(1);
        arbol.mostrarArbol();
        arbol.eliminarDato(4);
        arbol.mostrarArbol();
        arbol.eliminarDato(2);
        arbol.mostrarArbol();
        arbol.eliminarDato(0);
        arbol.mostrarArbol();
        arbol.eliminarDato(1);
        arbol.mostrarArbol();
    }
}
