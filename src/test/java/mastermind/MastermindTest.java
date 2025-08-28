package mastermind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static mastermind.Color.*;
import static mastermind.ColorVerification.*;

class MastermindTest {
    @Test
    void givenProposedColorsNotMatchingWithMasterColors_shouldBeNothing() {
        Map<Integer, Color> masterColors = Map.of(
                1, BLUE,
                2, BLUE,
                3, BLUE,
                4, BLUE);
        Map<Integer, Color> proposedColors = Map.of(
                1, RED,
                2, RED,
                3, RED,
                4, RED);
        Mastermind mastermind = new Mastermind(masterColors);

        Assertions.assertEquals(Map.of(
                1, NOTHING,
                2, NOTHING,
                3, NOTHING,
                4, NOTHING
        ), mastermind.play(proposedColors));
    }

    @Test
    void givenProposedColorsMatchingInWrongPlacementWithMasterColors_shouldBeWhite() {
        Map<Integer, Color> masterColors = Map.of(
                1, ORANGE,
                2, BLUE,
                3, ORANGE,
                4, BLUE);
        Map<Integer, Color> proposedColors = Map.of(
                1, BLUE,
                2, RED,
                3, BLUE,
                4, RED);
        Mastermind mastermind = new Mastermind(masterColors);

        Assertions.assertEquals(Map.of(
                1, WHITE,
                2, NOTHING,
                3, WHITE,
                4, NOTHING
        ), mastermind.play(proposedColors));    }

    @Test
    void givenProposedColorsMatchingInRightPlacementWithMasterColors_shouldBeBlack() {
        Map<Integer, Color> masterColors = Map.of(
                1, ORANGE,
                2, BLUE,
                3, BLUE,
                4, BLUE);
        Map<Integer, Color> proposedColors = Map.of(
                1, ORANGE,
                2, RED,
                3, RED,
                4, BLUE);
        Mastermind mastermind = new Mastermind(masterColors);

        Assertions.assertEquals(Map.of(
                1, BLACK,
                2, NOTHING,
                3, NOTHING,
                4, BLACK
        ), mastermind.play(proposedColors));    }

    @Test
    void givenProposedColorHasAlreadyBeFoundInMasterColors_shouldBeNothing() {
        Map<Integer, Color> masterColors = Map.of(
                1, ORANGE,
                2, BLUE,
                3, BLUE,
                4, BLUE);
        Map<Integer, Color> proposedColors = Map.of(
                1, ORANGE,
                2, ORANGE,
                3, RED,
                4, RED);
        Mastermind mastermind = new Mastermind(masterColors);

        Assertions.assertEquals(Map.of(
                1, BLACK,
                2, NOTHING,
                3, NOTHING,
                4, NOTHING
        ), mastermind.play(proposedColors));    }

    @Test
    void givenProposedColorWillBeFoundAfterInMasterColors_shouldBeNothing() {
        Map<Integer, Color> masterColors = Map.of(
                1, BLUE,
                2, ORANGE,
                3, BLUE,
                4, BLUE);
        Map<Integer, Color> proposedColors = Map.of(
                1, ORANGE,
                2, ORANGE,
                3, RED,
                4, RED);
        Mastermind mastermind = new Mastermind(masterColors);

        Assertions.assertEquals(Map.of(
                1, NOTHING,
                2, BLACK,
                3, NOTHING,
                4, NOTHING
        ), mastermind.play(proposedColors));
    }
}