package ejemplos_sencillos.Logger;

public class ModuloLogs {

    private final AppConfig config = AppConfig.obtenerInstancia();

    public void inicializar() {
        System.out.println("[Logs] Nivel de log actual: " + config.getNivelLog());
    }

    public void cambiarNivelLog(int nuevoNivel) {
        config.setNivelLog(nuevoNivel);
        System.out.println("[Logs] Nivel de log cambiado a: " + nuevoNivel);
    }

    public int obtenerNivelLog() {
        return config.getNivelLog();
    }

    public void mostrarConfiguracion() {
        System.out.println("[Logs] Config completa: " + config);
    }
}