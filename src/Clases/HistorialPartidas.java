package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistorialPartidas {

    private final String nombreArchivo = "HistorialPartidas.txt";

    public void registrarPartida(Jugador jugador, String resultado) throws IOException {
        String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        String partida = fecha + " | Jugador: " + jugador.getNombre()
                + " | Elemento: " + jugador.getElementoPrincipal()
                + " | Resultado: " + resultado
                + " | Vida restante: " + jugador.getVida();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            escritor.write(partida);
            escritor.newLine();
        }
    }

    public void mostrarHistorial() throws IOException {
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("Todavía no hay partidas registradas.");
            return;
        }

        System.out.println("\n---------- HISTORIAL DE PARTIDAS ----------");
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String partida;
            int numero = 1;
            while ((partida = lector.readLine()) != null) {
                System.out.println(numero + ". " + partida);
                numero++;
            }
        }
    }
}
