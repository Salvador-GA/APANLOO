package EjemplosLaboratorio.ClaseGenericaDosTipos;

/**
 * Clase Principal, crea objetos de la clase Persona con 4 tipos diferentes de
 * datos
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {

    public static void main(String[] args) {
        // Crear una instancia de la clase Persona con un String y un Integer
        Persona<String, Integer> persona1 = new Persona<String, Integer>("Juan", 25);
        // Crear una instancia de la clase Persona con un String y un Integer
        Persona<Nombre, Double> persona2 = new Persona<Nombre, Double>(new Nombre("Juan", "Perez"), 25.5);

        // Imprimir el nombre y edad de persona1
        System.out.println(persona1.toString());
        // Imprimir el nombre y edad de persona2
        System.out.println(persona2.toString());
    }
}
