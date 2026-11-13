package Clases;

public class NodoM {
    final Mejora mejora;   // null en el nodo raíz "tienda"
    NodoM izq;
    NodoM der;
    boolean desbloqueado;  // se puede comprar
    boolean comprada;

    NodoM(Mejora mejora) {
        this.mejora = mejora;
    }
}
