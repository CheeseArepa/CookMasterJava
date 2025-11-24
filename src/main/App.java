package main;

import java.util.List;
import singleton.LibroRecetas;
import factory.*;
import modelos.*;

public class App {
    private static final String TITULO = "== CookMaster - Sistema de Recetas ==\n";
    private static final String SEPARADOR = "\n-------------------------------------\n";
    private static final String CREANDO_RECETA = "\n--- Creando receta de tipo: %s ---\n";
    private static final LibroRecetas libro = LibroRecetas.obtenerInstancia();
    public static void main(String[] args) {
        System.out.print(TITULO);
        crearYAgregarPostre();
        crearYAgregarPlatoFuerte();
        crearYAgregarBebida();
        mostrarResumenRecetas();
        libro.mostrarTodasRecetas();
    }
    
    private static void crearYAgregarPostre() {
        RecetaFactory factory = new PostreFactory();
        Receta tiramisu = factory.crearReceta("Tiramisú", 30);
        System.out.printf(CREANDO_RECETA, tiramisu.obtenerTipo().toUpperCase());
        
        ((Postre) tiramisu).setNivelDulce(8);
        
        String[][] ingredientesTiramisu = {
            {"Queso Mascarpone", "500", "g"},
            {"Café expreso", "200", "ml"},
            {"Bizcochos de soletilla", "300", "g"},
            {"Cacao en polvo", "50", "g"},
            {"Azúcar", "100", "g"}
        };
        
        String[] pasosTiramisu = {
            "Preparar café expreso y dejar enfriar",
            "Batir el queso mascarpone con azúcar hasta obtener una crema suave",
            "Mojar rápidamente los bizcochos en el café",
            "Alternar capas de bizcocho y crema en un molde",
            "Espolvorear cacao en polvo y refrigerar 4 horas"
        };
        
        agregarIngredientesYProcedimiento(factory, tiramisu, ingredientesTiramisu, pasosTiramisu);
        libro.agregarReceta(tiramisu);
    }
    
    private static void crearYAgregarPlatoFuerte() {
        RecetaFactory factory = new PlatoFuerteFactory();
        Receta lasagna = factory.crearReceta("Lasagna Boloñesa", 90);
        System.out.printf(CREANDO_RECETA, lasagna.obtenerTipo().toUpperCase());
        
        ((PlatoFuerte) lasagna).setTipoCoccion("Horno a 180°C");
        
        String[][] ingredientesLasagna = {
            {"Láminas de pasta", "400", "g"},
            {"Carne molida", "500", "g"},
            {"Salsa bechamel", "500", "ml"},
            {"Queso mozzarella", "300", "g"},
            {"Tomate triturado", "400", "g"}
        };
        
        String[] pasosLasagna = {
            "Preparar la salsa boloñesa con la carne molida y tomate",
            "Cocinar las láminas de pasta según indicaciones",
            "En un molde engrasado, alternar capas de pasta, boloñesa y bechamel",
            "Cubrir la última capa con queso mozzarella rallado",
            "Hornear durante 40 minutos hasta que esté dorado"
        };
        
        agregarIngredientesYProcedimiento(factory, lasagna, ingredientesLasagna, pasosLasagna);
        libro.agregarReceta(lasagna);
    }
    
    private static void crearYAgregarBebida() {
        RecetaFactory factory = new BebidaFactory();
        Receta mojito = factory.crearReceta("Mojito Cubano", 5);
        System.out.printf(CREANDO_RECETA, mojito.obtenerTipo().toUpperCase());
        
        ((Bebida) mojito).setTemperatura("Muy fría");
        
        String[][] ingredientesMojito = {
            {"Ron blanco", "60", "ml"},
            {"Hojas de menta fresca", "10", "unidades"},
            {"Azúcar blanca", "2", "cucharadas"},
            {"Limón", "1", "unidad"},
            {"Agua con gas", "100", "ml"},
            {"Hielo", "200", "g"}
        };
        
        String[] pasosMojito = {
            "Machacar las hojas de menta con azúcar en el fondo del vaso",
            "Agregar el jugo de limón recién exprimido",
            "Añadir hielo hasta llenar 3/4 del vaso",
            "Verter el ron blanco",
            "Completar con agua con gas y mezclar suavemente"
        };
        
        agregarIngredientesYProcedimiento(factory, mojito, ingredientesMojito, pasosMojito);
        libro.agregarReceta(mojito);
    }
    
    private static void agregarIngredientesYProcedimiento(RecetaFactory factory, Receta receta, 
                                                         String[][] ingredientes, String[] pasos) {
        for (String[] ingrediente : ingredientes) {
            factory.agregarIngrediente(
                receta, 
                ingrediente[0], 
                Double.parseDouble(ingrediente[1]), 
                ingrediente[2]
            );
        }
        
        for (int i = 0; i < pasos.length; i++) {
            factory.agregarPaso(receta, i + 1, pasos[i]);
        }
    }
    
    private static void mostrarResumenRecetas() {
        List<Receta> todasRecetas = libro.obtenerTodasRecetas();
        
        System.out.print("\n-------------------------------------\n");
        System.out.println("Listado de recetas registradas: ");
        
        int i = 1;
        for (Receta r : todasRecetas) {
            System.out.print(i++ + ". ");
            r.mostrarResumen();
        }
        
        System.out.print("-------------------------------------\n");
        System.out.println("\nDetalles del Libro de Recetas:");
        System.out.println("Total recetas almacenadas: " + todasRecetas.size());
        System.out.println("Instancia del libro: " + comprobarSingletonLibro() + "\n");
    }

    public static String comprobarSingletonLibro() {
        LibroRecetas a = LibroRecetas.obtenerInstancia();
        LibroRecetas b = LibroRecetas.obtenerInstancia();
        return (a == b) ? "OK (Singleton activo)" : "Not OK (Múltiples instancias)";
    }

}
