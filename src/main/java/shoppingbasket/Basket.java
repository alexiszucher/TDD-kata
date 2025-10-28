package shoppingbasket;

import java.util.List;

public class Basket {
    private final List<Item> items;

    public Basket(List<Item> items) {
        this.items = items;
    }

    public int findQuantityFor(String itemName) {
        return this.items.stream().filter(item -> item.name().equals(itemName)).findFirst().get().quantity();
    }

    public double totalPrice() {
        double totalPriceItems = this.items.stream().mapToDouble(Item::totalPrice).sum();
        return DiscountApplier.apply(totalPriceItems);
    }
}
