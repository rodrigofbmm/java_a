package Juego.InfoJugador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int partidasJugadas;
    private int aciertos;
    private final ArrayList<Partida> historialPartidas = new ArrayList<>();

    //nombre
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    //partidas
    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    //aciertos
    public int getAciertos() {
        return aciertos;
    }

    //nombre
    public String getNombre() {
        return nombre;
    }

    // Registra partida/s
    public void registrarPartida(boolean acierto) {
        partidasJugadas++;
        if (acierto) aciertos++;
        historialPartidas.add(new Partida(LocalDateTime.now(), acierto));
    }

    //historias partidas
    public ArrayList<Partida> getHistorialPartidas() {
        return historialPartidas;
    }

    // historiasl fechas
    public ArrayList<String> getFechasPartidas() {
        ArrayList<String> fechas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        for (Partida p : historialPartidas) {
            fechas.add(p.fechaHora.format(formatter));
        }
        return fechas;
    }

    // Clase interna para guardar cada partida
    private static class Partida {
        private final LocalDateTime fechaHora;
        private final boolean acierto;

        public Partida(LocalDateTime fechaHora, boolean acierto) {
            this.fechaHora = fechaHora;
            this.acierto = acierto;
        }

        public LocalDateTime getFechaHora() {
            return fechaHora;
        }

        public boolean isAcierto() {
            return acierto;
        }
    }

}


