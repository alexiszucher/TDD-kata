package outsidein;

import java.util.List;

public record Panier(List<Item> items) {
    public Panier {
        if (items.isEmpty()) throw new IllegalArgumentException();
    }

    public Integer totalPrice(boolean isFidele) {
        int total = items.stream().mapToInt(Item::price).sum();
        double reductionMultiplier = 1;
        if (total > 100) reductionMultiplier -= 0.10;
        if (isFidele) reductionMultiplier -= 0.05;
        return (int) (total * reductionMultiplier);
    }
}
