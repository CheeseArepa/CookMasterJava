package factory;

import modelos.Bebida;
import modelos.Receta;

public class BebidaFactory extends RecetaFactory {

    @Override
    public Receta crearReceta(String nombre, int tiempoPreparacion) {
        return new Bebida(nombre, tiempoPreparacion);
    }
}
