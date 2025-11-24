package singleton;

import java.util.List;
import java.util.ArrayList;
import modelos.Receta;

public class LibroRecetas {
    private static LibroRecetas instancia;
    
    private List<Receta> recetas;

    private LibroRecetas() {
        this.recetas = new ArrayList<>();
    }

    public static LibroRecetas obtenerInstancia() {
        if (instancia == null) {
            instancia = new LibroRecetas();
        }
        return instancia;
    }

    public void agregarReceta(Receta receta) {
        recetas.add(receta);
        System.out.println("- Receta creada: " + receta.obtenerNombre());
        System.out.println("- Ingredientes añadidos: " + receta.obtenerCantidadIngredientes());
        System.out.println("- Pasos añadidos: " + receta.obtenerCantidadPasos());
        System.out.println("Receta guarda en el Libro de Recetas");
    }

    public List<Receta> obtenerTodasRecetas() {
        return new ArrayList<>(recetas);
    }

    public Receta buscarPorNombre(String nombre) {
        for (Receta receta : recetas) {
            if (receta.obtenerNombre().equalsIgnoreCase(nombre)) {
                return receta;
            }
        }
        return null;
    }

    public void mostrarTodasRecetas() {
        if (recetas.isEmpty()) {
            System.out.println("\nNo hay recetas en el libro.");
            return;
        }
        
        for (Receta receta : recetas) {
            receta.mostrarReceta();
        }
    }
}
