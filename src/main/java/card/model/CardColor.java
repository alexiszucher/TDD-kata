package card.model;

public enum CardColor {
    HEART,
    DIAMOND,
    CLOVER,
    SPADE;

    public boolean isRed() {
        return HEART.equals(this) || DIAMOND.equals(this);
    }

    public boolean isBlack() {
        return !isRed();
    }
}
