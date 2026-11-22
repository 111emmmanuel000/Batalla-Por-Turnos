package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Sala {
    private String nombre;
    private String descripcion;
    private final List<Enemigo> enemigos = new ArrayList<>();

    public Sala(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion=descripcion;
    }

    public String getNombre() {return nombre;}

    public String getDescripcion() {return descripcion;}

    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(Objects.requireNonNull(enemigo, "El enemigo no puede ser null"));
    }

    public List<Enemigo> getEnemigos() {
        return Collections.unmodifiableList(enemigos);
    }

    public boolean tieneEnemigos() {
        return !enemigos.isEmpty();
    }
}
