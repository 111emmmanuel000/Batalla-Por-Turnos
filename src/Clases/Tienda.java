package Clases;

public class Tienda {
    final NodoM raiz = new NodoM(null);

    Tienda() {

        NodoM piedra3    = new NodoM(new Mejora("piedraDeAfilar", 3, Mejora.Efecto.DAÑO));
        NodoM vidaMax3   = new NodoM(new Mejora("vidaMax",        5, Mejora.Efecto.VIDA));
        NodoM vidaMax5   = new NodoM(new Mejora("vidaMax",        5, Mejora.Efecto.VIDA));
        NodoM piedra5    = new NodoM(new Mejora("piedraDeAfilar", 5, Mejora.Efecto.DAÑO));


        //primeras mejoras para comprar
        raiz.izq = vidaMax3;
        raiz.der = piedra3;

        // hijo de vidaMax3
        vidaMax3.izq = vidaMax5;

        // hijo de piedra3
        piedra3.der = piedra5;

        // los primeros dos nodos están disponibles al inicio
        vidaMax3.desbloqueado = true;
        piedra3.desbloqueado = true;
    }

    String comprar(NodoM nodo, Personaje jugador) {
        if (nodo == null || nodo.mejora == null) return "Esa mejora no existe.";
        if (nodo.comprada) return "Ya comprada " + nodo.mejora.nombre + ".";
        if (!nodo.desbloqueado) return "Primero compra la mejora anterior.";
        if (jugador.getMonedas() < nodo.mejora.costo) {
            return "No tienes monedas suficientes para " + nodo.mejora.nombre +
                    " cuesta " + nodo.mejora.costo;
        }

        jugador.setMonedas(getMonedas() - nodo.mejora.costo);
        nodo.mejora.aplicar(jugador);
        nodo.comprada = true;

        // se desbloquean los hijos
        if (nodo.izq != null) nodo.izq.desbloqueado = true;
        if (nodo.der != null) nodo.der.desbloqueado = true;

        return "Compraste " + nodo.mejora.nombre + ".";
    }

    void mostrar() {
        mostrar(raiz, 0);
    }

    private void mostrar(NodoM nodo, int nivel) {
        if (nodo == null) return;
        String texto = (nodo.mejora == null) ? "tienda" :
                nodo.mejora.nombre + " (costo " + nodo.mejora.costo + ")" +
                        (nodo.comprada ? " [comprada]" : nodo.desbloqueado ? "" : " [bloqueado]");
        System.out.println("    ".repeat(nivel) + texto);
        mostrar(nodo.izq, nivel + 1);
        mostrar(nodo.der, nivel + 1);
    }
}
