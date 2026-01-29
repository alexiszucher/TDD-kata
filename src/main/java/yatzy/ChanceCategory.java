package yatzy;

import java.util.Arrays;

public class ChanceCategory extends Category {
    public int compute(Integer... numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::valueOf).sum();
    }
}
