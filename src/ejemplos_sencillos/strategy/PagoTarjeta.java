package ejemplos_sencillos.strategy;

public class PagoTarjeta implements EstrategiaPago{

    public void pagar(double cantidad) {
        System.out.println("Procesando pago con tarjeta: " + cantidad + " euros");
        System.out.println("Verificando número y saldo de la tarjeta...");
    }

}
