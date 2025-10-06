public class Principal {

    public static void main(String[] args) {
        Cuadrado c1 = new Cuadrado(2.0, "Rojo");
        Rectangulo r1 = new Rectangulo(2.0, 3.0, "Azul");
        Circulo circ1 = new Circulo(2.5, "Verde");

        System.out.println("-------------- Cuadrado --------------");
        System.out.println(c1.toString());
        System.out.println(c1.datosFigura());
        System.out.println();

        System.out.println("-------------- Rectangulo --------------");
        System.out.println(r1.toString());
        System.out.println(r1.datosFigura());
        System.out.println();

        System.out.println("-------------- Circulo --------------");
        System.out.println(circ1.toString());
        System.out.println(circ1.datosFigura());
        System.out.println();
    }

}
