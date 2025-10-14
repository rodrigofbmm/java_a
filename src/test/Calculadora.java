package test;


public class Calculadora {

    public int sumar(int a, int b) { return a + b; }

    public int restar(int a, int b) { return a - b; }

    public boolean esPar(int numero) { return numero % 2 == 0; }

    public double dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return (double) a / b;
    }
}