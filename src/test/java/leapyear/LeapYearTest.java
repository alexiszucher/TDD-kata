package leapyear;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearTest {
    @Test
    void givenYearDivisibleBy4_shouldBeATypicalLeapYear() {
        Assertions.assertTrue(LeapYear.isLeapYear(4));
        Assertions.assertTrue(LeapYear.isLeapYear(8));
        Assertions.assertTrue(LeapYear.isLeapYear(1996));
    }

    @Test
    void givenYearDivisibleBy100And400_shouldBeAnAtypicalLeapYear() {
        Assertions.assertTrue(LeapYear.isLeapYear(2000));
    }

    @Test
    void givenYearDivisibleBy100ButNotDivisibleBy400_shouldBeAnAtypicalCommonYear() {
        Assertions.assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    void givenYearNotDivisibleBy4_shouldBeACommonYear() {
        Assertions.assertFalse(LeapYear.isLeapYear(2001));
    }
}
