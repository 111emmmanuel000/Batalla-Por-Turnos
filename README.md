# Batalla-Por-Turnos

RPG de exploración y combate desarrollado en Java, donde el jugador recorre diferentes salas,
enfrenta enemigos, utiliza habilidades elementales, administra recursos y compra mejoras 
para fortalecer su personaje.

Descripción:

Batalla por Turnos es un videojuego de aventura desarrollado en Java que combina exploración, combates por turnos y administración de recursos.

El jugador crea un personaje, selecciona su elemento principal y se adentra en un mapa compuesto por diferentes salas. Durante su recorrido deberá enfrentarse a enemigos, utilizar habilidades que consumen energía, administrar sus puntos de vida mediante plantas medicinales y conseguir monedas para adquirir mejoras en una tienda.

El proyecto tiene como objetivo aplicar conceptos de programación orientada a objetos y estructuras de datos mediante la implementación de estructuras propias para gestionar los diferentes sistemas del juego.

Caracteristicas principales:

Exploración: Navegación entre diferentes salas mediante un mapa estructurado.

Combate por turnos: enfrentamiento donde el jugador y el enemigo alternan sus acciones.

Selección del personaje: Personalización del nombre y elección del elemento principal.

Habilidades elementales: ataques especiales asociados al elemento seleccionado.

Ataque básico: alternativa de ataque que no requiere consumo de energia.

Sistema de energia: recurso necesario para ejecutar habilidades especiales.

Sistema de curación: Uso de plantas medicinales para recuperar vida durante los combates.

Sistema de recompensas: obtención de monedas al derrotar enemigos.

Tienda de mejoras: adquisición de mejoras de araque y vida.

Historial de partidas: registro de resultados de las partidas.

Exploración: El juego cuenta con un mapa de salas organizado mediante un árbol binario.

El jugador puede desplazarse entre las salas disponibles, explorar diferentes caminos, regresar a salas anteriores y acceder a zonas donde puede encontrarse con enemigos.

Cada sala cuenta con información como su nombre, descripción y estado de presencia de enemigos.

Sistema de combate: El combate funciona mediante turnos alternados entre el jugador y el enemigo.

Durante su turno, el jugador puede:
1. Ejecutar un ataque básico.
2. Utilizar una habilidad elemental si dispone de energía suficiente.
3. Utilizar una planta medicinal para recuperar vida.

Si el jugador no cuenta con la energía necesaria para ejecutar una habilidad, el sistema permite realizar un ataque básico como alternativa.

Al derrotar a un enemigo, el jugador obtiene una recompensa de monedas que puede utilizar posteriormente en la tienda.

Sistema de elementos y habilidades: Al crear su personaje, el jugador puede seleccionar uno de los siguientes elementos:
1. Fuego.
2. Agua.
3. Tierra.
4. Aire.

Las habilidades se almacenan en un archivo JSON y son cargadas dinámicamente mediante un gestor de habilidades.

El sistema filtra las habilidades disponibles según el elemento principal del personaje, permitiendo que cada jugador tenga acceso a ataques asociados a su selección elemental.

Sistema de curación: Durante los combates, el jugador puede utilizar plantas medicinales para recuperar puntos de vida.
El sistema cuenta con las siguientes características:
1. Dos usos de curación por combate.
2. Cada planta recupera hasta 20 puntos de vida.
3. La curación no supera la vida máxima del personaje.
4. Los usos se recargan al iniciar un nuevo combate.
5. La curación se gestiona mediante una estructura de pila.

Sistema económico: El jugador comienza su aventura con monedas que puede utilizar para comprar mejoras.
Al derrotar a un enemigo, obtiene una recompensa de 5 monedas.
Las monedas permiten acceder a mejoras que aumentan las características del personaje, haciendo posible fortalecerlo progresivamente durante la exploración.

Sistema de tienda: La tienda utiliza una estructura de árbol para organizar las mejoras disponibles.

El sistema permite:
1. Comprar mejoras utilizando monedas.
2. Aumentar el ataque del personaje.
3. Aumentar la vida máxima.
4. Desbloquear mejoras progresivamente.
5. Evitar la compra de mejoras ya adquiridas.
6. Consultar las mejoras disponibles, bloqueadas y compradas.

Las mejoras se organizan en diferentes ramas, permitiendo una progresión dentro del sistema de compra.

Estructuras de datos implementadas:

Arbol Binario:
1. Se utiliza para organizar el mapa de salas y permitir la navegación entre diferentes zonas.
Se implementan nodos que almacenan salas y mantienen referencias hacia sus hijos y su nodo padre, facilitando la exploración y el regreso a zonas anteriores.

2. La tienda utiliza nodos para organizar las mejoras, sus relaciones y el sistema de desbloqueo progresivo.
Cada nodo puede almacenar una mejora, referencias a sus nodos hijos y estados que indican si la mejora está desbloqueada o comprada.

Colas: El sistema de combate utiliza una cola para organizar la alternancia entre el turno del jugador y el turno del enemigo.
Esto permite gestionar el orden de las acciones durante el enfrentamiento.

Pilas: Las plantas medicinales se gestionan mediante una estructura de pila, donde los usos disponibles se almacenan y consumen siguiendo el principio LIFO (Last In, First Out).

Lista enlazada: Las habilidades disponibles para el jugador se almacenan en una lista enlazada, permitiendo recorrerlas y seleccionar la habilidad que se desea utilizar durante el combate.

Requisitos del sistema:

1. Windows 10 o Windows 11 de 64 bits.
2. Espacio suficiente para descomprimir los archivos.
3. No se requiere Java instalado.

Instalación y ejecución:

1. Descargar el archivo comprimido del juego.
2. Extraer todo su contenido en carpeta.
3. Ejecutar BatallaPorTurnos.exe


https://drive.google.com/file/d/1-RPiZLd5l0MGAnmDHGQhL7t-kS88-YUi/view?usp=sharing