import java.util.Random;

/**
 * Clase principal para probar los metodos de la clase ArbolAVL.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArbolAVL<Persona> arbol = new ArbolAVL<>(); 
        // Nombres y apellidos para formar personas "aleatorias"
        String[] nombres = {"Juan", "Ana", "Luis", "María", "Pedro", "Elena", "Carlos", 
                            "Sofía", "Lucía", "Miguel"};
        String[] apellidos = {"Pérez", "García", "López", "Rodríguez", "Martínez", 
                              "Hernández", "González", "Díaz", "Torres", "Ramírez"};

        // Insertamos personas aleatorias al arbol
        for (int i = 0; i < 10; i++) {
            int id = rnd.nextInt(100); // ID aleatorio entre 0 y 99
            String nombre = nombres[rnd.nextInt(nombres.length)];
            String apellido = apellidos[rnd.nextInt(apellidos.length)];
            int edad = 18 + rnd.nextInt(50); // Edad entre 18 y 67
            arbol.insertarDato(new Persona(id, nombre, apellido, edad));
            arbol.mostrarArbol();
        }
        arbol.insertarDato(new Persona(9876, "Juan", "Díaz", 44));
        arbol.insertarDato(new Persona(9876, "Juan", "Díaz", 44));
        arbol.mostrarArbol();
        arbol.eliminarDato(new Persona(9876, "Juan", "Díaz", 44));
        arbol.mostrarArbol();
    }
}
