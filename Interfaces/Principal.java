package Interfaces;

/**
 * Clase Principal, crea objetos de las clases Avion, Bote, Coche e Hidroavion 
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        Avion avion = new Avion();
        avion.acelerar();
        avion.despegar();
        avion.aterrizar();
        avion.frenar();

        Bote bote = new Bote();
        bote.desanclar();
        bote.acelerar();
        bote.frenar();
        bote.anclar();
        
        Coche coche = new Coche();
        coche.acelerar();
        coche.frenar();

        Hidroavion hidroavion = new Hidroavion();
        hidroavion.desanclar();
        hidroavion.acelerar();
        hidroavion.despegar();
        hidroavion.aterrizar();
        hidroavion.frenar();
        hidroavion.anclar();
    }
}
