package ejemplos_sencillos.strategy;

public class PagoPayPal implements EstrategiaPago {

    public void pagar(double cantidad) {
        System.out.println("Procesando pago con tarjeta: " + cantidad + " euros");
        System.out.println("Conectando a cuenta PayPal del usuario...");
    }
}
