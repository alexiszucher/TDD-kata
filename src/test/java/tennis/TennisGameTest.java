package tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisGameTest {
    @Test
    void given0scoreEach_shouldBeLoveAll() {
        TennisGame tennisGame = new TennisGame();
        Assertions.assertEquals("Love-All", tennisGame.score());
    }

    @Test
    void given1scoreEach_shouldBeFifteenAll() {
        TennisGame tennisGame = new TennisGame();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur2();
        Assertions.assertEquals("Fifteen-All", tennisGame.score());
    }

    @Test
    void given1And0score_shouldBeFifteenLove() {
        TennisGame tennisGame = new TennisGame();
        tennisGame.unPointPourJoueur1();
        Assertions.assertEquals("Fifteen-Love", tennisGame.score());
    }

    @Test
    void given2And1score_shouldBeFifteenLove() {
        TennisGame tennisGame = new TennisGame();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur2();
        Assertions.assertEquals("Thirty-Fifteen", tennisGame.score());
    }

    @Test
    void given3And2score_shouldBeThirtyAll() {
        TennisGame tennisGame = new TennisGame();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur2();
        tennisGame.unPointPourJoueur2();
        Assertions.assertEquals("Forty-Thirty", tennisGame.score());
    }

    @Test
    void given3scoreEachOrMore_shouldBeDeuce() {
        TennisGame tennisGame = new TennisGame();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur2();
        tennisGame.unPointPourJoueur2();
        tennisGame.unPointPourJoueur2();
        Assertions.assertEquals("Deuce", tennisGame.score());
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur2();
        Assertions.assertEquals("Deuce", tennisGame.score());
    }
}
