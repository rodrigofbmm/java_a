package ejemplos_sencillos.Logger;

public class ModuloReportes {

    private final AppConfig config = AppConfig.obtenerInstancia();

    public void inicializar() {
        config.setModoEjecucion("PROD");
        System.out.println("[Reportes] Config usada: " + config);
    }

    public int leerNivelLog() {
        return config.getNivelLog();
    }
}