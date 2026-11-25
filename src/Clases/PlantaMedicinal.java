package Clases;

import java.util.ArrayDeque;
import java.util.Deque;

public class PlantaMedicinal {
    public static final int CURACION = 20;
    public static final int USOS_POR_COMBATE = 2;

    private final Deque<Integer> cura = new ArrayDeque<>();

    // recarga los usos de la cura
    public void recargar() {
        cura.clear();
        for (int i = 0; i < USOS_POR_COMBATE; i++) {
            cura.push(CURACION);
        }
    }

    public boolean tieneUsos() {
        return !cura.isEmpty();
    }

    public int usosRestantes() {
        return cura.size();
    }

    // Cura al personaje y devuelve cuánta vida se curó.
    public int usar(Personaje personaje, int vidaMaxima) {
        if (cura.isEmpty()) {
            throw new IllegalStateException("no te queda más medicina");
        }
        if (personaje.getVida() >= vidaMaxima) {
              throw new IllegalStateException("tu vida ya está al máximo");
          }
        int curacion = cura.pop();
        int vidaAntes = personaje.getVida();
        int vidaNueva = Math.min(vidaMaxima, vidaAntes + curacion);
        personaje.setVida(vidaNueva);
        return vidaNueva - vidaAntes;
    }
}
