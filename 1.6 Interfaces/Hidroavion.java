/**
 * Clase Hidroavion, implementa los metodos de las interfaces Aereos y Acuaticos
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Hidroavion implements Aereos, Acuaticos {
    public void acelerar() {
        System.out.println("Acelerando el hidroavion");
    }

    public void frenar() {
        System.out.println("Frenando el hidroavion");
    }

    public void girar(String sentido) {
        System.out.println("Girando hacia " + sentido);
    }

    public void despegar() {
        System.out.println("El hidroavion va a despegar");
    }

    public void aterrizar() {
        System.out.println("El hidroavion va a aterrizar");
    }

    public void anclar() {
        System.out.println("Anclando el hidroavion");
    }

    public void desanclar() {
        System.out.println("Desanclando el hidroavion");
    }
}
