package Juego;

import java.util.Random;

public class GuessGame {
    private  int numeroSecreto;
    private final int vidas;

    public GuessGame(int vidas) {
        this.vidas = vidas;
    }

    public int getMaxVidas() {
        return vidas;
    }

    public int getNumeroSecreto() {
        Random random = new Random();
        this.numeroSecreto = random.nextInt(10) + 1; // número secreto entre 1 y 10
        return numeroSecreto;
    }

    public Estado verificarInput(String input) {
        try {
            int numero = Integer.parseInt(input);

            if (numero < 1 || numero > 10) {
                return Estado.OUTOFRANGE;
            }

            return (numero == numeroSecreto) ?Estado.SUCCESS : Estado.FAILED;

        } catch (NumberFormatException e) {
            return Estado.INVALID;
        }
    }
}


