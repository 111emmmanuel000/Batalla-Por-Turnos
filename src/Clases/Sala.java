package Clases;

public class Sala {
    private String nombre;
    private String descripcion;
    private boolean enemigo;
    private Enemigo rival;
    public Sala(String nombre, String descripcion,boolean enemigo, Enemigo riva){
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.enemigo = enemigo;
         this.rival = rival;
    }

    public String getNombre() {return nombre;}

    public String getDescripcion() {return descripcion;}

    public boolean isEnemigo() {return enemigo;}

    public void enemigoDerrotado(){enemigo = false;}
}
