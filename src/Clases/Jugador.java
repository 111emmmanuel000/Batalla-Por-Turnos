package Clases;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Objects;

public class Jugador extends Personaje{

    private Ataque.TipoAtaque elementoPrincipal;
    public Jugador(String nombre, Ataque.TipoAtaque elementoPrincipal){
        super(nombre,100,12,5,8,0);
        this.elementoPrincipal = Objects.requireNonNull(elementoPrincipal, "El jugador debe tener un elemento principal");
        }

    public Ataque.TipoAtaque getElementoPrincipal(){return elementoPrincipal;}

    public static Jugador crearJugador(BufferedReader br) throws IOException{

        String nombre;
        do{
            System.out.println("Como se llama tu personaje?");
            nombre = br.readLine();
            if(nombre == null) return null;
            nombre = nombre.trim();
            if(nombre.isEmpty()){
                System.out.println("Escribe un nombre para continuar");
            }
        }while(nombre.isEmpty());
        System.out.println("\nElige tu elemento principal: ");
        System.out.println("1. Fuego");
        System.out.println("2. Agua");
        System.out.println("3. Tierra");
        System.out.println("4. Aire");

        while (true) {
            System.out.print("Tu elección: ");
            String opcion = br.readLine();
            if (opcion == null) return null;

            switch (opcion.trim()) {
                case "1":
                    return new Jugador(nombre, Ataque.TipoAtaque.FUEGO);
                case "2":
                    return new Jugador(nombre, Ataque.TipoAtaque.AGUA);
                case "3":
                    return new Jugador(nombre, Ataque.TipoAtaque.TIERRA);
                case "4":
                    return new Jugador(nombre, Ataque.TipoAtaque.AIRE);
                default:
                    System.out.println("Elige un numero del 1 al 4");
            }
        }
    }
}

