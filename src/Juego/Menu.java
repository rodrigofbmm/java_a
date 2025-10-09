package Juego;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final ArrayList<Jugador> jugadores = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final GameIO io = new Consola();
    private final GuessGame game = new GuessGame(3);
    private final AppGame juego = new AppGame(game,io,jugadores);

    public void mostrarMenu() {
        int choice;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1 - Meter jugadores");
            System.out.println("2 - Jugar");
            System.out.println("3 - Ver estadísticas");
            System.out.println("4 - Salir");
            System.out.print("Opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> Jugador.agregarJugadores(jugadores);
                case 2 -> {
                    if (jugadores.isEmpty()) {
                        System.out.println("Primero agrega al menos un jugador.");
                    } else {
                        AppGame juego = new AppGame(new GuessGame(3), io, jugadores);
                        juego.start();
                    }
                }
                case 3 -> Jugador.mostrarEstadisticas(io,jugadores);
                case 4 -> System.out.println("Saliendo del juego...");
                default -> System.out.println("Solo opciones del 1 al 4.");
            }

        } while (choice != 4);
    }


    public static void main(String[] args) {

        new Menu().mostrarMenu();
    }
}
