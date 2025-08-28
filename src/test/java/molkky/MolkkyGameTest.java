package molkky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MolkkyGameTest {

    public static final Roll ROLL_10_POINTS = new Roll(List.of(10));
    public static final Roll ROLL_0_POINT = new Roll(List.of());

    @Test
    void shouldComputeTotalOfRolls() {
        List<Roll> rolls = List.of(
                new Roll(List.of(4)),
                new Roll(List.of(8)),
                new Roll(List.of()),
                new Roll(List.of(1, 7, 3))
        );
        MolkkyGame game = new MolkkyGame(rolls);
        Assertions.assertEquals(15, game.score());
        Assertions.assertFalse(game.isWinningGame());
        Assertions.assertFalse(game.isLost());
    }

    @Test
    void givenScoreOf50_shouldPlayerWins() {
        List<Roll> rolls = List.of(
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS
        );
        MolkkyGame game = new MolkkyGame(rolls);
        Assertions.assertEquals(50, game.score());
        Assertions.assertTrue(game.isWinningGame());
    }

    @Test
    void givenScoreDifferentOf50_shouldPlayerNotWins() {
        List<Roll> rolls = List.of(
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS
        );
        MolkkyGame game = new MolkkyGame(rolls);
        Assertions.assertEquals(40, game.score());
        Assertions.assertFalse(game.isWinningGame());
    }

    @Test
    void givenScoreMoreThan50_shouldPlayerReturnTo25Points() {
        List<Roll> rolls = List.of(
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS,
                ROLL_10_POINTS
        );
        MolkkyGame game = new MolkkyGame(rolls);
        Assertions.assertEquals(25, game.score());
    }

    @Test
    void given3RollsOfZeroScoreInARow_shouldPlayerLoose() {
        List<Roll> rolls = List.of(
                ROLL_0_POINT,
                ROLL_0_POINT,
                ROLL_0_POINT
        );
        MolkkyGame game = new MolkkyGame(rolls);
        Assertions.assertEquals(0, game.score());
        Assertions.assertTrue(game.isLost());
    }
}