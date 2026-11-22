package Clases;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Objects;

public class Jugador extends Personaje{

    private Ataque.TipoAtaque elementoPrincipal;
    public Jugador(String nombre, Ataque.TipoAtaque elementoPrincipal){
        super(nombre,100,12,5,8,10);
        this.elementoPrincipal = Objects.requireNonNull(elementoPrincipal, "El jugador debe tener un elemento principal");
        }

    public Ataque.TipoAtaque getElementoPrincipal(){return elementoPrincipal;}

    public static Jugador crearJugador(BufferedReader br) throws IOException{

        String nombre;
        do{
            System.out.println("---------------------------------");
            System.out.println("Como se llama tu personaje?");
            nombre = br.readLine();
            if(nombre == null) return null;
            nombre = nombre.trim();
            if(nombre.isEmpty()){
                System.out.println("Escribe un nombre para continuar");
            }
        }while(nombre.isEmpty());
        String reset = "\033[0m";
        String rojo = "\033[31m";
        String azul = "\033[34m";
        String gris = "\033[37m";
        String verde = "\033[32m";

        System.out.println("---------------------------------");
        System.out.println("\nElige tu elemento principal: \n");
        System.out.println(rojo + "    1. Fuego" + reset);
        System.out.println(azul + "    2. Agua" + reset);
        System.out.println(verde + "    3. Tierra" + reset);
        System.out.println(gris +  "    4. Aire" + reset);

        while (true) {
            System.out.print("\nTu elección: \n");
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

