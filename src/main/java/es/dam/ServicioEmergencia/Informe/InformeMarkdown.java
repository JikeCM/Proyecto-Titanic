package es.dam.ServicioEmergencia.Informe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InformeMarkdown {

    private final static String ENCABEZADO = "# SERVICIO DE EMERGENCIAS\n\n";
    private final static String FORMATO_TIEMPO = "dd/MM/yyyy 'a las' HH:mm:ss";
    private final static String EJECUCION_TIEMPO = "Ejecución realizada el día ";
    private final static String MSG_BOTE = "## Bote ";
    public final static int CANTIDAD_BOTES = 20;
    private final static String MSG_TOTAL = "- Total Salvados ";  
    private final static String MSG_HOMBRES = "  - Varones ";  
    private final static String MSG_MUJERES = "  - Mujeres ";
    private final static String MSG_NINOS = "  - Niños: ";
    private final static String MSG_TOTALES = "## Total\n";
    private final static String MSG_TOTALES_SALVADOS = "- Total Salvados ";
    private final static String MSG_TOTALES_HOMBRES = "  - Varones ";
    private final static String MSG_TOTALES_MUJERES = "  - Mujeres ";
    private final static String MSG_TOTALES_NINOS = "  - Niños ";

    public void generarInformeMarkdown(String bote, List<Integer> datosBote, List<Integer> totales) throws IOException {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(FORMATO_TIEMPO);
        String fechaFormateado = ahora.format(formato);
        BufferedWriter escritor = new BufferedWriter(new FileWriter("src\\main\\resources\\informe.md"));
        StringBuilder resultado = new StringBuilder();
        resultado.append(ENCABEZADO).append(EJECUCION_TIEMPO).append(fechaFormateado).append("\n\n");
        String cabeza = resultado.toString();
        String cuerpo;
        String pie;
        for (int i = 0; i < CANTIDAD_BOTES; i++) {
        resultado.append(MSG_BOTE).append(bote).append("\n")
        .append("\n").append(MSG_TOTAL).append(datosBote.get(0)).append("\n")
        .append(MSG_HOMBRES).append(datosBote.get(1)).append("\n")
        .append(MSG_MUJERES).append(datosBote.get(2)).append("\n")
        .append(MSG_NINOS).append(datosBote.get(3)).append("\n");
        }
        cuerpo = resultado.toString();
        resultado.append("\n").append(MSG_TOTALES).append("\n")
        .append(MSG_TOTALES_SALVADOS).append(totales.get(0)).append("\n")
        .append(MSG_TOTALES_HOMBRES).append(totales.get(1)).append("\n")
        .append(MSG_TOTALES_MUJERES).append(totales.get(2)).append("\n")
        .append(MSG_TOTALES_NINOS).append(totales.get(3)).append("\n");
        resultado.toString();
    }
}
