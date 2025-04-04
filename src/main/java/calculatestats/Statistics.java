package calculatestats;

import java.util.List;

public class Statistics {
    private final List<Integer> integers;

    public Statistics(List<Integer> integers) {
        this.integers = integers;
    }

    public static Statistics calculate(List<Integer> ints) {
        return new Statistics(ints);
    }


    public int min() {
        return this.integers.stream().min(Integer::compareTo).orElseThrow();
    }

    public int max() {
        return this.integers.stream().max(Integer::compareTo).orElseThrow();
    }

    public int numberOfElements() {
        return this.integers.size();
    }

    public double average() {
        return this.integers.stream().mapToInt(value -> value).average().orElseThrow();
    }
}
