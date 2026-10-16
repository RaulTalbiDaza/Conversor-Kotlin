# Conversor de divisas, distancias y temperaturas

Actividad **UD01_Act04** del módulo **PMDM** (UD01. Introducción).

Aplicación de consola hecha en Kotlin con un menú principal que permite convertir divisas (desde euros), distancias y temperaturas.

## Estructura del proyecto

El desarrollo está separado en dos clases:

| Archivo   | Contenido |
|-----------|-----------|
| `Main.kt` | Función `main()`: crea un objeto `Menu` y llama a `iniciar()`. |
| `Menu.kt` | Clase `Menu`: menú principal, los tres conversores, los factores de conversión y la lectura segura de números. |

## Funcionalidades

### Divisas (desde euros)
- Euros a dólares
- Euros a libras esterlinas
- Euros a yenes
- Euros a francos suizos

Factores fijos usados: dólar `1.08`, libra `0.86`, yen `163.0`, franco suizo `0.95`.

### Distancias
- Kilómetros a metros
- Metros a kilómetros
- Kilómetros a millas
- Millas a kilómetros
- Centímetros a metros

### Temperaturas
- Celsius a Fahrenheit
- Fahrenheit a Celsius
- Celsius a Kelvin
- Kelvin a Celsius

Fórmulas: `F = C × 9 / 5 + 32`, `C = (F - 32) × 5 / 9`, `K = C + 273.15`, `C = K - 273.15`.

## Estructuras de control

- `when` para gestionar las opciones del menú.
- `if` para las validaciones.
- `do-while` para repetir el menú hasta que el usuario sale.
- `val` para los factores de conversión fijos.
- `var` para valores que cambian durante la ejecución (`salir`).

## Validaciones

| Caso | Mensaje |
|------|---------|
| Opción de menú no válida | `Error: opción no válida.` |
| Cantidad negativa (divisas y distancias) | `Error: la cantidad no puede ser negativa.` |
| Kelvin inferior a 0 | `Error: la temperatura en Kelvin no puede ser inferior a 0.` |
| Entrada que no es un número | `Error: entrada de datos incorrecta, introduce un número válido.` |

Se admite tanto coma como punto como separador decimal.

## Cómo ejecutarlo

### Desde IntelliJ IDEA
1. Abre el proyecto.
2. Ejecuta la función `main()` de `Main.kt` con el botón verde de ejecutar.

### Desde la terminal
Necesitas tener instalado el compilador de Kotlin (`kotlinc`) y Java.

```bash
kotlinc Main.kt Menu.kt -include-runtime -d conversor.jar
java -jar conversor.jar
```

## Ejemplo de uso

```
===== MENÚ PRINCIPAL =====
1. Conversor de divisas
2. Conversor de distancias
3. Conversor de temperaturas
0. Salir
Elige una opción: 2

--- Conversor de distancias ---
1. Kilómetros a metros
2. Metros a kilómetros
3. Kilómetros a millas
4. Millas a kilómetros
5. Centímetros a metros
Elige una opción: 1
Introduce la distancia: 10
10.0 kilómetros equivalen a 10000.0 metros.
```

## Autor

Raul Talbi Daza
