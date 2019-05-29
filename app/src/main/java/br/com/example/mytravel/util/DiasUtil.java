package br.com.example.mytravel.util;

public class DiasUtil {

    public static final String SINGULAR = " dia";
    public static final String PLURAL = " dias";

    public static String formataDiasEmTexto(int dias) {
        if (dias > 1) {
            return dias + PLURAL;
        }
        return dias + SINGULAR;
    }

}
