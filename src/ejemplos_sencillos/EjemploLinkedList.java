package ejemplos_sencillos;

import java.util.LinkedList;

public class EjemploLinkedList {

    public static void main(String[] args) {

        LinkedList<String> colaImpresion = new LinkedList<>();


        colaImpresion.add("DocA");
        System.out.println("Cola : " + colaImpresion);
        colaImpresion.add("DocB");
        System.out.println("Cola : " + colaImpresion);
        colaImpresion.add("DocC");
        System.out.println("Cola : " + colaImpresion);

        System.out.println("Cola : " + colaImpresion);

        //urgencia lo metemos primero
        System.out.println("Nueva urgencia");
        colaImpresion.addFirst("UrgenteX");
        System.out.println("Cola: " + colaImpresion);

        // Atender trabajos
        atenderSiguiente(colaImpresion);
        atenderSiguiente(colaImpresion);
        atenderSiguiente(colaImpresion);
        atenderSiguiente(colaImpresion);

        System.out.println("Cola: " + colaImpresion);
    }

    // Método para atender un trabajo
    private static void atenderSiguiente(LinkedList<String> cola) {
        String siguiente = cola.peekFirst();
        if (siguiente == null) {
            System.out.println("No hay trabajos en la cola.");
            return;
        }
        System.out.println("Atendiendo: " + siguiente);
        cola.pollFirst();
        System.out.println("Estado tras atender: " + cola);
    }
}

