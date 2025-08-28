package diamond;

import java.util.List;

public class Diamond {
    private static final List<String> LETTERS = List.of(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    );
    public static final String LINE_BREAK = "\n";
    public static final String SPACE = " ";

    public String print(String letter) {
        if (letter.equals("A"))
            return "A";
        int indexLetter = LETTERS.indexOf(letter);
        StringBuilder diamond = new StringBuilder();
        computeUpDiamond(indexLetter, diamond);
        computeDownDiamond(indexLetter, diamond);
        return diamond.toString();
    }

    private static void computeUpDiamond(int indexLetter, StringBuilder diamond) {
        diamond.append(SPACE.repeat(indexLetter));
        diamond.append("A");
        diamond.append(LINE_BREAK);

        int indexLetterInProcess = 1;
        while (indexLetterInProcess <= indexLetter) {
            diamond.append(SPACE.repeat(indexLetter - indexLetterInProcess));
            diamond.append(LETTERS.get(indexLetterInProcess));
            diamond.append(SPACE.repeat(computeSpaceBetweenLetters(indexLetterInProcess)));
            diamond.append(LETTERS.get(indexLetterInProcess));
            diamond.append(LINE_BREAK);
            indexLetterInProcess++;
        }
    }

    private static void computeDownDiamond(int indexLetter, StringBuilder diamond) {
        int indexLetterInProcess = indexLetter - 1;
        while (indexLetterInProcess > 0) {
            diamond.append(SPACE.repeat(indexLetter - indexLetterInProcess));
            diamond.append(LETTERS.get(indexLetterInProcess));
            diamond.append(SPACE.repeat(computeSpaceBetweenLetters(indexLetterInProcess)));
            diamond.append(LETTERS.get(indexLetterInProcess));
            diamond.append(LINE_BREAK);
            indexLetterInProcess--;
        }
        diamond.append(SPACE.repeat(indexLetter));
        diamond.append("A");
    }

    private static int computeSpaceBetweenLetters(int indexLetterInProcess) {
        return (indexLetterInProcess - 1) * 2 + 1;
    }
}
