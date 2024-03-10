package EjemplosLaboratorio.ListaArreglosGenerica;

/**
 * Clase Principal, utiliza los metodos de una lista para
 * verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {

    public static void main(String[] args) {
        Lista<String> l1 = new Lista<String>(5);
        Lista<Integer> l2 = new Lista<Integer>(5);

        System.out.println("--------- Insertar al inicio a ---------");
        if(l1.insertarInicio("a")){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("--------- Insertar al inicio b ---------");
        if(l1.insertarInicio("b")){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("--------- Insertar al final c ---------");
        if(l1.insertarFinal("c")){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------ Insertar en la posicion 1 d -----");
        if(l1.insertar("d",1)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------ Insertar en la posicion 3 e -----");
        if(l1.insertar("e",3)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------ Insertar en la posicion 1 f -----");
        if(l1.insertar("f",1)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------------- Lista vacia? -------------");
        System.out.println("Lista vacia: "+l1.esVacia());
        System.out.println("----------------------------------------");

        System.out.println("------------- Lista llena? -------------");
        System.out.println("Lista llena: "+l1.esLlena());
        System.out.println("----------------------------------------");

        System.out.println("--------------- buscar d ---------------");
        int posicion = l1.buscar("d");
        if(posicion != -1){
            System.out.println("dato d encontrado en la posicion "+posicion);
        } else {
            System.out.println("dato d no encontrado");
        }
        System.out.println("----------------------------------------");

        System.out.println("--------------- buscar z ---------------");
        posicion = l1.buscar("z");
        if(posicion != -1){
            System.out.println("dato z encontrado en la posicion "+posicion);
        } else {
            System.out.println("dato z no encontrado");
        }
        System.out.println("----------------------------------------");

        System.out.println("---------- devolver posicion 3 ---------");
        System.out.println("Elemento en la posicion 3: "+l1.devolver(3));
        System.out.println("----------------------------------------");

        System.out.println("------ reemplazar posicion 3 por g -----");
        if(l1.reemplazar("g",3)){
            System.out.println("Reemplazo correcto");
        } else {
            System.out.println("No se pudo reemplazar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------------ eliminar inicio -----------");
        if(l1.eliminarInicio()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------------ eliminar final ------------");
        if(l1.eliminarFinal()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("---------- eliminar posicion 1 ---------");
        if(l1.eliminar(1)){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("---------- eliminar posicion 3 ---------");
        if(l1.eliminar(3)){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(l1.toString() + " longitud: " + l1.longitud());
        System.out.println("----------------------------------------");

        // probamos l2

        System.out.println("--------- Insertar al inicio 1 ---------");
        if(l2.insertarInicio(1)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("--------- Insertar al inicio 2 ---------");
        if(l2.insertarInicio(2)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("--------- Insertar al final 3 ---------");
        if(l2.insertarFinal(3)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------ Insertar en la posicion 1 4 -----");
        if(l2.insertar(4,1)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------ Insertar en la posicion 3 5 -----");
        if(l2.insertar(5,3)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------ Insertar en la posicion 1 6 -----");
        if(l2.insertar(6,1)){
            System.out.println("Insercion correcta");
        } else {
            System.out.println("No se pudo insertar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------------- Lista vacia? -------------");
        System.out.println("Lista vacia: "+l2.esVacia());
        System.out.println("----------------------------------------");

        System.out.println("------------- Lista llena? -------------");
        System.out.println("Lista llena: "+l2.esLlena());
        System.out.println("----------------------------------------");

        System.out.println("--------------- buscar 4 ---------------");
        posicion = l2.buscar(4);
        if(posicion != -1){
            System.out.println("dato 4 encontrado en la posicion "+posicion);
        } else {
            System.out.println("dato 4 no encontrado");
        }
        System.out.println("----------------------------------------");

        System.out.println("--------------- buscar 10 ---------------");
        posicion = l2.buscar(10);
        if(posicion != -1){
            System.out.println("dato 10 encontrado en la posicion "+posicion);
        } else {
            System.out.println("dato 10 no encontrado");
        }
        System.out.println("----------------------------------------");

        System.out.println("---------- devolver posicion 3 ---------");
        System.out.println("Elemento en la posicion 3: "+l2.devolver(3));
        System.out.println("----------------------------------------");

        System.out.println("------ reemplazar posicion 3 por 7 -----");
        if(l2.reemplazar(7,3)){
            System.out.println("Reemplazo correcto");
        } else {
            System.out.println("No se pudo reemplazar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------------ eliminar inicio -----------");
        if(l2.eliminarInicio()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("------------ eliminar final ------------");
        if(l2.eliminarFinal()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("---------- eliminar posicion 1 ---------");
        if(l2.eliminar(1)){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");

        System.out.println("---------- eliminar posicion 3 ---------");
        if(l2.eliminar(3)){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(l2.toString() + " longitud: " + l2.longitud());
        System.out.println("----------------------------------------");
    }
}
