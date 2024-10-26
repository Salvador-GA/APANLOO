/**
 * Clase Principal para probar los metodos de la clase ColaPrioridadMonticulo
 * 
 * @author Salvador Gonzalez Arelano
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        ColaPrioMonticulo<String> cola = new ColaPrioMonticulo<>();
        cola.insertar(0, "dato 1");
        cola.insertar(4, "dato 2");
        cola.insertar(3, "dato 3");
        cola.insertar(2, "dato 4");
        cola.insertar(1, "dato 5");
        cola.insertar(1, "dato 6");
        cola.insertar(2, "dato 7");
        cola.insertar(3, "dato 8");
        cola.insertar(4, "dato 9");
        cola.insertar(0, "dato 10");
        System.out.println(cola.toString());
        String elemento;
        while ((elemento = cola.obtenerSig())!= null){
            System.out.println(elemento);
        }
    }
}
