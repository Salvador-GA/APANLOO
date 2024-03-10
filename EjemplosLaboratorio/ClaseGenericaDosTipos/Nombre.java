package EjemplosLaboratorio.ClaseGenericaDosTipos;

/**
 * Clase Nombre, almacena el nombre, apellido paterno y apellido materno en
 * variables separadas
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Nombre {
    private String nombre;
    private String apPat;
    private String apMat;

    /**
     * Constructor de la clase Nombre, con ambos apellidos
     * 
     * @param nombre
     * @param apPat
     * @param apMat
     */
    public Nombre(String nombre, String apPat, String apMat) {
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
    }

    /**
     * Constructor de la clase Nombre, con un solo apellido
     * 
     * @param nombre
     * @param apPat
     */
    public Nombre(String nombre, String apPat) {
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = "";
    }

    /**
     * Devuelve el nombre completo separado por espacios
     * 
     * @return String con el cnombre completo
     */
    public String toString() {
        return nombre + " " + apPat + " " + apMat;
    }
}
