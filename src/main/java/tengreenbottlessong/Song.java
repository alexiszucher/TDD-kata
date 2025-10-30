package tengreenbottlessong;

import java.util.HashMap;
import java.util.Map;

public class Song {
    public static final String TEN_GREEN_BOTTLES_HANGING_ON_THE_WALL = "Ten green bottles hanging on the wall,";
    public static final String IF_ONE_GREEN_BOTTLE_SHOULD_ACCIDENTALLY_FALL = "And if one green bottle should accidentally fall,";
    public static final String LINE_BREAK = "\n";
    private static final Map<Integer, String> ENGLISH_NUMBERS = new HashMap<>() {{
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
    }};

    public static String play() {
        return TEN_GREEN_BOTTLES_HANGING_ON_THE_WALL + LINE_BREAK +
                TEN_GREEN_BOTTLES_HANGING_ON_THE_WALL + LINE_BREAK +
                IF_ONE_GREEN_BOTTLE_SHOULD_ACCIDENTALLY_FALL + LINE_BREAK +"""
                There'll be nine green bottles hanging on the wall.
                
                """+playVerseFor(9) + LINE_BREAK + LINE_BREAK +
                playVerseFor(8)+ LINE_BREAK + LINE_BREAK +
                playVerseFor(7)+ LINE_BREAK + LINE_BREAK +
                playVerseFor(6)+ LINE_BREAK + LINE_BREAK +
                playVerseFor(5)+ LINE_BREAK + LINE_BREAK +
                playVerseFor(4)+ LINE_BREAK + LINE_BREAK +
                playVerseFor(3)+ LINE_BREAK + LINE_BREAK +
                playVerseFor(2) + LINE_BREAK + LINE_BREAK +
                """
                One green bottle hanging on the wall,
                And if one green bottle should accidentally fall,
                There'll be no green bottles hanging on the wall.""";
    }

    private static String playVerseFor(int bottlesNumber) {
        String englishNumber = ENGLISH_NUMBERS.get(bottlesNumber);
        return capitalizeFirstLetter(englishNumber) +" green bottles hanging on the wall,"+LINE_BREAK +
                IF_ONE_GREEN_BOTTLE_SHOULD_ACCIDENTALLY_FALL + LINE_BREAK +
                "There'll be "+englishNumber+" green bottles hanging on the wall.";
    }

    public static String capitalizeFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
}
