package primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static List<Integer> generate(int number) {
        List<Integer> primeFactors = new ArrayList<>();
        int remaining = number, divisor = 2;
        while (divisor <= remaining) {
            if (remaining % divisor == 0) {
                primeFactors.add(divisor);
                remaining /= divisor;
            } else {
                divisor++;
            }
        }
        return primeFactors;
    }
}
