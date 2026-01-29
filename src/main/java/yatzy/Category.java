package yatzy;

public abstract class Category {
    protected abstract int compute(Integer ...numbers);
    public int score(Integer... numbers) {
        if (numbers.length != 5) {
            throw new IllegalArgumentException("You must provide exactly 5 dice values.");
        }
        return this.compute(numbers);
    }
}
