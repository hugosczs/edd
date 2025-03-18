/*
 * UNAM | Facultad de Ciencias
 * Estructuras de Datos | 7048
 * Virginia Teodosio Procopio | Isaac Salvador Hernández Pompa
 * Sánchez García Hugo | 319251054
 */


package mx.unam.fciencias.edd.gato;

import mx.unam.fciencias.edd.gato.lógica.Juego;
import mx.unam.fciencias.edd.gato.vista.Vista;
import java.util.Scanner;


/**
 * Hello world! "Este texto ya estaba..."
 */
public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sé bienvenido al juego de gato");

        System.out.println("Jugador 1, ¿cuál es tu nombre?: ");
        String nombreDeJugador1 = scanner.nextLine();
        System.out.println("Jugador 2, ¿cuál es tu nombre?: ");
        String nombreDeJugador2 = scanner.nextLine();

        Juego juego = new Juego(nombreDeJugador1, nombreDeJugador2);
        Vista vista = new Vista(juego);

        vista.entradaAlJuego();
        scanner.close();
    }

}
