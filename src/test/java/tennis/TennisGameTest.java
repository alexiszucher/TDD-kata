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
        ajouterPointPourJoueur1(2, tennisGame);
        tennisGame.unPointPourJoueur2();
        Assertions.assertEquals("Thirty-Fifteen", tennisGame.score());
    }

    @Test
    void given3And2score_shouldBeThirtyAll() {
        TennisGame tennisGame = new TennisGame();
        ajouterPointPourJoueur1(3, tennisGame);
        ajouterPointPourJoueur2(2, tennisGame);
        Assertions.assertEquals("Forty-Thirty", tennisGame.score());
    }

    @Test
    void given3scoreEachOrMore_shouldBeDeuce() {
        TennisGame tennisGame = new TennisGame();
        ajouterPointPourJoueur1(3, tennisGame);
        ajouterPointPourJoueur2(3, tennisGame);
        Assertions.assertEquals("Deuce", tennisGame.score());
        tennisGame.unPointPourJoueur1();
        tennisGame.unPointPourJoueur2();
        Assertions.assertEquals("Deuce", tennisGame.score());
    }

    @Test
    void given2PointsDifferenceAndPlayerHasScoreEqualOrMoreThan4_shouldWin() {
        TennisGame tennisGame = new TennisGame();
        ajouterPointPourJoueur1(2, tennisGame);
        ajouterPointPourJoueur2(4, tennisGame);
        Assertions.assertEquals("Win for Player2", tennisGame.score());

        tennisGame = new TennisGame();
        ajouterPointPourJoueur2(5, tennisGame);
        ajouterPointPourJoueur1(7, tennisGame);
        Assertions.assertEquals("Win for Player1", tennisGame.score());
    }

    private static void ajouterPointPourJoueur1(int points, TennisGame tennisGame) {
        for (int i = 1; i <= points; i++) {
            tennisGame.unPointPourJoueur1();
        }
    }

    private static void ajouterPointPourJoueur2(int points, TennisGame tennisGame) {
        for (int i = 1; i <= points; i++) {
            tennisGame.unPointPourJoueur2();
        }
    }
}
