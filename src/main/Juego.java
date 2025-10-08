package main;

import java.util.Random;
import java.util.Scanner;

public class Juego{
    Random random = new Random();
    private int numeroGanador;
    private int dinero;

    public void dinero(){
        System.out.println("tienes: " + dinero + " cuanto dinero quieres meter:");
        Scanner scanner = new Scanner(System.in);
        int suma = scanner.nextInt();
        dinero = dinero + suma;
        System.out.println("ahora tienes:" + dinero);
    }
    public void Juego(){
        if(dinero <= 0){
            System.out.println("no hay dinero suficiente");
        }else{

            numeroGanador = random.nextInt(10) + 1;

            System.out.println("cuanto quieres apostar: ");
            Scanner scanner = new Scanner(System.in);
            int apostar = scanner.nextInt();

            System.out.println("Elige numero de 1 al 10: ");
            int NumeroSeleccionado = scanner.nextInt();


            if(NumeroSeleccionado == numeroGanador){
                System.out.println("el numero es: " + numeroGanador);
                System.out.println("Enorabuena has ganado ");
                dinero =  dinero + (apostar * 2);
                System.out.println("Ahora tienes: " + dinero + "\n");
            }else {
                System.out.println("el numero es: " + numeroGanador);
                System.out.println("has perdido ");
                dinero =  dinero - apostar;
                System.out.println("Ahora tienes: " + dinero + "\n");
            }

        }
    }

}
