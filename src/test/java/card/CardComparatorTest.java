package card;

import card.model.Card;
import card.model.CardColor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static card.model.CardValue.*;

class CardComparatorTest {
    private static final Card HEART_THREE = new Card(CardColor.HEART, THREE);
    private static final Card HEART_FIVE = new Card(CardColor.HEART, FIVE);
    private static final Card CLOVER_KING = new Card(CardColor.CLOVER, KING);
    private static final Card SPADE_AS = new Card(CardColor.SPADE, AS);
    private static final Card DIAMOND_TWO = new Card(CardColor.DIAMOND, TWO);
    private static final Card DIAMOND_THREE = new Card(CardColor.DIAMOND, THREE);
    private static final Card DIAMOND_AS = new Card(CardColor.DIAMOND, AS);

    @Test
    void givenBothCardsReds_shouldCardWithHighValueWins() {
        Assertions.assertEquals(Optional.of(HEART_FIVE), CardComparator.highValueBetween(HEART_FIVE, DIAMOND_THREE));
        Assertions.assertEquals(Optional.of(DIAMOND_AS), CardComparator.highValueBetween(HEART_THREE, DIAMOND_AS));
    }

    @Test
    void givenSameCardColorAndSameValue_shouldCardsBeEqualsSoResultIsEmpty() {
        Assertions.assertEquals(Optional.empty(), CardComparator.highValueBetween(HEART_FIVE, HEART_FIVE));
    }

    @Test
    void givenDifferentCardColor_shouldRedCardBeHigherThanBlackCard() {
        Assertions.assertEquals(Optional.of(HEART_THREE), CardComparator.highValueBetween(HEART_THREE, CLOVER_KING));
        Assertions.assertEquals(Optional.of(HEART_THREE), CardComparator.highValueBetween(SPADE_AS, HEART_THREE));

        Assertions.assertEquals(Optional.of(DIAMOND_TWO), CardComparator.highValueBetween(DIAMOND_TWO, CLOVER_KING));
        Assertions.assertEquals(Optional.of(DIAMOND_TWO), CardComparator.highValueBetween(SPADE_AS, DIAMOND_TWO));
    }
}