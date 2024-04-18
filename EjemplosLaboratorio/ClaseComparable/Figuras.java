package ClaseComparable;

/**
 * Clase Figuras, implementa la interfaz Comparable de tipo Figuras
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Figuras implements Comparable<Figuras> {
    private int numLados;
    private double area;

    /**
     * Constructor de la clase con ambos parametros
     * 
     * @param numLados numero de lados que tiene una figura geometrica
     * @param area     area de la figura geometrica
     */
    public Figuras(int numLados, double area) {
        this.numLados = numLados;
        this.area = area;
    }

    /**
     * Regresa el numero de lados de la figura geometrica
     * 
     * @return devuelve un entero con el numeros de lados de la figura geometrica
     */
    public int getNumLados() {
        return numLados;
    }

    /**
     * Establece el numero de lados de la figura geometrica
     * 
     * @param numLados nuevo valor para los lados de la figura geometrica
     */
    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }

    /**
     * Devuelve el area de la figura geometrica
     * 
     * @return devuelve un doble con el area de la figura geometrica
     */
    public double getArea() {
        return area;
    }

    /**
     * Establece el area de la figura geometrica
     * 
     * @param area nueva cantidad del area de la figura geometrica
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Compara dos figuras geometricas con respecto al numero de lados y area
     * 
     * @param fig figura a comparar con el propio objeto
     * @return 0 si las figuras son iguales, 1 si el objeto actual es mas grande que
     *         fig y -1 en caso contrario
     */
    @Override
    public int compareTo(Figuras fig) {
        if (numLados == fig.getNumLados() && area == fig.getArea()) {
            return 0;
        } else if (numLados > fig.getNumLados() || (numLados == fig.getNumLados() && area > fig.getArea())) {
            return 1;
        } else {
            return -1;
        }
    }
}
