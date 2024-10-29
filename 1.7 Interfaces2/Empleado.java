/**
 * @file Empleado.java
 * @brief Clase base Empleado que define los atributos y métodos comunes de un
 *        empleado.
 */
public class Empleado {
    private String nombre;
    private double salario;

    /**
     * Constructor de la clase Empleado.
     * 
     * @param nombre  El nombre del empleado.
     * @param salario El salario del empleado.
     */
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    /**
     * Método para obtener el nombre del empleado.
     * 
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener el salario del empleado.
     * 
     * @return El salario del empleado.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Método para mostrar los detalles del empleado.
     */
    public void mostrarDetalles() {
        System.out.println("Empleado: " + nombre + ", Salario: $" + salario);
    }
}