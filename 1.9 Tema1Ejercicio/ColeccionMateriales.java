/**
 * @file ColeccionMateriales.java
 * @brief Clase genérica para gestionar una colección de materiales en la biblioteca.
 * @tparam T El tipo de material, debe extender de Material.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class ColeccionMateriales<T extends Material> {
    private List<T> materiales;

    /**
     * Constructor de la clase ColeccionMateriales.
     */
    public ColeccionMateriales() {
        materiales = new ArrayList<>();
    }

    /**
     * Añade un material a la colección.
     * 
     * @param material El material a añadir.
     */
    public void agregarMaterial(T material) {
        materiales.add(material);
    }

    /**
     * Muestra los detalles de todos los materiales en la colección.
     */
    public void mostrarColeccion() {
        for (T material : materiales) {
            material.mostrarDetalles();
        }
    }
}

/**
 * Cual es la diferencia de escribir la clase como:
 * 
 * public class ColeccionMateriales<T extends Material> {
 *     private List<T> materiales;
 * 
 * En lugar de
 * 
 * public class ColeccionMateriales {
 *     private List<Material> materiales;
 * 
 * Usando la primera forma tenemos las siguientes Ventajas:
 * 
 * Flexibilidad de Tipos: La clase se puede instanciar para manejar tipos
 * específicos de Material, como ColeccionMateriales<Libro>,
 * ColeccionMateriales<Revista>, o cualquier otra subclase de Material. Esto
 * permite crear colecciones especializadas para cada subtipo de Material.
 * 
 * Seguridad de Tipos en Tiempo de Compilación: Al instanciar
 * ColeccionMateriales con un tipo específico (por ejemplo,
 * ColeccionMateriales<Libro>), Java asegura que solo se puedan agregar objetos
 * de ese tipo (Libro en este caso) a la colección, lo que ayuda a prevenir
 * errores de tipo en tiempo de compilación.
 * 
 * Polimorfismo Genérico: La clase ColeccionMateriales<T> es más versátil porque
 * puede usarse para almacenar cualquier subtipo de Material, permitiendo
 * manejar diferentes colecciones de forma segura sin comprometer la
 * verificación de tipos.
 * 
 * Usando la segunda forma tenemos las siguientes ventajas y desventajas
 * 
 * Ventajas:
 * Simplicidad: Al no usar genéricos, el código es más sencillo y directo. Se
 * puede usar para almacenar cualquier objeto que sea una instancia de Material
 * o de sus subclases sin tener que especificar un tipo genérico.
 * 
 * Conveniencia: Es más fácil de usar si siempre se desea una colección que
 * permita almacenar múltiples tipos de Material en la misma instancia, como
 * mezclar Libro y Revista en una misma colección.
 * 
 * Desventajas:
 * Falta de Seguridad de Tipos: No hay restricción en cuanto al tipo de Material
 * que se puede agregar. Esto significa que puedes mezclar diferentes subtipos
 * de Material en la misma colección, lo que podría generar problemas de tipo si
 * intentas procesar los elementos bajo el supuesto de que todos son del mismo
 * tipo.
 * 
 * Menos Flexibilidad en Colecciones Especializadas: No se pueden crear
 * colecciones que solo acepten un tipo específico de Material, como Libro o
 * Revista, por lo que la clase es menos flexible si necesitas manipular
 * colecciones homogéneas de un solo tipo de Material.
 */
/**
 * Cual es la utilidad de escribir
 * 
 * private List<T> materiales;
 * 
 * y luego crear el objeto como
 * 
 * materiales = new ArrayList<>();
 * 
 * La utilidad se basa en varios principios de diseño orientado a objetos:
 * 
 * 1. Principio de Abstracción y Flexibilidad
 * Abstracción: Al declarar materiales como un List<T>, nos enfocamos en el
 * comportamiento abstracto de una lista en lugar de en una implementación
 * específica. Esto hace que el código sea más fácil de mantener y comprender,
 * ya que trabaja con la interfaz general de una lista, sin preocuparse por los
 * detalles de cómo se almacena internamente.
 * Flexibilidad: Si en el futuro necesitas cambiar la implementación de List a
 * otro tipo, como LinkedList, no tendrás que modificar el resto del código que
 * usa materiales. Solo necesitas cambiar la inicialización a new
 * LinkedList<>(). Esto permite que el código sea flexible a cambios de
 * implementación sin afectar el diseño general.
 * 
 * 2. Facilita el Uso de Polimorfismo
 * Como List es una interfaz y ArrayList es una implementación de List, este
 * enfoque permite aprovechar el polimorfismo. En cualquier lugar del código,
 * puedes tratar materiales como un List, lo que te permite usar cualquiera de
 * las operaciones de la interfaz List sin preocuparte de los detalles de la
 * implementación.
 * También podrías reemplazar ArrayList por otras implementaciones de List que
 * puedan ajustarse mejor a las necesidades de tu aplicación sin romper el
 * código.
 * 
 * 3. Buena Práctica de Programación: Programar contra Interfaces
 * Programar contra una interfaz en lugar de una clase concreta (como ArrayList)
 * es una buena práctica en diseño de software. Esto sigue el principio de
 * diseño "programa hacia una interfaz, no hacia una implementación", que
 * fomenta la creación de software modular, reutilizable y menos dependiente de
 * implementaciones específicas.
 * Este enfoque también es útil en casos de pruebas, ya que facilita la
 * inyección de diferentes implementaciones de listas en materiales para simular
 * distintos comportamientos en pruebas.
 */