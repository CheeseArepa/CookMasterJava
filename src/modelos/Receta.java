package modelos;

import java.util.ArrayList;
import java.util.List;

public abstract class Receta {
    protected String nombre;
    protected int tiempoPreparacion;
    protected List<Ingrediente> ingredientes;
    protected List<Paso> pasos;

    public Receta(String nombre, int tiempoPreparacion) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
        this.ingredientes = new ArrayList<>();
        this.pasos = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void agregarPaso(Paso paso) {
        pasos.add(paso);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerCantidadIngredientes() {
        return ingredientes.size();
    }

    public int obtenerCantidadPasos() {
        return pasos.size();
    }

    public abstract String obtenerTipo();
    
    public abstract String obtenerDetallesEspecificos();

    public void mostrarResumen() {
        System.out.println(nombre + " (" + obtenerTipo() + 
                           ") - Tiempo: " + tiempoPreparacion + " min");
    }

    public void mostrarReceta() {
        System.out.println("\n=== Detalle de Receta ===");
        System.out.println("\nNombre: " + nombre);
        System.out.println("Tipo: " + obtenerTipo());
        System.out.println("Tiempo de preparación: " + tiempoPreparacion + " min");
        
        System.out.println("\nIngredientes (" + ingredientes.size() + "):");
        int i = 1;
        for (Ingrediente ing : ingredientes) {
            System.out.println("  " + i++ + ") "+ ing);
        }

        System.out.println("\nPasos (" + pasos.size() + "):");
        for (Paso paso : pasos) {
            System.out.println("  " + paso.getNumero() + ". "+ paso.getDescripcion());
        }


        System.out.println("\nEstiquetas / Atributos adicionales:");

        System.out.println(obtenerDetallesEspecificos());

        System.out.println("\n-------------------------------------\n");
    }
}
