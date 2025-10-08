package main;

import java.util.Scanner;

public class Menu {
    public  void Menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        Juego juego = new Juego();

        do {
            System.out.println("Choose an option:");
            System.out.println("1 - Meter dinero");
            System.out.println("2 - Jugar");
            System.out.println("3 - Salir");
            System.out.print("Opcion: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    juego.dinero();
                    break;
                case 2:
                    juego.Juego();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Solo del 1 al 3.");
            }
        } while (choice != 3);

        scanner.close();
    }
}

