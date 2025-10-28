package shoppingbasket;

public class Item {
    private final String name;
    private final int quantity;
    private final double unitPrice;

    public Item(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public static Item of(String name, int quantity, double unitPrice) {
        return new Item(name, quantity, unitPrice);
    }

    public String name() {
        return name;
    }

    public int quantity() {
        return quantity;
    }

    public double totalPrice() {
        return quantity * unitPrice;
    }
}
