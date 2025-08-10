package worldwrap;

import java.util.Arrays;
import java.util.List;

public class WorldWrap {
    private static final String SPACE_BETWEEN_WORD = " ";
    private static final String LINE_BREAK = "\n";
    public static final int FIRST_WORD = 0;

    public static String wrap(String phrase, int columnNumber) {
        if (phrase.length() < columnNumber) {
            return phrase;
        }
        List<String> words = Arrays.asList(phrase.split(" "));
        int activeLineCharacterNumber = words.get(FIRST_WORD).length();
        StringBuilder result = new StringBuilder(words.get(FIRST_WORD));
        for (int index = 1; index < words.size(); index++) {
            String word = words.get(index);
            int potentialActiveLineCharacterNumber = activeLineCharacterNumber + SPACE_BETWEEN_WORD.length() + word.length();
            if (potentialActiveLineCharacterNumber <= columnNumber) {
                result.append(SPACE_BETWEEN_WORD).append(word);
                activeLineCharacterNumber = SPACE_BETWEEN_WORD.length() + word.length();
            } else {
                result.append(LINE_BREAK).append(word);
                activeLineCharacterNumber = word.length();
            }
        }
        return result.toString();
    }
}
