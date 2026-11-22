package Clases;

public class Personaje{
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;
    private int monedas = 10;


    //creamos el metodo constructor.
    public Personaje (String nombre, int vida, int ataque, int defensa, int velocidad, int monedas){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.monedas = monedas;
    }

    //Creamos los Getters y Setters para cada atributo.
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        if(nombre.equals("")){
            throw new IllegalArgumentException("Ingrese un nombre para el personaje.");
        }
        this.nombre = nombre;
    }
    public int getVida(){
        return vida;
    }
    public void setVida(int vida){
        if(vida < 0){
            throw new IllegalArgumentException("La vida no puede ser negativa");
        }
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
        if(ataque <= 0){
            throw new IllegalArgumentException("El ataque debe ser positivo");
        }
        this.ataque = ataque;
    }

    public int getDefensa(){
        return defensa;
    }
    public void setDefensa(int defensa){
        if(defensa <= 0){
            throw new IllegalArgumentException("El valor de la defensa no puede ser igual a 0");
        }
        this.defensa = defensa;
    }
    public int getVelocidad(){
        return velocidad;
    }
    public void setVelocidad(int velocidad){
        if(velocidad <= 0){
            throw new IllegalArgumentException("La velocidad debe positiva");
        }
        this.velocidad = velocidad;
    }
    
    public int getMonedas(){
        return monedas;
    }
    public void setMonedas(int monedas){
        if(monedas <0){
            throw new IllegalArgumentException("la cantidad de monedas debe ser positiva");
        }
        this.monedas = monedas;
    }
    public void agregarMonedas(int cantidad){
        if(cantidad<=0){
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        monedas += cantidad;
    }
    public boolean gastarMonedas(int cantidad){
        if(cantidad <= 0 || cantidad > monedas){
            return false;
        }
        monedas -= cantidad;
        return true;
    }
}
