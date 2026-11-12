package Clases;

import java.util.Objects;

public class Ataque{
    public enum TipoAtaque { // enum es un tipo de dato que permite definir un conjunto de constantes con nombre, 
        FUEGO,               // en este caso los tipos de ataque.
        AGUA,
        TIERRA,
        AIRE,
        ESPADA
    }

    private int fuego;
    private int agua;
    private int tierra;
    private int aire;
    private int espada;

    //creamos el metodo constructor.
    public Ataque (int fuego, int agua, int tierra, int aire, int espada){
        this.fuego = validarDano(fuego);
        this.agua = validarDano(agua);
        this.tierra = validarDano(tierra);
        this.aire = validarDano(aire);
        this.espada = validarDano(espada);
    }

    //Creamos los Getters y Setters para cada atributo.
    public int getFuego() {
        return fuego;
    }

    public void setFuego(int fuego) {
        this.fuego = validarDano(fuego);
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = validarDano(agua);
    }

    public int getTierra() {
        return tierra;
    }

    public void setTierra(int tierra) {
        this.tierra = validarDano(tierra);
    }

    public int getAire() {
        return aire;
    }

    public void setAire(int aire) {
        this.aire = validarDano(aire);
    }

    public int getEspada() {
        return espada;
    }

    public void setEspada(int espada) {
        this.espada = validarDano(espada);
    }

    public int getDano(TipoAtaque tipo) {
        switch (Objects.requireNonNull(tipo, "El tipo de ataque no puede ser null")) {
            case FUEGO:
                return fuego;
            case AGUA:
                return agua;
            case TIERRA:
                return tierra;
            case AIRE:
                return aire;
            case ESPADA:
                return espada;
            default:
                throw new IllegalArgumentException("Tipo de ataque no válido");
        }
    }

    public void atacar(Personaje objetivo, TipoAtaque tipo) {
        Objects.requireNonNull(objetivo, "El objetivo no puede ser null");
        objetivo.recibirDano(getDano(tipo));
    }

    private int validarDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("El daño no puede ser negativo");
        }
        return dano;
    }
}