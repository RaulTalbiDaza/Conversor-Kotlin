class Menu {
    // Factores de conversión fijos (val)
    private val dolar = 1.08
    private val libra = 0.86
    private val yen = 163.0
    private val francoSuizo = 0.95

    private val metrosPorKm = 1000.0
    private val kmPorMilla = 1.609344
    private val cmPorMetro = 100.0

    // Punto de entrada del menú: se repite hasta que el usuario sale
    fun iniciar() {
        var salir = false

        do {
            println()
            println("===== MENÚ PRINCIPAL =====")
            println("1. Conversor de divisas")
            println("2. Conversor de distancias")
            println("3. Conversor de temperaturas")
            println("0. Salir")
            print("Elige una opción: ")

            when (readLine()?.trim()) {
                "1" -> menuDivisas()
                "2" -> menuDistancias()
                "3" -> menuTemperaturas()
                "0" -> {
                    println("¡Hasta pronto!")
                    salir = true
                }
                else -> println("Error: opción no válida.")
            }
        } while (!salir)
    }

    // ---------- FASE 3: DIVISAS ----------
    private fun menuDivisas() {
        println()
        println("--- Conversor de divisas (desde euros) ---")
        println("1. Euros a dólares")
        println("2. Euros a libras esterlinas")
        println("3. Euros a yenes")
        println("4. Euros a francos suizos")
        print("Elige una opción: ")

        val opcion = readLine()?.trim()
        if (opcion !in listOf("1", "2", "3", "4")) {
            println("Error: opción no válida.")
            return
        }

        val euros = leerCantidad("Introduce la cantidad en euros: ") ?: return
        if (euros < 0) {
            println("Error: la cantidad no puede ser negativa.")
            return
        }

        when (opcion) {
            "1" -> println("$euros euros equivalen a ${euros * dolar} dólares.")
            "2" -> println("$euros euros equivalen a ${euros * libra} libras esterlinas.")
            "3" -> println("$euros euros equivalen a ${euros * yen} yenes.")
            "4" -> println("$euros euros equivalen a ${euros * francoSuizo} francos suizos.")
        }
    }

    // ---------- FASE 4: DISTANCIAS ----------
    private fun menuDistancias() {
        println()
        println("--- Conversor de distancias ---")
        println("1. Kilómetros a metros")
        println("2. Metros a kilómetros")
        println("3. Kilómetros a millas")
        println("4. Millas a kilómetros")
        println("5. Centímetros a metros")
        print("Elige una opción: ")

        val opcion = readLine()?.trim()
        if (opcion !in listOf("1", "2", "3", "4", "5")) {
            println("Error: opción no válida.")
            return
        }

        val cantidad = leerCantidad("Introduce la distancia: ") ?: return
        if (cantidad < 0) {
            println("Error: la cantidad no puede ser negativa.")
            return
        }

        when (opcion) {
            "1" -> println("$cantidad kilómetros equivalen a ${cantidad * metrosPorKm} metros.")
            "2" -> println("$cantidad metros equivalen a ${cantidad / metrosPorKm} kilómetros.")
            "3" -> println("$cantidad kilómetros equivalen a ${cantidad / kmPorMilla} millas.")
            "4" -> println("$cantidad millas equivalen a ${cantidad * kmPorMilla} kilómetros.")
            "5" -> println("$cantidad centímetros equivalen a ${cantidad / cmPorMetro} metros.")
        }
    }

    // ---------- FASE 5: TEMPERATURAS ----------
    private fun menuTemperaturas() {
        println()
        println("--- Conversor de temperaturas ---")
        println("1. Celsius a Fahrenheit")
        println("2. Fahrenheit a Celsius")
        println("3. Celsius a Kelvin")
        println("4. Kelvin a Celsius")
        print("Elige una opción: ")

        val opcion = readLine()?.trim()
        if (opcion !in listOf("1", "2", "3", "4")) {
            println("Error: opción no válida.")
            return
        }

        val temperatura = leerCantidad("Introduce la temperatura: ") ?: return

        // Validación: Kelvin no puede ser inferior a 0
        if (opcion == "4" && temperatura < 0) {
            println("Error: la temperatura en Kelvin no puede ser inferior a 0.")
            return
        }

        when (opcion) {
            "1" -> println("$temperatura °C equivalen a ${temperatura * 9 / 5 + 32} °F.")
            "2" -> println("$temperatura °F equivalen a ${(temperatura - 32) * 5 / 9} °C.")
            "3" -> println("$temperatura °C equivalen a ${temperatura + 273.15} K.")
            "4" -> println("$temperatura K equivalen a ${temperatura - 273.15} °C.")
        }
    }

    // ---------- UTILIDAD: lectura segura de números ----------
    // Devuelve null si la entrada no es un número válido (y muestra el error)
    private fun leerCantidad(mensaje: String): Double? {
        print(mensaje)
        val entrada = readLine()?.trim()?.replace(',', '.')
        val numero = entrada?.toDoubleOrNull()
        if (numero == null) {
            println("Error: entrada de datos incorrecta, introduce un número válido.")
        }
        return numero
    }
}