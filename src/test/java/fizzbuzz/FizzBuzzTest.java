package fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    void givenMultipleOf3_shouldOutputFizz() {
        Assertions.assertEquals("Fizz", FizzBuzz.compute(3));
        Assertions.assertEquals("Fizz", FizzBuzz.compute(6));
        Assertions.assertEquals("Fizz", FizzBuzz.compute(9));
    }

    @Test
    void givenMultipleOf5_shouldOutputBuzz() {
        Assertions.assertEquals("Buzz", FizzBuzz.compute(5));
        Assertions.assertEquals("Buzz", FizzBuzz.compute(10));
    }

    @Test
    void givenMultipleOf3And5_shouldOutputFizzBuzz() {
        Assertions.assertEquals("FizzBuzz", FizzBuzz.compute(15));
        Assertions.assertEquals("FizzBuzz", FizzBuzz.compute(30));
    }

    @Test
    void givenNonMultipleOf3And5_shouldOutputTheInputNumber() {
        Assertions.assertEquals("1", FizzBuzz.compute(1));
    }
}
