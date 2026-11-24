package Clases;

import com.google.gson.*;
import java.io.FileReader;
import java.io.Reader;
import java.util.LinkedList;

public class gestorHabilidades {
    public static LinkedList<Habilidad> cargarPorElemento(Ataque.TipoAtaque elemento){
        LinkedList<Habilidad> listaHabilidades = new LinkedList<>();
        if(elemento == null){
            throw new IllegalArgumentException("El elemento no puede ser Null");
        }
        try(Reader archivo = new FileReader("Habilidades.json")){

            //Leer el archivo Json
            JsonObject raiz = JsonParser.parseReader(archivo).getAsJsonObject();

            //Obtener el arreglo de habilidades
            JsonArray habilidades = raiz.getAsJsonArray("habilidades");

            //Recorrer cada habilidad
            for(JsonElement dato : habilidades){
                JsonObject objeto = dato.getAsJsonObject();

                //Obtener el elemento de la habilidad.
                Ataque.TipoAtaque tipo = Ataque.TipoAtaque.valueOf(objeto.get("elemento").getAsString());

                //Comprobamos si coincide con el elemento solicitado
                if(tipo == elemento){
                    //Crear el objeto habilidad
                    Habilidad habilidad = new Habilidad(
                            objeto.get("id").getAsInt(),
                            objeto.get("nombre").getAsString(),
                            tipo,
                            objeto.get("dano").getAsInt(),
                            objeto.get("costoEnergia").getAsInt(),
                            objeto.get("descripcion").getAsString()
                    );

                    //Agregar la habilidad a la lista
                    listaHabilidades.add(habilidad);
                }
            }
        }catch (Exception e) {
            throw new RuntimeException(
                    "Error al cargar las habilidades: " + e.getMessage(), e
            );
        }
        return listaHabilidades;
    }
}
