import java.util.Random;

/**
 * Clase Principal para probar las funciones de la tabla hash
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        TablaHashInt tbl = new TablaHashInt(10);
        Random r = new Random();
        for (int i=0; i<20; i++) {
            int valor = r.nextInt(100)+1;
            tbl.insertar(valor);
        }
        tbl.insertar(-10);
        tbl.imprimirTabla();
        System.out.println("\nEliminando el -10");
        tbl.eliminar(-10);
        tbl.imprimirTabla();
    }
}
