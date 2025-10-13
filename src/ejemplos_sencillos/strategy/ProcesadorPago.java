package ejemplos_sencillos.strategy;

public class ProcesadorPago {

    private EstrategiaPago pago;

    public void getPago(EstrategiaPago pago){
        this.pago = pago;
    }
    public void procesar(double cantidad) {
        if(pago == null){
            System.out.println("No se ha definido una estrategia de pago.");
        }else pago.pagar(cantidad);
    }
}