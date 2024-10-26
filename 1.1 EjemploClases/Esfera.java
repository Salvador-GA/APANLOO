/**
 * Clase que representa una Esfera a partir del radio 
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
 public class Esfera {
    private double radio;

    /**
     * Constructor de la clase para inicializar el radio
     * 
     * @param radio el valor del radio
     */
    public Esfera(double radio) {
        this.radio = radio;
    }

    /**
     * Constructor de la clase para inicializar el radio a 0
     */
    public Esfera() {
        radio = 0.0;
    }

    /**
     * Metodo para devolver el valor del radio
     * 
     * @return el valor del radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Metodo para asignar un valor al radio
     * 
     * @param radio valor del radio
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

    /**
     * Metodo para calcular el radio de la esfera
     * 
     * @return superficie de la esfera
     */
    public double superficie() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }

    /**
     * Metodo que devuelve la informacion de la esfera en un String
     * 
     * @return Informacion de la esfera en un String
     */
    public String toString() {
        return "Radio = " + radio;
    }
}