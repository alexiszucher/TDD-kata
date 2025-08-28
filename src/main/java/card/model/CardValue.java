package card.model;

public enum CardValue {
    AS(13),
    KING(12),
    QUEEN(11),
    VALLEY(10),
    TEN(9),
    NINE(8),
    EIGHT(7),
    SEVEN(6),
    SIX(5),
    FIVE(4),
    FOUR(3),
    THREE(2),
    TWO(1);

    public final int value;

    private CardValue(int value) {
        this.value = value;
    }
}
