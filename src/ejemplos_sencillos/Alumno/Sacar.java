package ejemplos_sencillos.Alumno;

import java.util.Scanner;

public class Sacar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Elige:");
            System.out.println("1 - Meter alumno");
            System.out.println("2 - Ver alumnos");
            System.out.println("3 - Salir");
            System.out.print("Opcion: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Alumno alumno = new Alumno();
                    break;
                case 2:
                    Alumno.VerAlumnos();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                default:
                    System.out.println("Solo del 1 al 3.");
            }
        } while (choice != 3);
        scanner.close();
    }
}
