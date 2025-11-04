package es.dam.ServicioEmergencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import es.dam.ServicioEmergencia.Informe.InformeMarkdown;

public class Servicio {

    private final static String[] COMANDOS = {"java", "-cp", "target/classes", "es.dam.BotesTitanic.BotesBalleneros"};
    private final static String PREFIJO_BOTE = "B";
    private  final static int CANTIDAD_BOTES = 20;


    public static void main(String[] args) {
        try {
            InformeMarkdown informe = new InformeMarkdown();
            List<Integer> totalPersonas = new ArrayList<>();
            int totalHombres = 0;
            int totalMujeres = 0;
            int totalNinos = 0;
            int totalGeneral = 0;
            boolean primerBote = true;
            for (int i = 0; i < CANTIDAD_BOTES; i++) {
                Process proceso = Runtime.getRuntime().exec(COMANDOS);
                BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                StringBuilder salida = new StringBuilder();
                List<Integer> personas = new ArrayList<>();
                String linea;
                String idBote = PREFIJO_BOTE + i;
                while ((linea = lector.readLine()) != null) {
                    personas.add(Integer.parseInt(linea));
                }
                totalGeneral += personas.get(0);
                totalHombres += personas.get(1);
                totalMujeres += personas.get(2);
                totalNinos += personas.get(3);
                informe.empezarGenerarInformeMarkdown(idBote, personas, primerBote);
                proceso.waitFor();
                primerBote = false;
            }
            totalPersonas.add(totalGeneral);
            totalPersonas.add(totalHombres);
            totalPersonas.add(totalMujeres);
            totalPersonas.add(totalNinos);
            informe.finalizarInformeMarkdown(totalPersonas);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
