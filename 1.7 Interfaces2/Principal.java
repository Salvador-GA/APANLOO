public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de EmpleadoGerente
        Gerente gerente = new Gerente("Carlos", 80000);

        // Mostrar detalles del gerente
        gerente.mostrarDetalles();

        // Invocar métodos de la interfaz Liderazgo
        gerente.asignarTareas();
        gerente.motivarEquipo();
    }
}
