package Clases;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.fusesource.jansi.Ansi;

public class Juego {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final HistorialPartidas historial = new HistorialPartidas();

    public void menu() throws IOException{

        String op;
        do{
            Consola.limpiar();
            System.out.println(Ansi.ansi()
                    .fg(Ansi.Color.CYAN)
                    .a("\n------------ M E N U ------------")
                    .reset());
            System.out.println("1. Iniciar partida");
            System.out.println("2. Historial de partidas");
            System.out.println("0. Salir");

            op = br.readLine();
            if(op == null) return;

            switch(op.trim()){
                case "1":
                    iniciarPartidda();
                    break;
                case "2":
                    historial.mostrarHistorial();
                    System.out.println("\nPulsa Enter para volver al menú...");
                    br.readLine();
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

        String fondoRojo = "\033[41m";
        String fondoVerde = "\u001B[42m";

        Arbol mapa = new Arbol();
        Jugador jugador = Jugador.crearJugador(br);
        if(jugador == null) return;
        Combate combate = new Combate(jugador);
        Tienda tienda = new Tienda();

        System.out.println(jugador.getNombre() + " entra a la mazmorra con el elemento de " + jugador.getElementoPrincipal());
        NodoA salaActual = mapa.getRaiz();

        while(true){
            Consola.limpiar();
            Sala sala = salaActual.getDato();
            NodoA izquierda = salaActual.getIzquierda();
            NodoA derecha = salaActual.getDerecha();
            NodoA siguiente = null;
            do{

                System.out.println("\n-------------------------------------");
                System.out.println("            Estas en: \n" + "            " + italic + sala.getNombre() + reset) ;
                System.out.println("'" +sala.getDescripcion()+"'");
                System.out.println("-------------------------------------\n");

                System.out.println("Vida:" +fondoRojo+"        "+ jugador.getVida()+"        "+ reset);
                System.out.println("Energia:" +fondoVerde+"        "+ jugador.getEnergia()+"        "+ reset);
                System.out.println("Ataque: " + jugador.getAtaque());
                System.out.println("Monedas: " + jugador.getMonedas());

                if(izquierda != null)  System.out.println("\n1. ir hacia  " + izquierda.getDato().getNombre());
                if(derecha != null) System.out.println("2. ir hacia " + derecha.getDato().getNombre());
                if(salaActual.getPadre() != null){System.out.println("3. volver a "+ salaActual.getPadre().getDato().getNombre());}
                System.out.println("4. Tienda");
                System.out.println(rojo + "0. Salir del juego\n" + reset);
                System.out.println("Elige una opcion: ");

                String opcion = br.readLine();
                if(opcion == null ) {
                    historial.registrarPartida(jugador, "Interrumpida");
                    return;
                }

                switch(opcion.trim()){
                    case "1":
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        siguiente = izquierda;
                        break;
                    case "2":
                        siguiente = derecha;
                        break;
                    case "3":
                        siguiente = salaActual.getPadre();
                        break;
                    case "4":
                        tienda.abrir(jugador);
                        break;
                    case "0":
                        historial.registrarPartida(jugador, "Abandonada");
                        return;

                }
                Consola.limpiar();
                if(siguiente == null){
                    System.out.println("-------------------------------------");
                    System.out.println("Elige una de las salas disponibles\n");
                }
            }while(siguiente == null);

            Sala destino = siguiente.getDato();

            if(siguiente != salaActual.getPadre() && destino.isEnemigo()){
                combate.combate(profundidad(siguiente) >= 2);

                if (jugador.getVida() <= 0) {
                    derrota();
                    historial.registrarPartida(jugador, "Derrota");
                    return;
                }

                if (combate.victoria) {
                    destino.enemigoDerrotado();
                    System.out.println("\n" + verde + "=== V I C T O R I A ===" + reset);

                    if (siguiente.getIzquierda() == null && siguiente.getDerecha() == null) {
                        System.out.println("Has derrotado al guardián de " + destino.getNombre() + ".");
                    }

                    System.out.println("Pulsa Enter para continuar...");
                    br.readLine();
                }
            }

            salaActual = siguiente;
        }

    }
    private int profundidad(NodoA nodo){
        int n = 0;
        while(nodo.getPadre() != null){
            n++;
            nodo = nodo.getPadre();
        }
        return n;
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
