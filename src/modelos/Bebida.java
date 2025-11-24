package modelos;

public class Bebida extends Receta {
    private String temperatura;

    public Bebida(String nombre, int tiempoPreparacion) {
        super(nombre, tiempoPreparacion);
        this.temperatura = "Fría"; // Valor por defecto
    }

    public void setTemperatura(String temp) {
        this.temperatura = temp;
    }

    public String getTemperatura() {
        return temperatura;
    }

    @Override
    public String obtenerTipo() {
        return "Bebida";
    }

    @Override
    public String obtenerDetallesEspecificos() {
        return "  - Temperatura: " + temperatura;
    }
}
