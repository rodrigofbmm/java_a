package Juego.Juego;

import java.util.Random;

public class GuessGame {
    private int numeroSecreto;
    private final int vidas;

    public GuessGame(int vidas) {
        this.vidas = vidas;
        generarNumeroSecreto();
    }

    private void generarNumeroSecreto() {
        Random random = new Random();
        this.numeroSecreto = random.nextInt(10) + 1; // número entre 1 y 10
    }

    public int getMaxVidas() {
        return vidas;
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }

    public Estado verificarInput(String input) {
        try {
            int numero = Integer.parseInt(input);

            if (numero < 1 || numero > 10) {
                return Estado.OUTOFRANGE;
            }

            return (numero == numeroSecreto) ? Estado.SUCCESS : Estado.FAILED;

        } catch (NumberFormatException e) {
            return Estado.INVALID;
        }
    }
}
