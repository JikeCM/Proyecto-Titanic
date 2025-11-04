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
    private final static String MSG_TOTAL = "- Total Salvados ";
    private final static String MSG_HOMBRES = "  - Varones ";
    private final static String MSG_MUJERES = "  - Mujeres ";
    private final static String MSG_NINOS = "  - Niños: ";
    private final static String MSG_TOTALES = "## Total\n";
    private final static String MSG_TOTALES_SALVADOS = "- Total Salvados ";
    private final static String MSG_TOTALES_HOMBRES = "  - Varones ";
    private final static String MSG_TOTALES_MUJERES = "  - Mujeres ";
    private final static String MSG_TOTALES_NINOS = "  - Niños ";
    private final static String RUTA = "src\\main\\resources\\informe.md";

    public void empezarGenerarInformeMarkdown(String bote, List<Integer> datosBote, boolean primerBote) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA, true));
        StringBuilder resultado = new StringBuilder();

        if (primerBote == true) {
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern(FORMATO_TIEMPO);
            String fechaFormateado = ahora.format(formato);
            resultado.append(ENCABEZADO).append(EJECUCION_TIEMPO).append(fechaFormateado).append("\n\n");
            String cabeza = resultado.toString();
            escritor.write(cabeza);
            resultado.delete(0, resultado.length());
        }
        String cuerpo;
        resultado.append(MSG_BOTE).append(bote).append("\n")
                .append("\n").append(MSG_TOTAL).append(datosBote.get(0)).append("\n")
                .append(MSG_HOMBRES).append(datosBote.get(1)).append("\n")
                .append(MSG_MUJERES).append(datosBote.get(2)).append("\n")
                .append(MSG_NINOS).append(datosBote.get(3)).append("\n\n");

        cuerpo = resultado.toString();
        escritor.write(cuerpo);
        escritor.close();
    }

    public void finalizarInformeMarkdown(List<Integer> totales) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(RUTA, true));
        StringBuilder resultado = new StringBuilder();
        String pie;
        resultado.append("\n").append(MSG_TOTALES).append("\n")
                .append(MSG_TOTALES_SALVADOS).append(totales.get(0)).append("\n")
                .append(MSG_TOTALES_HOMBRES).append(totales.get(1)).append("\n")
                .append(MSG_TOTALES_MUJERES).append(totales.get(2)).append("\n")
                .append(MSG_TOTALES_NINOS).append(totales.get(3)).append("\n");
        pie = resultado.toString();
        escritor.write(pie);
        escritor.close();
    }
}
