package yatzy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChanceCategoryTest {
    private final ChanceCategory chanceCategory = new ChanceCategory();

    @Test
    void shouldSumAllDice() {
        Assertions.assertEquals(14, chanceCategory.score(1, 1, 3, 4, 5));
    }
}