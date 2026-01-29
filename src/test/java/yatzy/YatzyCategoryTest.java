package yatzy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YatzyCategoryTest {
    private final YatzyCategory yatzyCategory = new YatzyCategory();

    @Test
    void givenSameNumberOnAllDice_shouldScore50() {
        assertEquals(50, yatzyCategory.score(6, 6, 6, 6, 6));
        assertEquals(50, yatzyCategory.score(1, 1, 1, 1, 1));
        assertEquals(50, yatzyCategory.score(3, 3, 3, 3, 3));
    }

    @Test
    void givenDifferentNumberOnDice_shouldScore0() {
        assertEquals(0, yatzyCategory.score(6, 6, 6, 6, 1));
        assertEquals(0, yatzyCategory.score(1, 1, 4, 1, 1));
        assertEquals(0, yatzyCategory.score(3, 3, 2, 3, 3));
    }
}