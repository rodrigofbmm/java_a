package Juego;

import java.util.Scanner;

public class Consola extends GameIO {


    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
