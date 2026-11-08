package Clases;

public class Arbol{
    private Nodo raiz;
    public Arbol(){
        raiz = new Nodo(new Sala("Entrada",""));
        Nodo puertaA = new Nodo(new Sala("Puerta izquierda", ""));
        Nodo puertaB = new Nodo(new Sala("puerta derecha",""));
        raiz.setIzquierda(puertaA);
        raiz.setDerecha(puertaB);
        Nodo puertaAa = new Nodo(new Sala("Puerta izquierda lado A", ""));
        Nodo puertaAb = new Nodo(new Sala("Puerta derecha lado A", ""));
        puertaA.setIzquierda(puertaAa);
        puertaA.setDerecha(puertaAb);
        Nodo puertaBa = new Nodo(new Sala("Puerda izquierda lado B", ""));
        Nodo puertaBb = new Nodo(new Sala("Puerda derecha lado B", ""));
        puertaB.setIzquierda(puertaBa);
        puertaB.setDerecha(puertaBb);

    }

    public Nodo getRaiz(){return raiz;}
}