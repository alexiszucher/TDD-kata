package shoppingbasket.discount;

import java.util.List;

public class DiscountPolicies {
    public static List<DiscountPolicy> policies() {
        return List.of(
                new NoDiscountPolicy(),
                new FivePercentDiscountPolicy(),
                new TenPercentDiscountPolicy(),
                new FifteenPercentDiscountPolicy()
        );
    }
}
