package EjemplosLaboratorio.ClaseGenericaDosTipos;

/**
 * Clase persona que utiliza 2 tipos genericos, TN para el nombre y TE para la
 * edad
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Persona<TN, TE> {
    private TN nombre;
    private TE edad;

    /**
     * Constructor de la clase persona
     * 
     * @param nombre de la persona
     * @param edad   de la persona
     */
    public Persona(TN nombre, TE edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Regresa el nombre y edad de la persona en un String
     * 
     * @return String con el nombre y la edad
     */
    public String toString() {
        return "La persona " + this.nombre + " tiene " + this.edad + " años.";
    }

}
