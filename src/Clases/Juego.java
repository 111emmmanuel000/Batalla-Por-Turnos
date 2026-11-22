package Clases;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Juego {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void menu() throws IOException{

        String op;
        do{
            System.out.println("\n------------ M E N U ------------\n");
            System.out.println("1. Iniciar partida");
            System.out.println("2. Historial de partidas");
            System.out.println("0. Salir");

            op = br.readLine();

            switch(op.trim()){
                case "1":
                    iniciarPartidda();
                    break;
                case "2":
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opcion invalida, elija 0,1 o 2");
            }
        }while(!op.equals("0"));
    }

    private void iniciarPartidda() throws IOException{

        String italic = "\033[1;3m";
        String reset = "\033[0m";
        String rojo = "\033[31m";
        String azul = "\033[34m";
        String gris = "\033[37m";
        String verde = "\033[32m";

        Arbol mapa = new Arbol();
        Jugador jugador = Jugador.crearJugador(br);
        Combate combate = new Combate(jugador);
        if(jugador == null) return;
        System.out.println(jugador.getNombre() + " entra a la mazmorra con el elemento de " + jugador.getElementoPrincipal());
        NodoA salaActual = mapa.getRaiz();

        while(true){

            Sala sala = salaActual.getDato();
            System.out.println("-------------------------------------");
            System.out.println("            Estas en: \n" + "            " + italic + sala.getNombre() + reset) ;
            System.out.println("'" +sala.getDescripcion()+"'\n");

            NodoA izquierda = salaActual.getIzquierda();
            NodoA derecha = salaActual.getDerecha();

            NodoA siguiente = null;
            do{
                if(izquierda != null)  System.out.println("1. ir hacia  " + izquierda.getDato().getNombre());
                if(derecha != null) System.out.println("2. ir hacia " + derecha.getDato().getNombre());
                if(salaActual.getPadre() != null){System.out.println("3. volver a "+ salaActual.getPadre().getDato().getNombre());}
                System.out.println("4. consultar vida ");
                System.out.println(rojo + "0. Salir del juego\n" + reset);
                System.out.println("Elige una opcion: ");

                String opcion = br.readLine();
                if(opcion == null ) return;

                switch(opcion.trim()){
                    case "1":
                        siguiente = izquierda;
                        if(izquierda.getDato().isEnemigo()) combate.combate();
                        break;
                    case "2":
                        siguiente = derecha;
                        if(derecha.getDato().isEnemigo()) combate.combate();
                        break;
                    case "3":
                        siguiente = salaActual.getPadre();
                        break;
                    case "4":
                        System.out.println(jugador.getVida());
                        break;
                    case "0":
                        return;

                }
                if(siguiente == null){
                    System.out.println("-------------------------------------");
                    System.out.println("Elige una de las salas disponibles\n");
                }
                if (jugador.getVida() <= 0) {
                    derrota();
                    return;
                }
            }while(siguiente == null);
            salaActual = siguiente;
        }

    }

    private void derrota(){
        System.out.println();
        System.out.println("");
        System.out.println("=================================");
        System.out.println("        G A M E   O V E R        ");
        System.out.println("=================================");
        System.out.println("Has muerto...");

    }

}
