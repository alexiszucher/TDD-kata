package card.model;

public record Card(CardColor color, CardValue value) {
    public boolean isRed() {
        return color.isRed();
    }

    public boolean isBlack() {
        return color.isBlack();
    }
}
