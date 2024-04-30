package Monticulos;

/**
 * Clase principal para probar los metodos de la clase Monticulo.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        Monticulo<Integer> monticulo = new Monticulo<Integer>();
        monticulo.insertarDato(5);
        monticulo.insertarDato(3);
        monticulo.insertarDato(6);
        monticulo.insertarDato(1);
        monticulo.insertarDato(2);
        monticulo.insertarDato(8);
        monticulo.insertarDato(0);
        monticulo.insertarDato(9);
        monticulo.insertarDato(4);
        monticulo.insertarDato(7);
        monticulo.insertarDato(10);
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
        monticulo.eliminarDato();
        monticulo.mostrarArbol();
    }
}
