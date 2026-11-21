package Clases;

public class NodoA {
    private Sala dato;
    private NodoA izquierda,derecha;
    private NodoA padre;

    public NodoA(Sala dato){this.dato=dato;}

    public Sala getDato() {return dato;}

    public NodoA getPadre(){return padre;}

    public NodoA getIzquierda() {return izquierda;}

    public NodoA getDerecha() {return derecha;}

    public void setIzquierda(NodoA izquierda) {
        this.izquierda = izquierda;
        if(izquierda != null){
            izquierda.padre =this;
        }
    }

    public void setDerecha(NodoA derecha) {
        this.derecha = derecha;
        if(derecha != null){
            derecha.padre = this;
        }
    }
}
