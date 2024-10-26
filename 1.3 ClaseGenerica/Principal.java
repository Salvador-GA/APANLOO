/**
 * @file Principal.java
 * @brief Clase principal para ejecutar el ejemplo de clase genérica Caja.
 */

public class Principal {

    public static void main(String[] args) {
        // Crear una caja que almacena un número entero
        Caja<Integer> cajaEntero = new Caja<>(123);
        System.out.println(cajaEntero.toString()); // Muestra: Contenido de la caja: 123

        // Crear una caja que almacena una cadena de texto
        Caja<String> cajaCadena = new Caja<>("Hola Mundo");
        System.out.println(cajaCadena.toString()); // Muestra: Contenido de la caja: Hola Mundo

        // Cambiar el contenido de la caja
        cajaCadena.setContenido("Nuevo contenido");
        System.out.println(cajaCadena.toString()); // Muestra: Contenido de la caja: Nuevo contenido

        /**
         * Crear un arreglo de Caja<?> para almacenar diferentes tipos de objetos
         * Caja<?> significa que el tipo dentro de la caja es desconocido en tiempo de
         * compilación. Esto permite que el arreglo pueda almacenar instancias de Caja
         * con diferentes tipos de contenido.
         */
        Caja<?>[] cajas = new Caja<?>[3];

        // Guardar diferentes tipos de datos en cada caja
        cajas[0] = new Caja<>(123); // Caja que almacena un Integer
        cajas[1] = new Caja<>("Hola Mundo"); // Caja que almacena un String
        cajas[2] = new Caja<>(3.14); // Caja que almacena un Double

        // Mostrar el contenido de cada caja
        for (Caja<?> caja : cajas) {
            System.out.println(caja.toString());
        }
    }
}