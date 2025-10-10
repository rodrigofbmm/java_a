package ejemplos_sencillos;


class Contador implements Runnable {
    private final String nombre;

    public Contador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + ": " + i);
            try {
                Thread.sleep(500); // pausa de 0.5 segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(nombre + " ha terminado.");
    }
}
public class Hilos {
    public static void main(String[] args) {

        Thread hilo1 = new Thread(new Contador("Hilo-A"));
        Thread hilo2 = new Thread(new Contador("Hilo-B"));

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Ambos hilos han finalizado su ejecución.");
    }
}

