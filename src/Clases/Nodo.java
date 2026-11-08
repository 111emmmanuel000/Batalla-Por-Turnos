package Clases;

public class Nodo{
    private Sala dato;
    private Nodo izquierda,derecha;

    public Nodo(Sala dato){this.dato=dato;}

    public Sala getDato() {return dato;}

    public Nodo getIzquierda() {return izquierda;}

    public Nodo getDerecha() {return derecha;}

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;

    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }
}
