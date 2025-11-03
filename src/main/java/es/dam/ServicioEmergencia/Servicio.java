package es.dam.ServicioEmergencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
    private final static String[] COMANDOS = {"java", "-cp", "target/classes", "es.dam.BotesTitanic.BotesBalleneros"};
    private final static String BOTE_LETRA = "B";
    public static void main(String[] args) {
        try {   
            for (int i = 0; i < 20; i++) {
            Process proceso = Runtime.getRuntime().exec(COMANDOS);
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            StringBuilder salida = new StringBuilder();
            List<Integer> personas = new ArrayList<>();
            List<Integer> totalPersonas = new ArrayList<>();
            int totalHombres = 0;
            int totalMujeres = 0;
            int totalNinos = 0;
            int totalDelTotal = 0;
            int totalBotes;
            int hombresBotes;
            int mujeresBotes;
            int ninosBotes;
            String linea;
            String idBote = BOTE_LETRA + i;
            while ((linea = lector.readLine()) != null) {
                personas.add(Integer.parseInt(linea));
            }
            totalDelTotal += personas.get(0);
            totalHombres += personas.get(1);
            totalMujeres += personas.get(2);
            totalNinos += personas.get(3);
            totalBotes = personas.get(0);
            hombresBotes = personas.get(1);
            mujeresBotes = personas.get(2);
            ninosBotes = personas.get(3);
            proceso.waitFor();
            personas.clear();
            
        }
        
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
