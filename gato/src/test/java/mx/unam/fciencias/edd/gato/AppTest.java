package mx.unam.fciencias.edd.gato;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import mx.unam.fciencias.edd.gato.lógica.Juego;
import mx.unam.fciencias.edd.gato.modelo.Jugador;

/**
 * Unas pruebas por acá...
 */
public class AppTest {

    /**
     * Rigorous Test :-) "Este texto ya estaba..."
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testSeCreaJuego() {
        Juego juego = new Juego("Hugo", "Camila");
        assertNotNull(juego.getTablero());
        assertEquals("Hugo", juego.getJugadorEnTurno().getNombreDeJugador());
    }

    @Test
    public void testTurnosAlternos() {
        Juego juego = new Juego("Hugo", "Camila");

        assertTrue(juego.esMiTurno(0, 0));
        assertEquals(Jugador.Ficha.X, juego.getTablero().devuelveTablero()[0][0]);

        assertTrue(juego.esMiTurno(1, 1));
        assertEquals(Jugador.Ficha.O, juego.getTablero().devuelveTablero()[1][1]);

        assertTrue(juego.esMiTurno(0, 1));
        assertEquals(Jugador.Ficha.X, juego.getTablero().devuelveTablero()[0][1]);
    }

    @Test
    public void testMovimientoInvalido() {
        Juego juego = new Juego("Hugo", "Camila");

        assertTrue(juego.esMiTurno(0, 0));
        assertFalse(juego.esMiTurno(0, 0));
    }

    @Test
    public void testVictoriaRenglón() {
        Juego juego = new Juego("Hugo", "Camila");

        juego.esMiTurno(0, 0);
        juego.esMiTurno(1, 0);
        juego.esMiTurno(0, 1);
        juego.esMiTurno(1, 1);
        juego.esMiTurno(0, 2);

        assertEquals("El ganador fue X.", juego.cómoVaElJuego());
    }

    @Test
    public void testEmpate() {
        Juego juego = new Juego("Hugo", "Camila");

        juego.esMiTurno(0, 0);
        juego.esMiTurno(0, 1);
        juego.esMiTurno(0, 2);
        juego.esMiTurno(1, 0);
        juego.esMiTurno(1, 1);
        juego.esMiTurno(1, 2);
        juego.esMiTurno(2, 0);
        juego.esMiTurno(2, 2);
        juego.esMiTurno(2, 1);

        assertEquals("Esto es un empate. Vuelvan a comenzar.", juego.cómoVaElJuego());
    }
}
