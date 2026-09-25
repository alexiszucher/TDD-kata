package primefactors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrimeFactorsTest {
    @Test
    void given1_shouldNotHavePrimeFactors() {
        Assertions.assertEquals(List.of(), PrimeFactors.generate(1));
    }

    @Test
    void given2_shouldHaveTheSamePrimeFactor() {
        Assertions.assertEquals(List.of(2), PrimeFactors.generate(2));
    }

    @Test
    void given3_shouldHaveTheSamePrimeFactor() {
        Assertions.assertEquals(List.of(3), PrimeFactors.generate(3));
    }

    @Test
    void givenRestOfDivisionPer2IsMultpipleOf2_shouldHaveManyPrimeFactors2() {
        Assertions.assertEquals(List.of(2, 2), PrimeFactors.generate(4));
        Assertions.assertEquals(List.of(2, 2, 2), PrimeFactors.generate(8));
        Assertions.assertEquals(List.of(2, 2, 2, 2), PrimeFactors.generate(16));
        Assertions.assertEquals(List.of(2, 2, 2, 2, 2), PrimeFactors.generate(32));
        Assertions.assertEquals(List.of(2, 2, 2, 2, 2, 2), PrimeFactors.generate(64));
    }
}