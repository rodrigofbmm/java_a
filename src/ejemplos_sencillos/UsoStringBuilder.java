package ejemplos_sencillos;

import java.util.Scanner;

public class UsoStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder constructor = new StringBuilder();

        System.out.println("Introduce líneas de texto (escribe FIN para terminar):");
        while (true) {

            String lineaActual = scanner.nextLine();

            if (lineaActual.equalsIgnoreCase("FIN")) break;

            if (constructor.length() > 0) constructor.append(" ");

            constructor.append(lineaActual);
        }


        System.out.println("Texto acumulado con StringBuilder:");
        System.out.println(constructor.toString());

        int posicionInsercion = 10;
        constructor.insert(posicionInsercion, " (INSERTADO)");
        System.out.println("Texto tras inserción en posición 10:");
        System.out.println(constructor.toString());

        constructor.delete(10, 22);
        System.out.println("Texto tras eliminación (caracteres 10 a 22):");
        System.out.println(constructor.toString());


        int inicio = constructor.indexOf("escribir");
        if (inicio != -1) constructor.replace(inicio, inicio + "escribir".length(), "crear");

        System.out.println("\nTexto tras reemplazo de 'escribir' por 'crear':");
        System.out.println(constructor.toString());

        StringBuilder invertido = new StringBuilder(constructor).reverse();
        System.out.println("\nTexto invertido:");
        System.out.println(invertido.toString());

        scanner.close();
    }
}
