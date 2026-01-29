package shoppingbasket.discount;

public class FivePercentDiscountPolicy implements DiscountPolicy {
    @Override
    public boolean isApplicable(double price) {
        return price > 100;
    }

    @Override
    public double apply(double price) {
        return price * 0.95;
    }

    @Override
    public int priority() {
        return 1;
    }
}
