package Juego.InfoJugador;

import Juego.Juego.GameIO;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Estadisticas {

    // Agrega un nuevo jugador
    public static void agregarJugadores(ArrayList<Jugador> jugadores) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Introduce el nombre del jugador: ");
        jugadores.add(new Jugador(scanner.nextLine()));
        System.out.println("Jugador añadido correctamente.");
    }

    // Muestra las estadísticas de todos los jugadores
    public static void mostrarEstadisticas(GameIO io, ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            io.print("No hay jugadores registrados todavía.");
            return;
        }

        for (Jugador jugador : jugadores) {
            if (jugador.getPartidasJugadas() > 0) {
                io.print("----------------------");
                mostrarEstadisticasIndividual(io, jugador);
                io.print("----------------------");
            }
        }
    }

    // Muestra las estadísticas de un jugador individual
    public static void mostrarEstadisticasIndividual(GameIO io, Jugador jugador) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        io.print("Jugador: " + jugador.getNombre());
        io.print("Partidas jugadas: " + jugador.getPartidasJugadas());
        io.print("Aciertos: " + jugador.getAciertos());

        if (!jugador.getHistorialPartidas().isEmpty()) {
            StringBuilder horasPartidas = new StringBuilder("Hora de partida/s: ");
            ArrayList<String> fechas = jugador.getFechasPartidas();
            horasPartidas.append(String.join(", ", fechas));
            io.print(horasPartidas.toString());
        }

    }
}
