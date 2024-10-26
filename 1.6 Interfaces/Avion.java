/**
 * Clase Avion, implementa los metodos de la interface Aereos
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Avion implements Aereos {
    public void acelerar() {
        System.out.println("Acelerando el avion");
    }

    public void frenar() {
        System.out.println("Frenando el avion");
    }

    public void girar(String sentido) {
        System.out.println("Girando hacia " + sentido);
    }

    public void despegar() {
        System.out.println("El avion va a despegar");
    }

    public void aterrizar() {
        System.out.println("El avion va a aterrizar");
    }
}
