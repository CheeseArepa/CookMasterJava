package factory;

import modelos.PlatoFuerte;
import modelos.Receta;

public class PlatoFuerteFactory extends RecetaFactory {

    @Override
    public Receta crearReceta(String nombre, int tiempoPreparacion) {
        return new PlatoFuerte(nombre, tiempoPreparacion);
    }
}
