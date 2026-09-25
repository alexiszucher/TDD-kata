package insideout;

public record Item(String name, int price) {
    public Item {
        if (price == 0) {
            throw new IllegalArgumentException();
        }
    }
}
