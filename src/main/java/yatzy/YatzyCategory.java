package yatzy;

import java.util.Arrays;

public class YatzyCategory extends Category {
    public int compute(Integer... numbers) {
        return Arrays.stream(numbers).distinct().count() == 1 ? 50 : 0;
    }
}
