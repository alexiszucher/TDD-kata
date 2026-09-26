package tennis;

import java.util.Map;
import java.util.function.BiPredicate;

public class TennisGame {
    private static final String SEPARATOR = "-";
    private static final String DEUCE = "Deuce";
    private static final Map<Integer, String> points = Map.of(
            0, "Love",
            1, "Fifteen",
            2, "Thirty",
            3, "Forty"
    );

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String winner = "";

    public String score() {
        if (unGagnantEstPresent())
            return "Win for " + winner;

        String enAvantage = trouverJoueur(this::aAvantage);
        if (!enAvantage.isEmpty())
            return "Advantage " + enAvantage;

        if (scorePlayer1 >= 3 && aUnScoreEgal())
            return DEUCE;

        if (aUnScoreEgal())
            return construireScoreEgal();

        return points.get(scorePlayer1) + SEPARATOR + points.get(scorePlayer2);
    }

    private String construireScoreEgal() {
        return points.get(scorePlayer1) + SEPARATOR + "All";
    }

    private boolean aUnScoreEgal() {
        return scorePlayer1 == scorePlayer2;
    }

    public void unPointPourJoueur1() {
        marquerPoint(() -> this.scorePlayer1++);
    }

    public void unPointPourJoueur2() {
        marquerPoint(() -> this.scorePlayer2++);
    }

    private void marquerPoint(Runnable incrementer) {
        if (unGagnantEstPresent())
            throw new IllegalStateException();
        incrementer.run();
        String gagnant = trouverJoueur(this::aGagne);
        if (!gagnant.isEmpty())
            this.winner = gagnant;
    }

    private boolean unGagnantEstPresent() {
        return !winner.isEmpty();
    }

    private String trouverJoueur(BiPredicate<Integer, Integer> condition) {
        if (scorePlayer1 <= 3 && scorePlayer2 <= 3)
            return "";
        if (condition.test(scorePlayer1, scorePlayer2))
            return "Player1";
        if (condition.test(scorePlayer2, scorePlayer1))
            return "Player2";
        return "";
    }

    private boolean aGagne(int scoreJoueur, int scoreAdversaire) {
        return scoreJoueur - scoreAdversaire >= 2;
    }

    private boolean aAvantage(int scoreJoueur, int scoreAdversaire) {
        return scoreJoueur - scoreAdversaire == 1;
    }
}
