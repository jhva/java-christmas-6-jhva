package christmas.utils;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"55,000", "5,500", "125,000", "990"})
    void 가격에_맞춰_쉼표_포맷(String expectedPrice) {
        int expectedValue = Integer.parseInt(expectedPrice.replace(",", ""));
        Assertions.assertEquals(expectedPrice, formatPrice(expectedValue));
    }

    public String formatPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedPrice = decimalFormat.format(price);
        if (price < 10000) {
            formattedPrice = decimalFormat.format(price);
        }
        return formattedPrice;
    }
}
