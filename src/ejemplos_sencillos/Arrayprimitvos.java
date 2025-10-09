package ejemplos_sencillos;

import java.util.Arrays;

public class Arrayprimitvos {

    public static void main(String[] args) {

        int[] numeros = {5, 7, 9, 6, 8};
        int[] Mayor7 = {};
        int[] Invertido= new int[numeros.length];
        int suma = 0;
        double media = 0;


        //bucle para media y sacar mayor a 7
        for(int i = 0; i < numeros.length; i++){
            suma += numeros[i];
        }

        media = (double) suma / numeros.length;
        System.out.println("Array media: " + media);

        //mayor a 7
        Mayor7 = Arrays.stream(numeros).filter(n -> n >= 7).toArray();
        System.out.println("Array Mayor a 7: " + Arrays.toString(Mayor7) + " lo superan " + Mayor7.length + " personas");

        //bucle para inverso del original
        for (int i = 0; i < numeros.length; i++) {
            Invertido[i] = numeros[numeros.length - 1 - i];
        }

        //ordenar numeros
        Arrays.sort(numeros);
        System.out.println("Array ordenado: " + Arrays.toString(numeros));


        System.out.println("Array Inversos: " + Arrays.toString(Invertido));
    }


}
