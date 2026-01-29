package yatzy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTest {
    private final Category category = new Category() {
        @Override
        protected int compute(Integer... numbers) {
            return 0;
        }
    };

    @Test
    void givenNumberOfDiceDifferentThan5_shouldFailed() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            category.score(3, 4, 3, 6, 1, 3);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            category.score(3);
        });
    }

    @Test
    void givenNumberOfDiceIs5_shouldSucceed() {
        category.score(3, 4, 3, 6, 1);
    }
}