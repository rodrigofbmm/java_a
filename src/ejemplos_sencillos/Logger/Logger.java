package ejemplos_sencillos.Logger;

public class Logger {

    private static Logger instancia;

    private Logger(String inicializando) {
        System.out.println("Inicializando logger: " + inicializando);
    }

    public static Logger getInstancia() {
        if (instancia == null) {
            instancia = new Logger("Creando instancia única");
        }
        return instancia;
    }

    public static void main(String[] args) {

        Logger log1 = Logger.getInstancia();
        System.out.println("primero logger " + log1);

        Logger log2 = Logger.getInstancia();
        System.out.println("Segundo logger " + log2);

        System.out.println("¿log1 y log2 son la misma instancia? " + (log1 == log2));
    }
}