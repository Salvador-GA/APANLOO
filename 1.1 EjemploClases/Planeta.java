/**
 * Clase Planeta, deriva de la clase Esfera 
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class Planeta extends Esfera {
    private int numSatelites;

    /**
     * Constructor de la clase para inicializar el radio y el numero de satelites
     * 
     * @param radio        radio del planeta
     * @param numSatelites cantidad de satelites del planeta
     */
    public Planeta(double radio, int numSatelites) {
        super(radio);
        this.numSatelites = numSatelites;
    }

    /**
     * Constructor de la clase para inicializar el radio y el numero de satelites a
     * 0
     * 
     * @param radio radio del planeta
     */
    public Planeta(double radio) {
        super(radio);
        this.numSatelites = 0;
    }

    /**
     * Constructor de la clase para incializar el radio a 0 y el numero de satelites
     * a 0
     */
    public Planeta() {
        super();
        this.numSatelites = 0;
    }

    /**
     * Metodo para devolver el numero de satelites
     * 
     * @return numero de satelites
     */
    protected int getNumSatelites() {
        return numSatelites;
    }

    /**
     * Metodo para asignar el numero de satelites
     * 
     * @param numSatelites numero de satelites
     */
    protected void setNumSatelites(int numSatelites) {
        this.numSatelites = numSatelites;
    }

    /**
     * Metodo que devuelve la informacion del planeta en un String
     * 
     * @return Informacion del planeta en un String
     */
    public String toString() {
        String s = super.toString();
        return s + " Numero de satelites = " + numSatelites;
    }
}