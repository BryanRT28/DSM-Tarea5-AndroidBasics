# DSM - Tarea 5: Android Basics with Compose (Unidad 4)

Repositorio correspondiente al desarrollo de las actividades, proyectos prácticos y sustentaciones de la **Unidad 4: Arquitectura, Navegación y Diseños Adaptables en Android**, del curso de **Desarrollo de Sistemas Móviles** en la Universidad Nacional Mayor de San Marcos (UNMSM).

---

##  Estructura del Repositorio

- `ruta1-kotlin/`: Ruta 1 - Componentes de la Arquitectura de Android (`Unscramble`).
- `ruta2-kotlin/`: Ruta 2 - Navegación en Jetpack Compose (`Cupcake`).
- `ruta3-kotlin/`: Ruta 3 - Diseños adaptables y responsivos (`Reply`).
- `README.md`: Documentación general de la entrega.

---

## 🚀 Contenido de las Rutas

###  Ruta 1: Componentes de la Arquitectura de Android (`Unscramble`)
- **Descripción:** Implementación de arquitectura moderna basada en el flujo unidireccional de datos (UDF), separación de capas e inmutabilidad del estado.
- **Conceptos clave aplicados:**
  - `ViewModel`: Retención de lógica y supervivencia a cambios de configuración (rotación de pantalla).
  - `StateFlow` y `asStateFlow()`: Manejo reactivo y encapsulamiento del estado (`GameUiState`).
  - `collectAsState()`: Suscripción reactiva en componentes `@Composable`.

###  Ruta 2: Navegación en Jetpack Compose (`Cupcake`)
- **Descripción:** Gestión de flujos multipantalla para un proceso de orden y compra de cupcakes.
- **Conceptos clave aplicados:**
  - `NavHost` y `rememberNavController()`: Orquestación del grafo de navegación y back stack.
  - Rutas tipadas con `enum CupcakeScreen`.
  - Barra superior reactiva (`CupcakeAppBar`) con botón dinámico de retroceso (`navigateUp()`).
  - Estado compartido con `OrderViewModel` a través de múltiples destinos sin pérdida de contexto.
  - `Intent` implícito (`ACTION_SEND`) para compartir el resumen del pedido en aplicaciones externas.

###  Ruta 3: Adáptate a diferentes tamaños de pantalla (`Reply`)
- **Descripción:** Diseño de interfaces adaptables y navegación dinámica para distintos factores de forma (smartphones, pantallas plegables y tablets).
- **Conceptos clave aplicados:**
  - `WindowWidthSizeClass`: Clasificación de pantallas en `Compact`, `Medium` y `Expanded`.
  - Navegación adaptativa: Transición entre `NavigationBar` (barra inferior) y `NavigationRail` (riel lateral).
  - Patrón Lista-Detalle (List-Detail) con visualización simultánea de doble panel en pantallas anchas.

---

##  Tecnologías y Entorno

- **Lenguaje:** Kotlin
- **Framework UI:** Jetpack Compose (Material 3)
- **IDE:** Android Studio
- **Target SDK:** Android 14+ (API 34 / 35)
