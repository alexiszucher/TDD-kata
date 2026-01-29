package shoppingbasket.discount;

public class NoDiscountPolicy implements DiscountPolicy {
    @Override
    public boolean isApplicable(double price) {
        return true;
    }

    @Override
    public double apply(double price) {
        return price;
    }

    @Override
    public int priority() {
        return 0;
    }
}
