package ejemplos_sencillos.Logger;



public class AppConfig {

    private static AppConfig instanciaUnica;

    private String modoEjecucion;
    private int nivelLog;

    private AppConfig() {
        this.modoEjecucion = "DEV";
        this.nivelLog = 2;
    }

    public static AppConfig obtenerInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new AppConfig();
        }
        return instanciaUnica;
    }

    public void reiniciar() {
        this.modoEjecucion = "DEV";
        this.nivelLog = 2;
    }

    public String getModoEjecucion() {
        return modoEjecucion;
    }

    public void setModoEjecucion(String modoEjecucion) {
        this.modoEjecucion = modoEjecucion;
    }

    public int getNivelLog() {
        return nivelLog;
    }

    public void setNivelLog(int nivelLog) {
        this.nivelLog = nivelLog;
    }

    @Override
    public String toString() {
        return "AppConfig{modoEjecucion='" + modoEjecucion + "', nivelLog=" + nivelLog + "}";
    }
}