import Clases.*;
import org.fusesource.jansi.AnsiConsole;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AnsiConsole.systemInstall();
        try {
            new Juego().menu();
        } finally {
            AnsiConsole.systemUninstall();
        }
    }
}
