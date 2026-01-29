package shoppingbasket.discount;

public class FifteenPercentDiscountPolicy implements DiscountPolicy {
    @Override
    public boolean isApplicable(double price) {
        return price > 250;
    }

    @Override
    public double apply(double price) {
        return price * 0.85;
    }

    @Override
    public int priority() {
        return 3;
    }
}
