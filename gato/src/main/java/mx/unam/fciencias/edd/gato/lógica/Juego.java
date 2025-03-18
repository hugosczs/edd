package mx.unam.fciencias.edd.gato.lógica;

import mx.unam.fciencias.edd.gato.modelo.Jugador;
import mx.unam.fciencias.edd.gato.modelo.Tablero;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private boolean turnoJugador1;

    /*
     * Constructor para incializar el juego con los nombres de cada jugador y les asigna fichas:
     * (X para el jugador 1, O para el jugador 2) :)
     * @param nombreJugador1 Nombre del jugador 1.
     * @param nombreJugador2 Nombre del jugador 2.
     */
    public Juego (String nombreJugador1, String nombreJugador2) {
        this.tablero = new Tablero();
        this.jugador1 = new Jugador(nombreJugador1, Jugador.Ficha.X);
        this.jugador2 = new Jugador(nombreJugador2, Jugador.Ficha.O);
        this.turnoJugador1 = true;
    }

    /*
     * Método para que el jugador en turno realice un movimiento.
     * @param renglón La fila donde se coloca la ficha en el rango [0-2].
     * @param columna La columna donde se coloca la ficha en el rango [0-2].
     * @return true si el movimiento realizado fue válido y la ficha se colocó correctamente, false en caso contrario :(
     */
    public boolean esMiTurno(int renglón, int columna) {

        Jugador.Ficha fichaEnTurno;

        if (turnoJugador1) {
            fichaEnTurno = jugador1.getTipoDeFicha();
        }
        else {
            fichaEnTurno = jugador2.getTipoDeFicha();
        }

        if (tablero.setFicha(renglón, columna, fichaEnTurno)) {
            tablero.devuelveTablero()[renglón][columna] = fichaEnTurno;
            turnoJugador1 = !turnoJugador1;
            return true;
        }
        return false;
    }
    
    /*
     * Esta cosa verifica el estado del juego, es decir, si hay un ganador, un empate o si sigue en progreso.
     * @return El estado actual del juego: ganador, empate, o si están en progreso.
     */
    public String cómoVaElJuego() {
        Jugador.Ficha ganador = tablero.quienEsElGanador();
        if (ganador != null) {
            if (ganador == Jugador.Ficha.X) {
                return "El ganador fue X.";
            }
            if (ganador == Jugador.Ficha.O) {
                return "El ganador fue O.";
            }
        } else if (tablero.tableroSinCasilas()) {
            return "Esto es un empate. Vuelvan a comenzar.";
        }
        return "¡Vamos! Esto está en progreso.";
    }

    /*
     * Devuelve el tablero actual.
     * @return El tablero actual.
     */
    public Tablero getTablero() {
        return tablero;
    }
    
    /*
     * Devuelve el jugador en turno.
     * @return El jugador con el turno actual.
     */
    public Jugador getJugadorEnTurno() {
        if (turnoJugador1) {
            return jugador1;
        }
        else {
            return jugador2;
        }
    }
}