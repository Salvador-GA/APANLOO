package Interfaces;

/**
 * Clase Coche, implementa los metodos de la interface Terrestres
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Coche implements Terrestres {

    public void acelerar() {
        System.out.println("Acelerando el coche");
    }

    public void frenar() {
        System.out.println("Frenando el coche");
    }

    public void girar(String sentido) {
        System.out.println("Girando hacia " + sentido);
    }

    public void reversa() {
        System.out.println("El coche va de reversa");
    }

}
