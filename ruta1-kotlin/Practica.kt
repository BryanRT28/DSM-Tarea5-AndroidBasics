// ============================================================================
// ACTIVIDAD 2: GENÉRICOS, OBJETOS Y EXTENSIONES
// ============================================================================

enum class Difficulty {
    EASY, MEDIUM, HARD
}

// Clase con parámetro genérico T
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

// Objeto Singleton y Companion Object con interfaz
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("¿Cuál es la capital de Perú?", "Lima", Difficulty.EASY)
    val question2 = Question<Boolean>("¿Kotlin fue desarrollado por Google?", false, Difficulty.MEDIUM)
    val question3 = Question<Int>("¿Cuántos lados tiene un hexágono?", 6, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "$answered de $total respondidas."

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
}

// Función de extensión
fun Quiz.StudentProgress.printQuizStatus() {
    println("Progreso actual del estudiante: $answered / $total preguntas completadas.")
}


// ============================================================================
// ACTIVIDAD 3 Y 4: COLECCIONES Y FUNCIONES DE ORDEN SUPERIOR
// ============================================================================

class Cookie(
    val name: String,
    val price: Double,
    val isSoftBaked: Boolean
)

val cookies = listOf(
    Cookie(name = "Chocolate Chip", price = 1.69, isSoftBaked = false),
    Cookie(name = "Banana Walnut", price = 1.49, isSoftBaked = true),
    Cookie(name = "Vanilla Sandwich", price = 1.59, isSoftBaked = false),
    Cookie(name = "Chocolate Peanut Butter", price = 1.79, isSoftBaked = true),
    Cookie(name = "Snickerdoodle", price = 1.39, isSoftBaked = true),
    Cookie(name = "Blueberry Tart", price = 1.79, isSoftBaked = true),
    Cookie(name = "Sugar and Sprinkles", price = 1.39, isSoftBaked = false)
)

fun runCollectionsDemo() {
    println("--- DEMOSTRACIÓN DE COLECCIONES Y LAMBDAS ---")
    
    // forEach
    println("\n1. Lista de galletas disponibles:")
    cookies.forEach { println(" - ${it.name}: $${it.price}") }

    // map
    val fullMenu = cookies.map { "${it.name} - $${it.price}" }
    println("\n2. Menú formateado (map): $fullMenu")

    // filter
    val softBakedCookies = cookies.filter { it.isSoftBaked }
    println("\n3. Galletas suaves (filter): ${softBakedCookies.size} encontradas")

    // groupBy
    val groupedMenu = cookies.groupBy { it.isSoftBaked }
    println("\n4. Agrupadas por suavidad (groupBy):")
    println(" - Horneadas suaves: ${groupedMenu[true]?.map { it.name }}")
    println(" - Crujientes: ${groupedMenu[false]?.map { it.name }}")

    // fold
    val totalPrice = cookies.fold(0.0) { total, cookie -> total + cookie.price }
    println("\n5. Precio total de la colección (fold): $${"%.2f".format(totalPrice)}")

    // sortedBy
    val alphabeticalMenu = cookies.sortedBy { it.name }
    println("\n6. Ordenadas alfabéticamente (sortedBy): ${alphabeticalMenu.map { it.name }}")
}


// ============================================================================
// ACTIVIDAD 5: PRÁCTICA OFICIAL - CLASES Y COLECCIONES (EVENTOS)
// ============================================================================

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

// Propiedad de extensión para clasificar la duración del evento
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }

fun runEventsPractice() {
    println("\n--- PRÁCTICA OFICIAL: GESTIÓN DE EVENTOS ---")

    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Jetpack Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 45),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check & complete review checklist", daypart = Daypart.EVENING, durationInMinutes = 20)
    )

    // Tarea 1: Filtrar eventos cortos (< 60 minutos)
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("Total de eventos cortos: ${shortEvents.size}")

    // Tarea 2: Agrupar eventos por momento del día
    val eventsByDaypart = events.groupBy { it.daypart }
    eventsByDaypart.forEach { (daypart, eventList) ->
        println("$daypart: ${eventList.size} eventos")
    }

    // Tarea 3: Obtener el último evento utilizando la función de extensión
    println("Último evento del día: ${events.last().title}, Duración clasificada: ${events.last().durationOfEvent}")
}


// ============================================================================
// FUNCIÓN PRINCIPAL
// ============================================================================

fun main() {
    println("=== REPASO DE CONCEPTOS BÁSICOS DE KOTLIN ===")
    
    // Actividad 2
    val quiz = Quiz()
    quiz.printProgressBar()
    Quiz.printQuizStatus()

    // Actividades 3 y 4
    runCollectionsDemo()

    // Actividad 5
    runEventsPractice()
}