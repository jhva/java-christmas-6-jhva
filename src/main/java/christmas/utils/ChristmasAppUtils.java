package christmas.utils;

import java.text.DecimalFormat;

public class ChristmasAppUtils {

    private static final String DECIMAL_PATTER = "#,###";
    private static final int DECIMAL_PATTER_STANDARD = 10000;


    public static String formatPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_PATTER);
        String formattedPrice = decimalFormat.format(price);
        if (price < DECIMAL_PATTER_STANDARD) {
            formattedPrice = decimalFormat.format(price);
        }
        return formattedPrice;
    }

    public static String[] splitByRegex(String inputBySplit, String usingPattern) {
        String[] pattern = inputBySplit.split(usingPattern);
        return pattern;
    }
}
