package factory;

import modelos.Postre;
import modelos.Receta;

public class PostreFactory extends RecetaFactory {
    
    @Override
    public Receta crearReceta(String nombre, int tiempoPreparacion) {
        return new Postre(nombre, tiempoPreparacion);
    }
}
