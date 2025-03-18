package mx.unam.fciencias.edd.gato.vista;

import java.util.Scanner;

import mx.unam.fciencias.edd.gato.lógica.Juego;
import mx.unam.fciencias.edd.gato.modelo.Jugador;

/*
 * Los nombres de los métodos que usé por acá hacen obvios los compartamientos de esta clase ;)
 */
public class Vista {
    private Juego juego;
    private Scanner scanner;

    public Vista (Juego juego){
        this.juego = juego;
        this.scanner = new Scanner(System.in);
    }

    public void entradaAlJuego(){
        System.out.println("B I E N V E N I D O  A L  J U E G O  D E L  G A T O");
        imprimeTablero();
    

        while(true){
            Jugador jugadorEnTurno = juego.getJugadorEnTurno();
            System.out.println("\n Es el turno de " + jugadorEnTurno.getNombreDeJugador() + " , con la ficha " + jugadorEnTurno.getTipoDeFicha() + ".");

            int renglón, columna;
            do{
                System.out.print("Elige un renglón [0-2]: ");
                renglón = leerNúmero();

                System.out.print("Elige una columna [0-2]: ");
                columna = leerNúmero();
            } while (!juego.esMiTurno(renglón, columna));

            imprimeTablero();

            String cómoVaElJuego = juego.cómoVaElJuego();
            if (cómoVaElJuego.equals("El ganador fue X.") || 
                cómoVaElJuego.equals("El ganador fue O.") || 
                cómoVaElJuego.equals("Esto es un empate. Vuelvan a comenzar.")) {
                System.out.println("\n" + cómoVaElJuego);
                break;
            }
        }   
    }

    private void imprimeTablero() {
        System.out.println("\nCómo va tablero: ");
        char[][] m = hazloChar();
        for(int i = 0; i < 3; i++){
            System.out.println(" " + m[i][0] + " | " + m[i][1] + " | " + m[i][2]);
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
    }

    /*
     * Esta cosa convierte el tablero a una matriz de caracteres para mostrar en la terminal :)
     * @return El tablero en forma de caracteres.
     */
    private char[][] hazloChar(){
        char[][] m = new char[3][3];
        Jugador.Ficha[][] tablero = juego.getTablero().devuelveTablero();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (tablero[i][j] == null) {
                    m[i][j] = ' ';
                }
                else {
                    m[i][j] = tablero[i][j].toString().charAt(0);
                }
            }
        }
        return m;
    }

    /*
     * Esta cosa lee el número que introduce cada jugador en la terminal.
     * @ return El número ingresado.
     */
    private int leerNúmero(){
        while (true) {
            try{
                int número = Integer.parseInt(scanner.nextLine().trim());
                if (número >= 0 && número < 3) {
                    return número;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("La entrada que ingresaste es inválida. Por favor introduce números en el rango [0,2].");
        }
    }
}
