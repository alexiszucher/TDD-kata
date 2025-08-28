package roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {
    public static final int FIVE = 5;
    public static final int ZERO = 0;
    public static final LinkedHashMap<Integer, String> ROMAN_NUMERALS = new LinkedHashMap<>(Map.of(
            50, "L",
            10, "X",
            5, "V",
            1, "I"
    ));

    public static String convert(int number) {
        if (isCongruentNumber(number)) {
            return "I"+convert(number+1);
        }
        if (number == ZERO) {
            return "";
        }
        return findBaseRomanNumeral(number) + convert(number - findBaseNumber(number));
    }

    private static String findBaseRomanNumeral(int number) {
        return ROMAN_NUMERALS.get(findBaseNumber(number));
    }

    private static Integer findBaseNumber(int number) {
        return ROMAN_NUMERALS.keySet().stream()
                .filter(key -> key <= number)
                .max(Integer::compareTo)
                .orElseThrow();
    }

    private static boolean isCongruentNumber(int number) {
        return number % FIVE == 4;
    }
}
