package factory;

import modelos.Receta;
import modelos.Ingrediente;
import modelos.Paso;

public abstract class RecetaFactory {
    
    public abstract Receta crearReceta(String nombre, int tiempoPreparacion);
    
    public void agregarIngrediente(Receta receta, String nombre, double cantidad, String unidad) {
        Ingrediente ingrediente = new Ingrediente(nombre, cantidad, unidad);
        receta.agregarIngrediente(ingrediente);
    }
    
    public void agregarPaso(Receta receta, int numero, String descripcion) {
        Paso paso = new Paso(numero, descripcion);
        receta.agregarPaso(paso);
    }
}
