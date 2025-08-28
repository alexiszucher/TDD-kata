package bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BowlingGameTest {
    @Test
    void shouldComputeTotalScore() {
        String[] rolls = {"1", "2"};
        Assertions.assertEquals(3, BowlingGame.score(rolls));

        String[] rolls2 = {"1", "2", "5", "8"};
        Assertions.assertEquals(16, BowlingGame.score(rolls2));
    }

    @Test
    void givenSpare_shouldBe10AdditionalToNextRoll() {
        String[] rolls = {"1", "2", "/", "4"};
        Assertions.assertEquals(21, BowlingGame.score(rolls));
    }

    @Test
    void givenStrike_shouldBe10AdditionalToNextTwoRolls() {
        String[] rolls = {"1", "2", "X", "4", "7"};
        Assertions.assertEquals(35, BowlingGame.score(rolls));
    }

    @Test
    void givenStrikeButIsLastRoll_shouldBe10() {
        String[] rolls = {"1", "2", "X"};
        Assertions.assertEquals(13, BowlingGame.score(rolls));
    }

    @Test
    void givenStrikeButLastRollIsNext_shouldBe10AdditionalToNextRoll() {
        String[] rolls = {"1", "2", "X", "3"};
        Assertions.assertEquals(19, BowlingGame.score(rolls));
    }

    @Test
    void givenStrikeAndNextRollIsStrike_shouldBe10AdditionalTo10() {
        String[] rolls = {"X", "X"};
        Assertions.assertEquals(30, BowlingGame.score(rolls));
    }

    @Test
    void givenAllStrikesInGame_shouldBe300() {
        String[] rolls = {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"};
        Assertions.assertEquals(330, BowlingGame.score(rolls));
    }
}