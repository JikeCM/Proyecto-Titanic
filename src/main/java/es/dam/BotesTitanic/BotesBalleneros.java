package es.dam.BotesTitanic;

import java.util.Random;

public class BotesBalleneros {

    private final static int MIN_TIEMPO = 2000;
    private final static int MAX_TIEMPO = 6000;
    private final static int MAX_HOMBRES = 100;
    private final static int MAX_MUJERES = 100;
    private final static int MAX_NINOS = 100;

    public static void main(String[] args) {
        try {
            Random aleatorio = new Random();
            int hombres = aleatorio.nextInt(MAX_HOMBRES + 1);
            int mujeres = aleatorio.nextInt(MAX_MUJERES + 1);
            int ninos = aleatorio.nextInt(MAX_NINOS + 1);
            int total = hombres + mujeres + ninos;
            System.out.println(total);
            System.out.println(hombres);
            System.out.println(mujeres);
            System.out.println(ninos);
            Thread.sleep(aleatorio.nextInt(MAX_TIEMPO - MIN_TIEMPO + 1) + MIN_TIEMPO);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
