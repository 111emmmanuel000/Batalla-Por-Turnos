package Clases;

public class Sala {
    private String nombre;
    private String descripcion;

    public Sala(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion=descripcion;
    }

    public String getNombre() {return nombre;}

    public String getDescripcion() {return descripcion;}

}
