package insideout;

import java.util.List;

public record Panier(List<Item> items) {
    public Panier {
        if (items.isEmpty()) throw new IllegalArgumentException();
    }

    public int prixTotal() {
        return items.stream().mapToInt(Item::price).sum();
    }
}
