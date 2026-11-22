package Clases;

public class Sala {
    private String nombre;
    private String descripcion;
    private boolean enemigo;

    public Sala(String nombre, String descripcion,boolean enemigo){
        this.nombre = nombre;
        this.descripcion=descripcion;
        this.enemigo = enemigo;
    }

    public String getNombre() {return nombre;}

    public String getDescripcion() {return descripcion;}

    public boolean isEnemigo() {return enemigo;}

    public void enemigoDerrotado(){enemigo = false;}
}
