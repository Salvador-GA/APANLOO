/**
 * @file Libro.java
 * @brief Clase concreta que representa un libro, extiende de Material e
 *        implementa Prestamo.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Libro extends Material implements Prestamo {
    private boolean prestado;

    /**
     * Constructor de la clase Libro.
     * 
     * @param titulo El título del libro.
     * @param autor  El autor del libro.
     */
    public Libro(String titulo, String autor) {
        super(titulo, autor);
        this.prestado = false;
    }

    @Override
    public void prestar() {
        prestado = true;
    }

    @Override
    public void devolver() {
        prestado = false;
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Libro - Título: " + getTitulo() + ", Autor: " + getAutor() 
                + ", Prestado: " + (prestado ? "Sí" : "No"));
    }
}