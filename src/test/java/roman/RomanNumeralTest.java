package roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RomanNumeralTest {
    @Test
    void shouldConvertZeroToRomanNumeral() {
        Assertions.assertEquals("", RomanNumeral.convert(0));
    }

    @Test
    void shouldConvertOneTwoAndThreeToRomanNumeral() {
        Assertions.assertEquals("I", RomanNumeral.convert(1));
        Assertions.assertEquals("II", RomanNumeral.convert(2));
        Assertions.assertEquals("III", RomanNumeral.convert(3));
    }

    @Test
    void shouldConvertFourToRomanNumeral() {
        Assertions.assertEquals("IV", RomanNumeral.convert(4));
    }

    @Test
    void shouldConvertFiveToRomanNumeral() {
        Assertions.assertEquals("V", RomanNumeral.convert(5));
    }

    @Test
    void shouldConvertSixToEightToRomanNumeral() {
        Assertions.assertEquals("VI", RomanNumeral.convert(6));
        Assertions.assertEquals("VII", RomanNumeral.convert(7));
        Assertions.assertEquals("VIII", RomanNumeral.convert(8));
    }

    @Test
    void shouldConvertNineToRomanNumeral() {
        Assertions.assertEquals("IX", RomanNumeral.convert(9));
    }

    @Test
    void shouldConvertTenToRomanNumeral() {
        Assertions.assertEquals("X", RomanNumeral.convert(10));
    }

    @Test
    void shouldConvertElevenToThirteenToRomanNumeral() {
        Assertions.assertEquals("XI", RomanNumeral.convert(11));
        Assertions.assertEquals("XII", RomanNumeral.convert(12));
        Assertions.assertEquals("XIII", RomanNumeral.convert(13));
    }

    @Test
    void shouldConvertTwentyToRomanNumeral() {
        Assertions.assertEquals("XX", RomanNumeral.convert(20));
    }

    @Test
    void shouldConvertFiftyToRomanNumeral() {
        Assertions.assertEquals("L", RomanNumeral.convert(50));
    }

    @Test
    void shouldConvertSixtyToRomanNumeral() {
        Assertions.assertEquals("LX", RomanNumeral.convert(60));
    }

    @Test
    void shouldConvertRandomNumberToRomanNumeral() {
        Assertions.assertEquals("LXIII", RomanNumeral.convert(63));
        Assertions.assertEquals("LXXV", RomanNumeral.convert(75));
    }
}