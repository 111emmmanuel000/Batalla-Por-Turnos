package Clases;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Tienda {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        jugador.setMonedas(jugador.getMonedas() - nodo.mejora.costo);
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

    void abrir(Jugador jugador)throws IOException {
        NodoM actual = raiz;
        Consola.limpiar();
        while (true) {

            System.out.println("----------T I E N D A----------");
            System.out.println("Monedas: " + jugador.getMonedas());

            if (actual == raiz) {
                System.out.println("\nElige una rama de mejoras: \n");
            } else {
                System.out.println("Estas en " + actual.mejora.nombre);

                if (actual.izq == null && actual.der == null) {
                    System.out.println("Completaste esta rama");
                }
            }
            if (actual.izq != null) {
                System.out.println("1. Comprar:");
                mostrar(actual.izq, 0);
            }
            if (actual.der != null) {
                System.out.println("2. Comprar:");
                mostrar(actual.der, 0);
            }

            if (actual != raiz) {
                System.out.println("3. volver al inicio de la tienda");
            }
            System.out.println("\n0. salir de la tienda");
            System.out.println("Elige una opcion: ");

            String op = br.readLine();

            if (op == null) return;

            Consola.limpiar();

            NodoM siguiente;

            switch (op.trim()) {
                case "1":
                    if (actual.izq == null) {
                        System.out.println("Opcion 1 invalida, aqui no hay mejoras");
                        continue;
                    }
                    siguiente = actual.izq;
                    break;

                case "2":
                    if (actual.der == null) {
                        System.out.println("Opcion 2 invalida, aqui no hay mejoras");
                        continue;
                    }
                    siguiente = actual.der;
                    break;

                case "3":
                    actual = raiz;
                    System.out.println("Estás en el inicio de la tienda.");
                    continue;

                case "0":
                    return;

                default:
                    System.out.println("Opción inválida. Elige uno de los números del menú.");
                    continue;
            }

            if (!siguiente.comprada) {
                System.out.println(comprar(siguiente, jugador));
            }

            if (siguiente.comprada) {
                actual = siguiente;
            }
        }

    }
}
