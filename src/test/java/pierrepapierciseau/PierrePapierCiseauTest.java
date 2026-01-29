package pierrepapierciseau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pierrepapierciseau.Sign.*;

public class PierrePapierCiseauTest {
    @Test
    void givenTwoSameSigns_shouldBeEquality() {
        assertTrue(Game.winnerBetween(PAPER, PAPER).isEmpty());
        assertTrue(Game.winnerBetween(ROCK, ROCK).isEmpty());
        assertTrue(Game.winnerBetween(SCISSORS, SCISSORS).isEmpty());
    }

    @Test
    void givenScissorsAndPaper_shouldScissorsWin() {
        assertEquals(Game.winnerBetween(SCISSORS, PAPER).get(), SCISSORS);
        assertEquals(Game.winnerBetween(PAPER, SCISSORS).get(), SCISSORS);
    }

    @Test
    void givenRockAndPaper_shouldRockWin() {
        assertEquals(Game.winnerBetween(ROCK, PAPER).get(), PAPER);
        assertEquals(Game.winnerBetween(PAPER, ROCK).get(), PAPER);
    }

    @Test
    void givenScissorsAndRock_shouldRockWin() {
        assertEquals(Game.winnerBetween(ROCK, SCISSORS).get(), ROCK);
        assertEquals(Game.winnerBetween(SCISSORS, ROCK).get(), ROCK);
    }
}