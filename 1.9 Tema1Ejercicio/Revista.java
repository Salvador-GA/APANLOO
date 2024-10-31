/**
 * @file Revista.java
 * @brief Clase concreta que representa una revista, extiende de Material.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Revista extends Material {
    private int numeroEdicion;

    /**
     * Constructor de la clase Revista.
     * 
     * @param titulo        El título de la revista.
     * @param autor         El autor de la revista.
     * @param numeroEdicion El número de edición de la revista.
     */
    public Revista(String titulo, String autor, int numeroEdicion) {
        super(titulo, autor);
        this.numeroEdicion = numeroEdicion;
    }

    /**
     * Devuelve el numero de edición del material
     * 
     * @return numeroEdicion
     */
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Revista - Título: " + getTitulo() + ", Autor: " + getAutor()
                + ", Edición: " + numeroEdicion);
    }
}