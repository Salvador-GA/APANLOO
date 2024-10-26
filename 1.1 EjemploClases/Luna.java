/**
 * Clase Luna, deriva de la clase Esfera
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
final public class Luna extends Esfera {
    private String nombre;

    /**
     * Constructor que inicializa el radio y el nombre de la luna
     * 
     * @param radio  radio de la luna
     * @param nombre nombre de la luna
     */
    public Luna(double radio, String nombre) {
        super(radio);
        this.nombre = nombre;
    }

    /**
     * Metodo que devuelve la informacion de la Luna en un String
     * 
     * @return Informacion del planeta en un String
     */
    @Override
    public String toString() {
        return "Luna " + nombre + ", radio: " + getRadio();
    }
}