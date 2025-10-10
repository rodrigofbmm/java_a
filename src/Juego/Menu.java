package Juego;

import Juego.InfoJugador.Estadisticas;
import Juego.InfoJugador.Fichero;
import Juego.InfoJugador.Jugador;
import Juego.Juego.AppGame;
import Juego.Juego.Consola;
import Juego.Juego.GameIO;
import Juego.Juego.GuessGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final GameIO io = new Consola();

    //menu
    public void mostrarMenu() {
        int choice;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1 - Meter jugadores");
            System.out.println("2 - Jugar");
            System.out.println("3 - Ver estadísticas");
            System.out.println("4 - Sacar estadísticas a fichero");
            System.out.println("5 - Salir");
            System.out.print("Opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> Estadisticas.agregarJugadores(jugadores);
                case 2 -> {
                    if (jugadores.isEmpty()) {
                        System.out.println("\n¡No hay jugadores registrados!");
                        System.out.println("Primero debes crear al menos un jugador (Opción 1).");
                    } else {
                        Jugador jugadorSeleccionado = seleccionarJugador();
                        if (jugadorSeleccionado != null) {
                            ArrayList<Jugador> jugadorParaPartida = new ArrayList<>();
                            jugadorParaPartida.add(jugadorSeleccionado);

                            GuessGame game = new GuessGame(3);
                            AppGame juego = new AppGame(game, io, jugadorParaPartida);
                            juego.Acertar();
                        }
                    }
                }
                case 3 -> Estadisticas.mostrarEstadisticas(io, jugadores);
                case 4 -> System.out.println("Saliendo del juego...");
                case 5 -> new Fichero(jugadores);
                default -> System.out.println("Solo opciones del 1 al 5.");
            }

        } while (choice != 5);
    }

    //selecionar para el juego (mejorarlo )
    private Jugador seleccionarJugador() {
        System.out.println("=== SELECCIONAR JUGADOR ===");

        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println((i + 1) + " - " + jugadores.get(i).getNombre());
        }
        System.out.println("0 - Volver al menú");
        System.out.print("Selecciona un jugador: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next();
        }

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 0) {
            return null;
        }

        if (opcion > 0 && opcion <= jugadores.size()) {
            return jugadores.get(opcion - 1);
        } else {
            System.out.println("Opción inválida.");
            return null;
        }
    }

    public static void main(String[] args) {
        new Menu().mostrarMenu();
    }
}