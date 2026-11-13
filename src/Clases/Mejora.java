package Clases;

public class Mejora {
    enum Efecto {
         VIDA, DAÑO;

        void aplicar(Personaje p) {
            switch (this) {
                case VIDA -> p.setVida(p.getVida() + 1);
                case DAÑO -> p.setAtaque(p.getAtaque() + 1);
            }
        }
    }

    final String nombre;
    final int costo;
    final Efecto efecto;

    Mejora(String nombre, int costo, Efecto efecto) {
        this.nombre = nombre;
        this.costo = costo;
        this.efecto = efecto;
    }

    void aplicar(Personaje p) {
        efecto.aplicar(p);
    }
}
