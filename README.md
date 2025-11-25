# CookMaster – Sistema de Gestión de Recetas

Proyecto para el curso **Paradigma Orientado a Objetos – Ingeniería de Software**

Este proyecto implementa un sistema básico para la creación, organización y visualización de recetas culinarias, aplicando los patrones de diseño **Singleton** y **Factory Method**, según los requisitos del taller asignado.

---
## 📌 Características principales

- Gestión de recetas
- Diferentes categorías: **Postre**, **Plato Fuerte**, **Bebida**
- Cada categoría incluye un atributo extra (nivel de dulce, tipo de cocción, temperatura)
- Manejo de ingredientes y pasos
- Registro global de recetas mediante un **Singleton**
- Creación de recetas mediante el patrón **Factory Method**

---

## 🧱 Arquitectura y Patrones de Diseño

### 🟦 1. Singleton – `LibroRecetas`

El sistema requiere que exista **solo un libro de recetas** en toda la aplicación.
Esto se implementa con el patrón Singleton:

* Solo una instancia accesible mediante `obtenerInstancia()`
* Centraliza almacenamiento, búsqueda y visualización de recetas
* Facilita el control global sobre la información registrada

```java
LibroRecetas libro = LibroRecetas.obtenerInstancia();
```

---

### 🟧 2. Factory Method – `RecetaFactory` + subclases

Para crear recetas de distintos tipos sin acoplar el código cliente a clases concretas, se implementa una **clase abstracta `RecetaFactory`**, extendida por:

* `PostreFactory`
* `PlatoFuerteFactory`
* `BebidaFactory`

Cada fábrica sabe **qué tipo de receta crear**, ocultando la lógica al usuario:

```java
RecetaFactory factory = new PostreFactory();
Receta tiramisu = factory.crearReceta("Tiramisú", 30);
```

La fábrica también encapsula la creación de ingredientes y pasos.

---

## 🗂️ Estructura del Proyecto

```
src/
 ├── main/App.java
 ├── factory/
 │     ├── RecetaFactory.java
 │     ├── PostreFactory.java
 │     ├── PlatoFuerteFactory.java
 │     └── BebidaFactory.java
 ├── modelos/
 │     ├── Receta.java
 │     ├── Postre.java
 │     ├── PlatoFuerte.java
 │     ├── Bebida.java
 │     ├── Ingrediente.java
 │     └── Paso.java
 └── singleton/
       └── LibroRecetas.java
```

---

## 🥘 Funcionamiento del Sistema

El archivo `App.java` realiza:

1. Creación de tres recetas (tiramisu, lasagna y mojito)
2. Configuración de atributos específicos
3. Agregado de ingredientes y pasos
4. Registro en el **Libro de Recetas (Singleton)**
5. Impresión de un resumen y posteriormente del detalle completo

---

## 🎯 Justificación del diseño

**Patrón Singleton**:
Se aplica correctamente en `LibroRecetas`, asegurando una única instancia global para administrar todas las recetas. Esto evita duplicación de datos y permite una gestión centralizada.

**Patrón Factory Method**:
Se utiliza para desacoplar la creación de objetos `Receta`. Cada tipo de receta tiene su propia fábrica, simplificando la extensión del sistema (por ejemplo, agregar RecetaVegana o Aperitivo).

Esto permite:

* Reducir el acoplamiento en el código cliente
* Centralizar la lógica de creación y configuración
* Hacer más fácil agregar nuevos tipos sin modificar código existente

---

## ▶️ Cómo ejecutar

1. Clonar el repositorio
2. Compilar el proyecto:

```bash
javac src/**/*.java
```

3. Ejecutar:

```bash
java main.App
```

## Trabajo final
[Taller Cookmaster.pdf](https://github.com/user-attachments/files/23734480/Taller.Cookmaster.pdf)

