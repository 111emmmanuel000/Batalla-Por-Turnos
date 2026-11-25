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

# Dónde se usan las estructuras de datos

Pila (stack): en la planta medicinal (PlantaMedicinal.java). Se implementa con un ArrayDeque usado como pila: al empezar cada combate se hacen dos push, y cada curación hace un pop. Por eso tiene exactamente dos usos por combate.

Cola (queue): en los turnos del combate (Combate.java). La cola alterna entre "jugador" y "enemigo": en cada vuelta se toma el frente con peek(), se quita con poll() y se vuelve a meter al final con offer().

Árbol:

Mapa de salas (Arbol.java, NodoA.java): árbol binario donde la Entrada es la raíz. Cada nodo guarda su padre, lo que permite la opción "volver a..." y calcular la profundidad de una sala.
Mejoras de la tienda (Tienda.java, NodoM.java): cada mejora es un nodo, y solo se puede comprar cuando su padre ya está desbloqueado.

Lista enlazada: las habilidades del jugador (gestorHabilidades.java y Combate.java). Se cargan desde Habilidades.json en un LinkedList, filtradas por el elemento del jugador.

# Cómo correr el juego
descomprime el archivo y abre el ejecutable
