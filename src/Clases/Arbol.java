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
        raiz = new NodoA(new Sala("Entrada","Frente a ti hay dos caminos posibles..."));
        Sala bosque = new Sala(verde + "El Bosque" + reset, "");
        bosque.agregarEnemigo(new Enemigo("Goblin", 60, 8, 3, 6, 8));
        bosque.agregarEnemigo(new Enemigo("Lobo", 45, 10, 2, 10, 6));
        NodoA puertaA = new NodoA(bosque);

        Sala caverna = new Sala(amarillo + "La Caverna"+ reset ,"");
        caverna.agregarEnemigo(new Enemigo("Murcielago", 40, 7, 2, 12, 5));
        caverna.agregarEnemigo(new Enemigo("Esqueleto", 55, 9, 4, 5, 7));
        NodoA puertaB = new NodoA(caverna);

        raiz.setIzquierda(puertaA);
        raiz.setDerecha(puertaB);
        Sala lago = new Sala(azul + "El Lago" + reset, "");
        lago.agregarEnemigo(new Enemigo("Rana", 50, 8, 3, 7, 6));
        lago.agregarEnemigo(new Enemigo("sanguijuela", 55, 11, 2, 9, 8));
        NodoA puertaAa = new NodoA(lago);

        Sala bosqueAlto = new Sala(gris + "Bosque Alto"+ reset, "");
        bosqueAlto.agregarEnemigo(new Enemigo("Orco", 75, 12, 5, 4, 12));
        bosqueAlto.agregarEnemigo(new Enemigo("Duende", 45, 9, 2, 11, 7));
        NodoA puertaAb = new NodoA(bosqueAlto);

        puertaA.setIzquierda(puertaAa);
        puertaA.setDerecha(puertaAb);
        Sala ruinas = new Sala(rojo + "Ruinas Volcanicas"+ reset, "");
        ruinas.agregarEnemigo(new Enemigo("bestia de lava", 80, 13, 6, 5, 15));
        ruinas.agregarEnemigo(new Enemigo("esqueletos volcanicos", 90, 14, 7, 6, 18));
        ruinas.agregarEnemigo(new Enemigo("Golem", 100, 12, 9, 3, 20));
        NodoA puertaBa = new NodoA(ruinas);

        Sala ladoB = new Sala("Puerda derecha lado B", "");
        ladoB.agregarEnemigo(new Enemigo("Bandido", 65, 10, 4, 8, 10));
        ladoB.agregarEnemigo(new Enemigo("Arquero", 50, 12, 3, 9, 11));
        NodoA puertaBb = new NodoA(ladoB);

        puertaB.setIzquierda(puertaBa);
        puertaB.setDerecha(puertaBb);

    }

    public NodoA getRaiz(){return raiz;}
}