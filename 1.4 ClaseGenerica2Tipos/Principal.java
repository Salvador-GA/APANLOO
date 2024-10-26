/**
 * @file Principal.java
 * @brief Clase principal para ejecutar el ejemplo de CajaMezclada.
 */

public class Principal {

    public static void main(String[] args) {
        // Crear una CajaMezclada con diferentes tipos: String e Integer
        CajaMezclada<String, Integer> caja1 = new CajaMezclada<>("Etiqueta", 100);
        System.out.println(caja1.toString()); // Muestra: Primer Elemento: Etiqueta, Segundo Elemento: 100

        // Crear una CajaMezclada con diferentes tipos: Double y Boolean
        CajaMezclada<Double, Boolean> caja2 = new CajaMezclada<>(12.5, true);
        System.out.println(caja2.toString()); // Muestra: Primer Elemento: 12.5, Segundo Elemento: true

        // Crear una CajaMezclada con tipos complejos: String y una instancia de una
        // clase
        CajaMezclada<String, CajaMezclada<Integer, String>> caja3 = new CajaMezclada<>("Caja Principal",
                new CajaMezclada<>(1, "Interno"));
        System.out.println(caja3.toString()); // Muestra: Primer Elemento: Caja Principal, Segundo Elemento: Primer
                                              // Elemento: 1, Segundo Elemento: Interno

        /**
         * Crear un arreglo de CajaMezclada<?,?> para almacenar diferentes tipos de
         * objetos CajaMezclada<?,?> significa que el tipo dentro de la caja es
         * desconocido en tiempo de compilación. Esto permite que el arreglo pueda
         * almacenar instancias de Caja con diferentes tipos de contenido.
         */
        CajaMezclada<?, ?>[] cajas = new CajaMezclada<?, ?>[3];

        // Guardar diferentes tipos de datos en cada caja
        cajas[0] = caja1; // Caja que almacena String e Integer
        cajas[1] = caja2; // Caja que almacena Double y Boolean
        cajas[2] = caja3; // Caja que almacena String y una instancia de una clase

        // Mostrar el contenido de cada caja
        for (CajaMezclada<?, ?> caja : cajas) {
            System.out.println(caja.toString());
        }

        /**
         * Tambien podemos crear arreglos de cajas donde uno de los tipos si lo
         * especificamos y el otro no
         */
        CajaMezclada<String, ?>[] cajasS = new CajaMezclada[3];

        // Guardar diferentes tipos de datos en cada caja
        cajasS[0] = caja1; // Caja que almacena String e Integer
        cajasS[1] = new CajaMezclada<>("Hola", 10.10); // Caja que almacena String y Double
        cajasS[2] = caja3; // Caja que almacena String y una instancia de una clase

        // Mostrar el contenido de cada caja
        for (CajaMezclada<String, ?> caja : cajasS) {
            System.out.println(caja.toString());
        }
    }
}