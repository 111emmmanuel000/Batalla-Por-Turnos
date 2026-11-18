package Clases;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Juego {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void menu() throws IOException{

        String op;
        do{
            System.out.println("---Menu---");
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
        Arbol mapa = new Arbol();
        Nodo salaActual = mapa.getRaiz();

        while(true){
            String italic = "\033[1;3m";
            String reset = "\033[0m";
            Sala sala = salaActual.getDato();
            System.out.println("-------------------------------------");
            System.out.println("            Estas en: \n" + "            " + italic + sala.getNombre() + reset) ;
            System.out.println("'" +sala.getDescripcion()+"'\n");

            Nodo izquierda = salaActual.getIzquierda();
            Nodo derecha = salaActual.getDerecha();

            Nodo siguiente = null;
            do{
                if(izquierda != null) System.out.println("1. ir a:  " + izquierda.getDato().getNombre());
                if(derecha != null) System.out.println("2. ir a: " + derecha.getDato().getNombre());
                System.out.println("0.volver al menu");
                System.out.println("Elige una opcion: ");

                String opcion = br.readLine();
                if(opcion == null ) return;

                switch(opcion.trim()){
                    case "1":
                        siguiente = izquierda;
                        break;
                    case "2":
                        siguiente = derecha;
                        break;
                    case "0":
                        return;

                }
                if(siguiente == null){
                    System.out.println("Elige una de las puertas disponibles");
                }
            }while(siguiente == null);
            salaActual = siguiente;
        }

    }

}
