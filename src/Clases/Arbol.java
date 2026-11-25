package Clases;

public class Arbol{
    private NodoA raiz;
    String reset = "\033[0m";
    String rojo = "\033[31m";
    String azul = "\033[34m";
    String gris = "\033[37m";
    String verde = "\033[32m";
    String amarillo = "\033[33m";
    public Arbol(){
        raiz = new NodoA(new Sala("Entrada","Frente a ti hay dos caminos posibles...",false));
        NodoA puertaA = new NodoA(new Sala(verde + "El Bosque" + reset, "",true));
        NodoA puertaB = new NodoA(new Sala(amarillo + "La Caverna"+ reset ,"",true));
        raiz.setIzquierda(puertaA);
        raiz.setDerecha(puertaB);
        NodoA puertaAa = new NodoA(new Sala(azul + "El Lago" + reset, "",true));
        NodoA puertaAb = new NodoA(new Sala(gris + "Bosque Alto"+ reset, "",true));
        puertaA.setIzquierda(puertaAa);
        puertaA.setDerecha(puertaAb);
        NodoA puertaBa = new NodoA(new Sala(rojo + "Ruinas Volcanicas"+ reset, "",true));
        NodoA puertaBb = new NodoA(new Sala("Puerda derecha lado B", "",true));
        puertaB.setIzquierda(puertaBa);
        puertaB.setDerecha(puertaBb);

    }

    public NodoA getRaiz(){return raiz;}
}
