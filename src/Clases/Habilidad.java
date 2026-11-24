package Clases;

public class Habilidad {
    private int id;
    private String nombre;
    private Ataque.TipoAtaque elemento;
    private int dano;
    private int costoEnergia;
    private String descripcion;
    
    public Habilidad (int id, String nombre, Ataque.TipoAtaque elemento, int dano, int costoEnergia, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.elemento = elemento;
        this.dano = dano;
        this.costoEnergia = costoEnergia;
        this.descripcion = descripcion;
    }
        public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Ataque.TipoAtaque getElemento() {
        return elemento;
    }

    public int getDanio() {
        return dano;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
