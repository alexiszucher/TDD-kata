package shoppingbasket.discount;

public class TenPercentDiscountPolicy implements DiscountPolicy {
    @Override
    public boolean isApplicable(double price) {
        return price > 200;
    }

    @Override
    public double apply(double price) {
        return price * 0.90;
    }

    @Override
    public int priority() {
        return 2;
    }
}
