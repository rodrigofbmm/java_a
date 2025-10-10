package Juego.InfoJugador;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fichero {

//Saca las estadisticas por txt
    public Fichero(ArrayList<Jugador> jugadores) {
        try (FileWriter writer = new FileWriter("estadisticas.txt")) {

            if (jugadores.isEmpty()) {
                writer.write("No hay jugadores registrados.\n");
            } else {
                for (Jugador j : jugadores) {
                    writer.write("Jugador: " + j.getNombre() + "\n");
                    writer.write("Partidas jugadas: " + j.getPartidasJugadas() + "\n");
                    writer.write("Aciertos: " + j.getAciertos() + "\n");
                    writer.write("-----------------------------\n");
                }
            }

            System.out.println("Estadísticas guardadas en 'estadisticas.txt' correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}
