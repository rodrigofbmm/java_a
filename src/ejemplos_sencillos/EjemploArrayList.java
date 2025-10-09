package ejemplos_sencillos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EjemploArrayList  {

    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>(Arrays.asList(5, 7, 9, 6, 8));
        List<String> palabras = new ArrayList<>(Arrays.asList("pagar facturas", "estudiar", "comprar pan", "estudiar"));

        // Calcular media
        OptionalDouble media = numeros.stream().mapToInt(Integer::intValue).average();
        System.out.println("ArrayList media: " + media);

        // Mayores o iguales a 7
        List<Integer> mayor7 = new ArrayList<>();
        mayor7 = numeros.stream().filter(n -> n >= 7).collect(Collectors.toList());
        System.out.println("ArrayList Mayor o igual a 7: " + mayor7 + " lo superan " + mayor7.size() + " personas");

        // Ordenar la lista
        List<Integer> ordenado = new ArrayList<>(numeros);
        Collections.sort(ordenado);
        System.out.println("ArrayList ordenado: " + ordenado);

        // Invertir la lista
        List<Integer> invertido = new ArrayList<>(numeros);
        Collections.reverse(invertido);
        System.out.println("ArrayList invertido: " + invertido);

        //meter palabra
        palabras.add("hacer ejercicio");
        System.out.println("Palabra metida al final: " + palabras);

        //meter palabra al princio
        palabras.add(0,"revisar correo");
        System.out.println("Nueva palabra al principio: " + palabras);

        //quitar palabras repetidas
        palabras = palabras.stream().distinct().collect(Collectors.toList());
        System.out.println("Sin repeticiones: " + palabras);

        //modificar la rimera psoicion
        palabras.set(0, "pagar impuestos");
        System.out.println("Remplazo: " + palabras);

        //orden alfavetico
        Collections.sort(palabras);
        System.out.println("Lista ordenada alfabéticamente: " + palabras);
    }
}
