package card.model;

import java.util.List;
import java.util.Queue;

public class Player {
    private final Queue<Card> cardValues;

    public Player(Queue<Card> cardValues) {
        this.cardValues = cardValues;
    }

    public Queue<Card> cards() {
        return this.cardValues;
    }

    public Card raiseCard() {
        return this.cardValues.poll();
    }

    public void winsCards(List<Card> cards) {
        this.cardValues.addAll(cards);
    }
}
