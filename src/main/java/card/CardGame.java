package card;

import card.model.Card;
import card.model.CardColor;
import card.model.CardValue;
import card.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class CardGame {
    private final Player player1;
    private final Player player2;
    private final List<Card> asideCards = new ArrayList<>();

    public CardGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Queue<Card> player1Cards() {
        return this.player1.cards();
    }

    public Queue<Card> player2Cards() {
        return this.player2.cards();
    }

    public void battle() {
        Card player1CardValue = player1.raiseCard();
        Card player2CardValue = player2.raiseCard();

        Optional<Card> highValueCard = CardComparator.highValueBetween(player1CardValue, player2CardValue);

        if (highValueCard.isEmpty()) {
            this.asideCards.addAll(List.of(player1CardValue, player2CardValue));
        } else if (player1CardValue.equals(highValueCard.get())) {
            player1.winsCards(asideCards);
            player1.winsCards(List.of(player2CardValue, player1CardValue));
            asideCards.clear();
        } else {
            player2.winsCards(asideCards);
            player2.winsCards(List.of(player1CardValue, player2CardValue));
            asideCards.clear();
        }
    }

    public String winner() {
        return player1Cards().isEmpty() ? "player2" : "player1";
    }

    public boolean isFinished() {
        return player1Cards().isEmpty() || player2Cards().isEmpty();
    }
}
