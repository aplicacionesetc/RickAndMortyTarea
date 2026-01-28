**Rick and Morty Buscador de Episodios**

Aplicación android desarrollada como proyecto del módulo PMDM de DAM.
el objetivo principal es permitir al usuario consultar los episodios de *Rick and Morty* desde la API oficial, 
marcar los episodios como **vistos** y consultar estadísticas de progreso. La app incluye autenticación con Firebase 
para que llevar el registro y control de los usuarios. 

Características de la App
**Autenticación** con Firebase Auth UI (login/registro)
**listado de episodios** consumidos desde la API oficial de Rick and Morty
**Detalle de los episodios** que contienen:
- Nombre
- Imagen de los personajes (Grid)
- Código
- Fecha emisión
**Filtro** de los episodios:
- Todos
- Vistos
**Estadísticas** con:
- Total episodios
- Vistos
- Porcentaje (total-vistos) en barra de progreso
**Ajustes**:
- Cambiar idioma (No funcional)
- Modo Noche (No funcional)
- Cerrar Sesión
**Acerca de**
- Dialogo con información del desarrollador y de la versión

Tecnologías utilizadas
- **Kotlin**
- **Android Studio**
- **Material Components**
- **Navigation Component + DrawerLayout**
- **Retrofit + Gson** (consumo de API)
- **RecyclerView**
- **Coil**
- **Firebase** Firebase Auth + Firebase UI
- **SharedPreferences** (persistencia de datos a nivel del usuario actual)
- **ViewBinding**
  

