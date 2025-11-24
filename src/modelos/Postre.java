package modelos;

public class Postre extends Receta {
    private int nivelDulce;

    public Postre(String nombre, int tiempoPreparacion) {
        super(nombre, tiempoPreparacion);
        this.nivelDulce = 5; // Valor por defecto
    }

    public void setNivelDulce(int nivel) {
        this.nivelDulce = nivel;
    }

    public int getNivelDulce() {
        return nivelDulce;
    }

    @Override
    public String obtenerTipo() {
        return "Postre";
    }

    @Override
    public String obtenerDetallesEspecificos() {
        return "  - Nivel de dulce: " + nivelDulce + "/10";
    }
}
