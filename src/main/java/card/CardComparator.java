package card;

import card.model.Card;

import java.util.Optional;

public class CardComparator {
    public static Optional<Card> highValueBetween(Card card1, Card card2) {
        if (bothCardsHaveSameColor(card1, card2)) {
            if (bothCardsHaveSameValue(card1, card2))
                return Optional.empty();
            return Optional.of(card1.value().value > card2.value().value ? card1 : card2);
        }

        if (card1.isRed())
            return Optional.of(card1);
        return Optional.of(card2);
    }

    private static boolean bothCardsHaveSameValue(Card card1, Card card2) {
        return card1.value().equals(card2.value());
    }

    private static boolean bothCardsHaveSameColor(Card card1, Card card2) {
        return (card1.isRed() && card2.isRed()) || (card1.isBlack() && card2.isBlack());
    }
}
