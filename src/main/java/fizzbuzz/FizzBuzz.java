package fizzbuzz;

import java.util.function.Predicate;

public class FizzBuzz {
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final Predicate<Integer> FIZZ_MULTIPLE = (number) -> number % 3 == 0;
    public static final Predicate<Integer> BUZZ_MULTIPLE = (number) -> number % 5 == 0;

    public static String compute(int number) {
        StringBuilder result = new StringBuilder();
        if (FIZZ_MULTIPLE.test(number)) {
            result.append(FIZZ);
        }
        if (BUZZ_MULTIPLE.test(number)) {
            result.append(BUZZ);
        }
        return result.isEmpty() ? String.valueOf(number) : result.toString();
    }
}
