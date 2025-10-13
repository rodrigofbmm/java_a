package ejemplos_sencillos.Logger;

public class ModuloAutenticacion {

    private final AppConfig config = AppConfig.obtenerInstancia();

    public void inicializar() {
        config.setNivelLog(3); // Cambia configuración global.
        System.out.println("[Auth] Config usada: " + config);
    }

    public String leerModo() {
        return config.getModoEjecucion();
    }
}