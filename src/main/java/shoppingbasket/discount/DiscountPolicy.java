package shoppingbasket.discount;

public interface DiscountPolicy {
    boolean isApplicable(double price);
    double apply(double price);
    int priority();
}
