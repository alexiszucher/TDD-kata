package shoppingbasket;

import shoppingbasket.discount.DiscountPolicies;
import shoppingbasket.discount.DiscountPolicy;

import java.util.Comparator;

public class DiscountApplier {
    public static double apply(double price) {
        return DiscountPolicies.policies().stream()
                .filter(discount -> discount.isApplicable(price))
                .max(Comparator.comparing(DiscountPolicy::priority)).get().apply(price);
    }
}
