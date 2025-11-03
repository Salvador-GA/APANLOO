/**
 * Clase Contador que representa el modelo en el patrón MVC.
 * Gestiona el valor de un contador.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Contador {
    private int valor;

    public int get() {
        return valor;
    }

    public void incrementar() {
        valor++;
    }

    public void reiniciar() {
        valor = 0;
    }
}