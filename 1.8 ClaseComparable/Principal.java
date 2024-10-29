/**
 * Clase Principal, para comprobar el funcionamiento del metodo compareTo de la
 * calse Figuras
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {

    public static void main(String[] args) {
        Figuras fig1 = new Figuras(3, 10);
        Figuras fig2 = new Figuras(3, 15);
        Figuras fig3 = new Figuras(4, 10);
        Figuras fig4 = new Figuras(4, 10);

        System.out.println(fig1.compareTo(fig2));
        System.out.println(fig1.compareTo(fig3));
        System.out.println(fig3.compareTo(fig2));
        System.out.println(fig3.compareTo(fig4));
    }

}
