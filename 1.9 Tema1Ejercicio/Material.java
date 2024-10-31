/**
 * @file Material.java
 * @brief Clase abstracta base que representa un material en la biblioteca.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public abstract class Material {
    private String titulo;
    private String autor;

    /**
     * Constructor de la clase Material.
     * 
     * @param titulo El título del material.
     * @param autor  El autor del material.
     */
    public Material(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    /**
     * Devuelve el titulo del material
     * 
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el autor del material
     * 
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Método abstracto para mostrar los detalles específicos del material.
     */
    public abstract void mostrarDetalles();
}