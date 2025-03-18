package mx.unam.fciencias.edd.gato.modelo;

public class Jugador {

    private String nombreDeJugador;
    private Ficha tipoDeFicha;

    public enum Ficha {
        X, O
    }

    public Jugador(String nombreDeJugador, Ficha tipoDeFicha) {
        this.nombreDeJugador = nombreDeJugador;
        this.tipoDeFicha = tipoDeFicha;
    }

    public Ficha getTipoDeFicha() {
        return tipoDeFicha;
    }

    public String getNombreDeJugador() {
        return nombreDeJugador;
    }

    @Override
    public String toString() {
        return "El jugador " + nombreDeJugador + ", tiene la ficha " + tipoDeFicha + ".";
    }
}
