package Clases;

public class Personaje{
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;

    //creamos el metodo constructor.
    public Personaje (String nombre, int vida, int ataque, int defensa, int velocidad){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    //Creamos los Getters y Setters para cada atributo.
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        this.vida = vida;
    }

    public void recibirDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("El daño no puede ser negativo");
        }
        vida = Math.max(0, vida - dano);
    }

    public int getAtaque(){
        return ataque;
    }
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }

    public int getDefensa(){
        return defensa;
    }
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
    public int getVelocidad(){
        return velocidad;
    }
    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

}