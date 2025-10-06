package ClaseAbstracta;

/**
 * Clase abstracta Figura, define los métodos que deben ser implementados por
 * las clases derivadas
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public abstract class Figura {

    private String color;

    /**
     * Asigna el color de la figura
     * 
     * @param color de la figura
    */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve el color de la figura
     * 
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Calcula el area de la figura
     * 
     * @return area
     */
    public abstract double calcularArea();

    /**
     * Calcula el perimetro de la figura
     * 
     * @return perimetro
     */
    public abstract double calcularPerimetro();

    /**
     * Devuelve la información de la figura en un String
     */
    public abstract String toString();

    /**
     * Devuelve los datos de la figura: color, area y perimetro
     * 
     * @return String con los datos de la figura
     */
    public String datosFigura(){
        return "Color: " + getColor() + ", Area: " + calcularArea() + ", Perimetro: " + calcularPerimetro();
    }

}
