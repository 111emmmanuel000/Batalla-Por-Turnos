package Clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.LinkedList;

public class Combate {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Jugador jugador;
    boolean victoria;
    LinkedList<Habilidad> habilidadesJugador;
    private final PlantaMedicinal planta = new PlantaMedicinal();
    private static final int VIDA_MAXIMA = 100;

    public Combate(Jugador jugador){
        this.jugador = jugador;
        this.habilidadesJugador = gestorHabilidades.cargarPorElemento(
                jugador.getElementoPrincipal()
        );
    }
    private int seleccionarHabilidad() throws IOException {
        //Creamos ciclo que se repite en caso de que el usuario ingrese una opción incorrecta.
        while (true) {
            System.out.println("\n----- SELECCION DE ATAQUE -----");
            System.out.println("0. Ataque basico - " + jugador.getAtaque() + " de daño");
            //Ciclo para listar las habilidades del jugador y que pueda seleccionar una opción.
            for (int i = 0; i < habilidadesJugador.size(); i++) {
                Habilidad habilidad = habilidadesJugador.get(i);
                System.out.println((i + 1) + ". " + habilidad.getNombre()
                        + " | Daño: " + habilidad.getDano()
                        + " | Energia: " + habilidad.getCostoEnergia());
            }
            System.out.println("\nEnergia disponible: " + jugador.getEnergia());
            System.out.print("Selecciona tu ataque: ");
            String opcion = br.readLine();
            if (opcion == null) {
                return -1;
            }
            if (opcion.trim().equals("0")) {
                return 0;
            }
            try {
                int seleccion = Integer.parseInt(opcion.trim());
                //Comprobamos que el jugador seleccione una opción valida (de 1 a 3).
                if (seleccion >= 1 && seleccion <= habilidadesJugador.size()) {
                    return seleccion;
                }
                System.out.println("Selecciona una opcion valida.");
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un numero.");
            }
        }
    }

    void combate()throws IOException{
        int vidaEnemigo = 60;
        int ataqueEnemigo = 10;
        planta.recargar();

        Queue<String> turnos = new ArrayDeque<>();
        turnos.offer("jugador");
        turnos.offer("enemigo");
        String op = "";

        System.out.println("---------------------------------");
        System.out.println("Ha aparecido un enemigo");
        while(jugador.getVida() > 0 && vidaEnemigo > 0){
            String turnoActual = turnos.peek();


            if("jugador".equals(turnoActual)) {
                System.out.println("---------------------------------");
                System.out.println("\nTu turno");
                System.out.println("1. Atacar");
                System.out.println("2. huir");
                if (planta.tieneUsos()) {
                    System.out.println("3. Usar planta medicinal (quedan " + planta.usosRestantes() + ")");
                }

                op = br.readLine();

                if (op == null) return;


                switch (op.trim()) {
                    case "3":
                        if (!planta.tieneUsos()) {
                            System.out.println("Ya no te quedan usos de la planta.");
                            continue;
                        }
                        if (jugador.getVida() >= VIDA_MAXIMA) {
                            System.out.println("Tu vida ya está al máximo.");
                            continue;
                        }
                        int curado = planta.usar(jugador, VIDA_MAXIMA);
                        System.out.println("Recuperaste " + curado + " de vida.");
                        break;
                    case "1":
                        int seleccion = seleccionarHabilidad();
                        // Verificar si se terminó la entrada de datos
                        if (seleccion == -1) {
                            return;
                        }
                        // Opcion 0: ataque basico
                        if (seleccion == 0) {
                            vidaEnemigo -= jugador.getAtaque();
                            System.out.println("Utilizaste un ataque basico.");
                            System.out.println("Daño causado: " + jugador.getAtaque());
                        } else {
                            // Obtener la habilidad seleccionada
                            Habilidad habilidad = habilidadesJugador.get(seleccion - 1);
                            // Verificar si tiene suficiente energia
                            if (jugador.gastarEnergia(habilidad.getCostoEnergia())) {
                                vidaEnemigo -= habilidad.getDano();
                                System.out.println("Utilizaste: " + habilidad.getNombre());
                                System.out.println("Daño causado: " + habilidad.getDano());
                            } else {
                                // Si no tiene energia, utiliza ataque basico
                                vidaEnemigo -= jugador.getAtaque();
                                System.out.println("No tienes suficiente energia.");
                                System.out.println("Se ejecutara un ataque basico.");
                                System.out.println("Daño causado: " + jugador.getAtaque());
                            }
                        }
                        // Evitar que la vida del enemigo sea negativa
                        vidaEnemigo = Math.max(0, vidaEnemigo);
                        System.out.println("Energia restante: " + jugador.getEnergia());
                        System.out.println("Vida del enemigo: " + vidaEnemigo);
                        break;
                     default:
                        System.out.println("Opcion invalida.");
                        continue;
                }
            }else{
                int vidaJugador = jugador.getVida() - ataqueEnemigo;
                jugador.setVida(vidaJugador);
                System.out.println("El enemigo ataco, tu vida: " + vidaJugador);
            }

            turnos.poll();
            turnos.offer(turnoActual);

        } victoria = true;
    }

}
