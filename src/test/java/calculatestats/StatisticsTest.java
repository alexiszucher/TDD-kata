package calculatestats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StatisticsTest {
    @Test
    void givenListOfInteger_shouldReturnMinimumValue() {
        List<Integer> ints = new ArrayList<>(List.of(8,10,7,1,8,2,94,3));
        Statistics statistics = Statistics.calculate(ints);
        Assertions.assertEquals(1, statistics.min());
    }

    @Test
    void givenListOfInteger_shouldReturnMaximumValue() {
        List<Integer> ints = new ArrayList<>(List.of(8,10,7,1,8,2,94,3));
        Statistics statistics = Statistics.calculate(ints);
        Assertions.assertEquals(94, statistics.max());
    }

    @Test
    void givenListOfInteger_shouldReturnNumberOfElements() {
        List<Integer> ints = new ArrayList<>(List.of(8,10,7,1,8,2,94,3));
        Statistics statistics = Statistics.calculate(ints);
        Assertions.assertEquals(8, statistics.numberOfElements());
    }

    @Test
    void givenListOfInteger_shouldReturnAverageValue() {
        List<Integer> ints = new ArrayList<>(List.of(10, 20));
        Statistics statistics = Statistics.calculate(ints);
        Assertions.assertEquals(15, statistics.average());
    }
}