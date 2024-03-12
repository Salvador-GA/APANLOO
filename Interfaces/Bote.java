package Interfaces;

/**
 * Clase Bote, implementa los metodos de la interface Acuaticos
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Bote implements Acuaticos {
    public void acelerar() {
        System.out.println("Acelerando el bote");
    }

    public void frenar() {
        System.out.println("Frenando el bote");
    }

    public void girar(String sentido) {
        System.out.println("Girando hacia " + sentido);
    }

    public void anclar() {
        System.out.println("Anclando el bote");
    }

    public void desanclar() {
        System.out.println("Desanclando el bote");
    }
}
