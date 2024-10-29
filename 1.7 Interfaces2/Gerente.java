/**
 * @file EmpleadoGerente.java
 * @brief Clase EmpleadoGerente que hereda de Empleado e implementa la interfaz
 *        Liderazgo.
 */
public class Gerente extends Empleado implements Liderazgo {

    /**
     * Constructor de la clase EmpleadoGerente.
     * 
     * @param nombre  El nombre del gerente.
     * @param salario El salario del gerente.
     */
    public Gerente(String nombre, double salario) {
        super(nombre, salario); // Llama al constructor de la clase base Empleado
    }

    /**
     * Implementación del método asignarTareas() de la interfaz Liderazgo.
     */
    @Override
    public void asignarTareas() {
        System.out.println(getNombre() + " está asignando tareas al equipo.");
    }

    /**
     * Implementación del método motivarEquipo() de la interfaz Liderazgo.
     */
    @Override
    public void motivarEquipo() {
        System.out.println(getNombre() + " está motivando al equipo.");
    }

    /**
     * Sobrescritura del método mostrarDetalles() para incluir información de
     * liderazgo.
     */
    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Rol adicional: Gerente con habilidades de liderazgo.");
    }
}
