package modelos;

public class PlatoFuerte extends Receta {
    private String tipoCoccion;

    public PlatoFuerte(String nombre, int tiempoPreparacion) {
        super(nombre, tiempoPreparacion);
        this.tipoCoccion = "Horno"; // Valor por defecto
    }

    public void setTipoCoccion(String tipo) {
        this.tipoCoccion = tipo;
    }

    public String getTipoCoccion() {
        return tipoCoccion;
    }

    @Override
    public String obtenerTipo() {
        return "Plato Fuerte";
    }

    @Override
    public String obtenerDetallesEspecificos() {
        return "  - Tipo de cocción: " + tipoCoccion;
    }
}
