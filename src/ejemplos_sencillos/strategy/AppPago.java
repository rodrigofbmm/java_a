package ejemplos_sencillos.strategy;

public class AppPago {
    public static void main(String[] args) {
        ProcesadorPago procesador = new ProcesadorPago();

        procesador.getPago(new PagoTarjeta());
        procesador.procesar(100.50);

        procesador.getPago(new PagoPayPal());
        procesador.procesar(120.50);
    }
}