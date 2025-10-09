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

    public  void start() {

        io.print("Bienvenido al juego de adivinar (1-10)");

        for (Jugador jugador : jugadores) {

            int vidas = game.getMaxVidas();
            boolean acierto = false;

            GuessGame partida = new GuessGame(game.getMaxVidas());

            io.print("Turno de: " + jugador.getNombre());
            io.print("Tienes " + vidas + " vidas.");

            while (vidas > 0) {
                io.print("Introduce un número:");
                String input = io.read();
                Estado resultado = partida.verificarInput(input);

                switch (resultado) {
                    case SUCCESS -> {
                        io.print("¡Correcto! El número era " + partida.getNumeroSecreto());
                        acierto = true;
                        vidas = 0;
                    }
                    case FAILED -> io.print("No es ese... Te quedan " + (--vidas) + " vidas.");
                    case INVALID -> io.print("Entrada inválida. Usa números del 1 al 10.");
                    case OUTOFRANGE -> io.print("Número fuera de rango");
                }
            }

            jugador.registrarPartida(acierto);

            if (!acierto) {
                io.print("Game Over. El número era " + partida.getNumeroSecreto());
            }

        }


        io.print("¿Quieres volver a jugar? (1 = Sí / Otro = No)");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();

        if (respuesta.equals("1")) {
            GuessGame nuevoJuego = new GuessGame(game.getMaxVidas());
            new AppGame(nuevoJuego, io, jugadores).start();
        } else {
            io.print("Gracias por jugar");
        }
    }

   /* public static void main(String[] args) {
        GameIO consola = new Consola();
        consola.print("Introduce tu nombre:");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador(nombre));

        GuessGame juego = new GuessGame(3);
        new AppGame(juego, consola, jugadores).start();
    }*/
}

