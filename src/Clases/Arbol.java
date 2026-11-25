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
        NodoA puertaA = new NodoA(new Sala(verde + "El Bosque" + reset, "Árboles retorcidos bloquean la luz y algo acecha entre las sombras.",true));
        NodoA puertaB = new NodoA(new Sala(amarillo + "La Caverna"+ reset ,"El eco de tus pasos resuena entre las paredes de piedra.",true));
        raiz.setIzquierda(puertaA);
        raiz.setDerecha(puertaB);
        NodoA puertaAa = new NodoA(new Sala(azul + "El Lago" + reset, "El agua parece tranquila, pero algo se mueve bajo la superficie.",true));
        NodoA puertaAb = new NodoA(new Sala(gris + "Montaña"+ reset, "El viento golpea con fuerza y el camino es cada vez más estrecho.",true));
        puertaA.setIzquierda(puertaAa);
        puertaA.setDerecha(puertaAb);
        NodoA puertaBa = new NodoA(new Sala(rojo + "Ruinas Volcanicas"+ reset, "El calor es sofocante y la lava ilumina el camino.",true));
        NodoA puertaBb = new NodoA(new Sala(amarillo + "Desierto" + reset, "La arena y el calor dificultan cada paso.",true));
        puertaB.setIzquierda(puertaBa);
        puertaB.setDerecha(puertaBb);

    }

    public NodoA getRaiz(){return raiz;}
}
