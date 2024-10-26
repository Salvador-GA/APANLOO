/**
 * Clase Principal para probar las funciones de la tabla hash
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        TablaHashElem<Character> tblHash = new TablaHashElem<>(10);
        tblHash.insertar(new Elemento<Character>("a52se", 'a'));
        tblHash.insertar(new Elemento<Character>("b19as", 'b'));
        tblHash.insertar(new Elemento<Character>("r34pd", 'c'));
        tblHash.insertar(new Elemento<Character>("w47of", 'd'));
        tblHash.insertar(new Elemento<Character>("q83ig", 'e'));
        tblHash.insertar(new Elemento<Character>("j38uh", 'f'));
        tblHash.insertar(new Elemento<Character>("k08yj", 'g'));
        tblHash.insertar(new Elemento<Character>("h19tk", 'h'));
        tblHash.insertar(new Elemento<Character>("u40rl", 'i'));
        tblHash.insertar(new Elemento<Character>("t74ez", 'j'));
        tblHash.insertar(new Elemento<Character>("p91wx", 'k'));
        tblHash.insertar(new Elemento<Character>("z37qc", 'l'));
        tblHash.imprimirTabla();
        System.out.println("\nIndice de b: "+tblHash.buscar(new Elemento<Character>("b19as", 'b')));
        System.out.println("\nEliminando b");
        tblHash.eliminar(new Elemento<Character>("b19as", 'b'));
        tblHash.imprimirTabla();
    }
}
