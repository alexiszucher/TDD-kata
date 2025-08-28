package molkky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RollTest {
    @Test
    void givenZeroPinIsDown_shouldScore0() {
        Assertions.assertEquals(0, new Roll(List.of()).totalScore());
    }

    @Test
    void givenOnePinIsDown_shouldScoreValueOfThePin() {
        Assertions.assertEquals(6, new Roll(List.of(6)).totalScore());
    }

    @Test
    void givenManyPinIsDown_shouldScoreTheNumberOfPinsDown() {
        Assertions.assertEquals(4, new Roll(List.of(6, 1, 3, 4)).totalScore());
        Assertions.assertEquals(12, new Roll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)).totalScore());
    }
}