package br.com.example.mytravel.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    private static final String DIA_E_MES = "dd/MM";

    public static String periodoEmTexto(int dias) {
        Calendar dataDeIda = Calendar.getInstance();
        Calendar dataDeVolta = Calendar.getInstance();
        dataDeVolta.add(Calendar.DATE, dias);
        SimpleDateFormat sdf = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = sdf.format(dataDeIda.getTime());
        String dataFormatadaVolta = sdf.format(dataDeVolta.getTime());
        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataDeVolta.get(Calendar.YEAR);
    }

}
