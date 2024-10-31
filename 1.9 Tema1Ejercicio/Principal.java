/**
 * @file Principal.java
 * @brief Clase principal para ejecutar el sistema de gestión de biblioteca.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        // Crear instancias de libros de ciencia ficción relacionados con computación
        Libro libro1 = new Libro("Neuromante", "William Gibson");
        Libro libro2 = new Libro("Snow Crash", "Neal Stephenson");
        Libro libro3 = new Libro("The Diamond Age", "Neal Stephenson");
        Libro libro4 = new Libro("Mona Lisa Overdrive", "William Gibson");

        // Crear instancias de revistas de divulgación científica
        Revista revista1 = new Revista("Scientific American", "Varios", 2023);
        Revista revista2 = new Revista("Nature", "Varios", 2022);
        Revista revista3 = new Revista("IEEE Spectrum", "Varios", 2023);

        // Crear una colección genérica para materiales
        ColeccionMateriales<Material> coleccion = new ColeccionMateriales<>();

        // Agregar libros a la colección
        coleccion.agregarMaterial(libro1);
        coleccion.agregarMaterial(libro2);
        coleccion.agregarMaterial(libro3);
        coleccion.agregarMaterial(libro4);

        // Agregar revistas a la colección
        coleccion.agregarMaterial(revista1);
        coleccion.agregarMaterial(revista2);
        coleccion.agregarMaterial(revista3);

        // Mostrar detalles de la colección completa de materiales
        System.out.println("Colección de materiales:");
        coleccion.mostrarColeccion();

        // Ejemplo de préstamo de algunos libros
        System.out.println("\nPréstamo de libros:");
        libro1.prestar();
        libro2.prestar();
        coleccion.mostrarColeccion();

        // Devolver los libros
        System.out.println("\nDevolución de libros:");
        libro1.devolver();
        coleccion.mostrarColeccion();
    }
}