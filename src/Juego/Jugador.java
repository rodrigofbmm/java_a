package Juego;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int partidasJugadas;
    private int aciertos;
    private static final ArrayList<Jugador> jugadores = new ArrayList<>();
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidasJugadas = 0;
        this.aciertos = 0;
    }

    public static void agregarJugadores(ArrayList<Jugador> jugadores) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del jugador: ");
        String nombre = scanner.nextLine();
        jugadores.add(new Jugador(nombre));
        System.out.println("Jugador añadido correctamente.");
    }


    public static void mostrarEstadisticas (GameIO io, ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados todavía.");
            return;
        }

        Jugador primero = jugadores.get(0);
        primero.mostrarEstadisticasIndividual(io);
    }

    public void registrarPartida(boolean acierto) {
        partidasJugadas++;
        if (acierto) aciertos++;
    }

    public String getNombre() {
        return nombre;
    }


    public void mostrarEstadisticasIndividual(GameIO io) {
        io.print("Jugador: " + nombre);
        io.print("Partidas jugadas: " + partidasJugadas);
        io.print("Aciertos: " + aciertos);
    }


}
