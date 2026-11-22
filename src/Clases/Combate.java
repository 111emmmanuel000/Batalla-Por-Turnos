package Clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Combate {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Jugador jugador;

    public Combate(Jugador jugador){
        this.jugador = jugador;
    }

    void combate()throws IOException{
        int vidaEnemigo = 100;
        int ataqueEnemigo = 10;

        Queue<String> turnos = new ArrayDeque<>();
        turnos.offer("jugador");
        turnos.offer("enemigo");
        String op = "";

        System.out.println("---------------------------------");
        System.out.println("Ha aparecido un enemigo\n");
        while(jugador.getVida() > 0 && vidaEnemigo > 0){
            String turnoActual = turnos.peek();


            if("jugador".equals(turnoActual)) {
                System.out.println("---------------------------------");
                System.out.println("\nTu turno");
                System.out.println("1. Atacar");
                System.out.println("2. huir");

                op = br.readLine();

                if (op == null) return;


                switch (op.trim()) {
                    case "1":
                        vidaEnemigo = vidaEnemigo - jugador.getAtaque();
                        System.out.println("Vida del enemigo: " + vidaEnemigo);
                        break;

                }
            }else{
                int vidaJugador = jugador.getVida() - ataqueEnemigo;
                jugador.setVida(vidaJugador);
                System.out.println("El enemigo ataco, tu vida: " + vidaJugador);
            }

            turnos.poll();
            turnos.offer(turnoActual);

        }
    }

}
