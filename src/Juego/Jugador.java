package Juego;

public class Jugador {
    private String nombre;
    private int partidasJugadas;
    private int aciertos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidasJugadas = 0;
        this.aciertos = 0;
    }

    public void registrarPartida(boolean acierto) {
        partidasJugadas++;
        if (acierto) aciertos++;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarEstadisticas(GameIO io) {
        io.print("Jugador: " + nombre);
        io.print("Partidas jugadas: " + partidasJugadas);
        io.print("Aciertos: " + aciertos);
    }
}
