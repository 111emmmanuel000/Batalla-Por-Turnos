package Clases;

public class Arbol{
    private NodoA raiz;
    String reset = "\033[0m";
    String rojo = "\033[31m";
    String azul = "\033[34m";
    String gris = "\033[37m";
    String verde = "\033[32m";
    String amarillo = "\033[33m";
    public Arbol() {
        raiz = new NodoA(new Sala("Entrada", "Frente a ti hay dos caminos posibles...", false));

        NodoA puertaA = new NodoA(new Sala(verde + "El Bosque" + reset, "Entre los pinos se oye correr el agua.", true));
        NodoA puertaB = new NodoA(new Sala(amarillo + "La Caverna" + reset, "Un golpe de metal rompe el silencio.", true));

        raiz.setIzquierda(puertaA);
        raiz.setDerecha(puertaB);

        NodoA puertaAa = new NodoA(new Sala(azul + "El Lago" + reset, "Algo tira de una barca desde el fondo.", true));
        NodoA puertaAb = new NodoA(new Sala(gris + "Bosque Alto" + reset, "Una sombra te observa desde las ramas.", true));

        puertaA.setIzquierda(puertaAa);
        puertaA.setDerecha(puertaAb);

        NodoA puertaBa = new NodoA(new Sala(rojo + "Ruinas Volcánicas" + reset, "La lava ilumina un puente de piedra.", true));
        NodoA puertaBb = new NodoA(new Sala("La mina", "Una vagoneta vacía rueda hacia ti.", true));

        puertaB.setIzquierda(puertaBa);
        puertaB.setDerecha(puertaBb);
    }

    public NodoA getRaiz(){return raiz;}
}
