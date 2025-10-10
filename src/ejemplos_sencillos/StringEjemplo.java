package ejemplos_sencillos;

import java.util.Scanner;

public class StringEjemplo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce una frase: ");
        String texto = scanner.nextLine();

        int longitud = texto.length();
        String mayus = texto.toUpperCase();
        String minus = texto.toLowerCase();


        long numVocales = texto.toLowerCase().chars().mapToObj(c -> (char) c).filter(c -> "aeiou".indexOf(c) != -1).count();
        boolean empiezaConHola = texto.startsWith("Hola");
        String invertida = new StringBuilder(texto).reverse().toString();
        StringBuilder contructor = new StringBuilder(texto);
        contructor.append("JAVA");

        System.out.println("Longitud: " + longitud);
        System.out.println("Mayúsculas: " + mayus);
        System.out.println("Minúsculas: " + minus);
        System.out.println("Número de vocales: " + numVocales);
        System.out.println("¿Empieza con \"Hola\"?: " + empiezaConHola);
        System.out.println("Frase invertida: " + invertida);
        System.out.println("Concatenada con StringBuilder: " + contructor);

    }
}
