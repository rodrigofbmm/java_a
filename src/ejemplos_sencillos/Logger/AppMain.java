package ejemplos_sencillos.Logger;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DEL PATRÓN SINGLETON ===\n");

        ModuloAutenticacion auth = new ModuloAutenticacion();
        ModuloReportes reportes = new ModuloReportes();
        ModuloLogs logs = new ModuloLogs();

        auth.inicializar();
        reportes.inicializar();
        logs.inicializar();

        System.out.println("Verificando valores compartidos");
        System.out.println("¿Auth ve modo PROD? " + auth.leerModo());
        System.out.println("¿Reportes ve nivel DEBUG(3)? " + reportes.leerNivelLog());
        System.out.println("¿Logs ve nivel DEBUG(3)? " + logs.obtenerNivelLog());

        System.out.println("Cambio desde ModuloLogs");
        logs.cambiarNivelLog(1); // ERROR
        logs.mostrarConfiguracion();

        // Reiniciar configuración
        System.out.println("Reiniciando configuración");
        AppConfig.obtenerInstancia().reiniciar();
        logs.mostrarConfiguracion();
    }
}