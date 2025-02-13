public class Main {
    public static void main(String[] args){
        Caja<String> cajaDePalabras = new Caja<String>("Hola, mundo");
        System.out.println(cajaDePalabras.getContenido());
        Caja<Integer> cajaDeNumeros = new Caja<Integer>(123);
        System.out .println(cajaDeNumeros.getContenido());
    }
}