package br.com.example.mytravel.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String LANGUAGE = "pt";
    public static final String COUNTRY = "br";
    public static final String REPLACEMENT = "R$ ";
    public static final String TARGET = "R$";

    public static String formataParaMoedaBrasileira(BigDecimal valor) {
        NumberFormat tipoMoeda = DecimalFormat.getCurrencyInstance(new Locale(LANGUAGE, COUNTRY));
        return tipoMoeda.format(valor).replace(TARGET, REPLACEMENT);
    }
}
