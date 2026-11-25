package Clases;

import org.fusesource.jansi.Ansi;

public class Consola {
    public static void limpiar() {
        System.out.print(Ansi.ansi().eraseScreen().cursor(1, 1));
        System.out.flush();
    }
}