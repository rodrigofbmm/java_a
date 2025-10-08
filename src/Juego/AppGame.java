package Juego;

import java.util.ArrayList;
import java.util.Scanner;

public class AppGame {

    private final GuessGame game;
    private final GameIO io;
    private final ArrayList<Jugador> jugadores;

    public AppGame(GuessGame game, GameIO io, ArrayList<Jugador> jugadores) {
        this.game = game;
        this.io = io;
        this.jugadores = jugadores;
    }

    public void start() {
        Jugador jugador = jugadores.get(0);
        int vidas = game.getMaxVidas();
        io.print("Bienvenido al juego de adivinar (1-10)");
        io.print("Jugador: " + jugador.getNombre());
        io.print("Tienes " + vidas + " vidas.");

        boolean acierto = false; // Guardamos si ganó

        while (vidas > 0) {
            io.print("Introduce un número:");
            String input = io.read();
            Estado resultado = game.verificarInput(input);

            switch (resultado) {
                case SUCCESS -> {
                    io.print("¡Correcto! El número era " + game.getNumeroSecreto());
                    acierto = true;
                    vidas = 0; // salir del bucle
                }
                case FAILED -> io.print("No es ese... Te quedan " + (--vidas) + " vidas.");
                case INVALID -> io.print("Entrada inválida. Usa números del 1 al 10.");
                case OUTOFRANGE -> io.print("Número fuera de rango");
            }
        }

        // Registrar la partida solo al final
        jugador.registrarPartida(acierto);

        // Mostrar mensaje de fin de juego y estadísticas
        if (!acierto) {
            io.print("Game Over. El número era " + game.getNumeroSecreto());
        }
        jugador.mostrarEstadisticas(io);

        // Preguntar si quiere volver a jugar siempre
        io.print("¿Quieres volver a jugar? Dale 1 si quieres seguir");
        Scanner scanner = new Scanner(System.in);
        if (Integer.parseInt(scanner.nextLine()) == 1) {
            GuessGame juego = new GuessGame(3);
            GameIO consola = new Consola();
            new AppGame(juego, consola, jugadores).start();
        } else {
            io.print("Gracias por jugar. ¡Hasta luego!");
        }
    }

    public static void main(String[] args) {
        GameIO consola = new Consola();
        consola.print("Introduce tu nombre:");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador(nombre));

        GuessGame juego = new GuessGame(3);
        new AppGame(juego, consola, jugadores).start();
    }
}

