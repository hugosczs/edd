package mx.unam.fciencias.edd.gato.modelo;

public class Tablero {
    
    private Jugador.Ficha[][] tablero;

    public Tablero() {
        tablero = new Jugador.Ficha[3][3];
    }

    public boolean setFicha(int renglón, int columna, Jugador.Ficha ficha) {
        
        if(renglón >= 0 && renglón < 3 && columna >= 0 && columna < 3 && tablero [renglón][columna] == null) {
            return true;
        }
        return false;
    }

    public Jugador.Ficha quienEsElGanador() {
        
        for(int i = 0; i < 3; i++) {
            if (tablero[i][0] != null && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return tablero[i][0];
            }
            if (tablero[0][i] != null && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
                return tablero[0][i];
            }
        }

        if (tablero[0][0] != null && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return tablero[0][0];
        }

        if (tablero[0][2] != null && tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return tablero [0][2];
        }
        return null;
    }

    public boolean tableroSinCasilas() {
        for(int i = 0; i <3 ; i++) {
            for(int j = 0; j <3 ; j++){
                if (tablero[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }


    public Jugador.Ficha[][] devuelveTablero() {
        return tablero;
    }

    public void imprimeTablero() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                if (tablero[i][j] == null) {
                    System.out.print("|   ");
                }
                else{
                    System.out.print("| " + tablero[i][j] + " ");
                }
            }
            System.err.println("|");
        }

    }
}


