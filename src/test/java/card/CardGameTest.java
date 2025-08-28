package card;

import card.model.Card;
import card.model.CardColor;
import card.model.CardValue;
import card.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class CardGameTest {
    public static final Card DIAMOND_TWO = new Card(CardColor.DIAMOND, CardValue.TWO);
    public static final Card HEART_AS = new Card(CardColor.HEART, CardValue.AS);
    public static final Card CLOVER_KING = new Card(CardColor.CLOVER, CardValue.KING);
    public static final Card SPADE_TWO = new Card(CardColor.SPADE, CardValue.TWO);
    public static final Card SPADE_NINE = new Card(CardColor.SPADE, CardValue.NINE);

    @Test
    void shouldHaveTwoPlayersWithCards() {
        Player player1 = new Player(new ArrayDeque<>(Arrays.asList(DIAMOND_TWO, HEART_AS)));
        Player player2 = new Player(new ArrayDeque<>(Arrays.asList(CLOVER_KING, SPADE_TWO, SPADE_NINE)));

        CardGame cardGame = new CardGame(player1, player2);

        Assertions.assertEquals(2, cardGame.player1Cards().size());
        Assertions.assertEquals(3, cardGame.player2Cards().size());
    }

    @Test
    void shouldPlayerWhoWinsBattleWinsTheTwoCards() {
        Player player1 = new Player(new ArrayDeque<>(Arrays.asList(DIAMOND_TWO, HEART_AS)));
        Player player2 = new Player(new ArrayDeque<>(Arrays.asList(CLOVER_KING, SPADE_TWO, SPADE_NINE)));

        CardGame cardGame = new CardGame(player1, player2);
        cardGame.battle();

        Assertions.assertEquals(3, cardGame.player1Cards().size());
        Assertions.assertEquals(2, cardGame.player2Cards().size());
    }

    @Test
    void playerWhoWinsTheTwoCardsShouldBePlacedBehindThePackage() {
        Player player1 = new Player(new ArrayDeque<>(Arrays.asList(DIAMOND_TWO, HEART_AS)));
        Player player2 = new Player(new ArrayDeque<>(Arrays.asList(CLOVER_KING, SPADE_TWO, SPADE_NINE)));

        CardGame cardGame = new CardGame(player1, player2);
        cardGame.battle();

        Assertions.assertEquals(3, cardGame.player1Cards().size());
        Assertions.assertEquals(HEART_AS, cardGame.player1Cards().poll());
        Assertions.assertEquals(CLOVER_KING, cardGame.player1Cards().poll());
        Assertions.assertEquals(DIAMOND_TWO, cardGame.player1Cards().poll());
    }

    @Test
    void givenEquality_shouldCardsMustBeAsideAndHaveToBattleAgainToWinAllCards() {
        Player player1 = new Player(new ArrayDeque<>(Arrays.asList(DIAMOND_TWO, SPADE_TWO, SPADE_NINE)));
        Player player2 = new Player(new ArrayDeque<>(Arrays.asList(DIAMOND_TWO, SPADE_TWO, SPADE_TWO)));

        CardGame cardGame = new CardGame(player1, player2);

        cardGame.battle();
        Assertions.assertEquals(2, cardGame.player1Cards().size());
        Assertions.assertEquals(2, cardGame.player2Cards().size());

        cardGame.battle();
        Assertions.assertEquals(1, cardGame.player1Cards().size());
        Assertions.assertEquals(1, cardGame.player2Cards().size());

        cardGame.battle();
        Assertions.assertEquals(6, cardGame.player1Cards().size());
        Assertions.assertEquals(0, cardGame.player2Cards().size());
    }

    @Test
    void givenPlayer2HasEmptyCards_shouldPlayer1Wins() {
        Player player1 = new Player(new ArrayDeque<>(List.of(CLOVER_KING)));
        Player player2 = new Player(new ArrayDeque<>(List.of(SPADE_NINE)));

        CardGame cardGame = new CardGame(player1, player2);

        cardGame.battle();
        Assertions.assertEquals(2, cardGame.player1Cards().size());
        Assertions.assertEquals(0, cardGame.player2Cards().size());
        Assertions.assertTrue(cardGame.isFinished());
        Assertions.assertEquals("player1", cardGame.winner());
    }
}
