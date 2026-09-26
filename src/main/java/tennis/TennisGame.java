package tennis;

import java.util.Map;

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
            return "Win for "+winner;

        if (!calculerAvantage().isEmpty())
            return "Advantage "+calculerAvantage();

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
        this.scorePlayer1++;
        calculerGagnantEtAvantage();
    }

    public void unPointPourJoueur2() {
        if (unGagnantEstPresent())
            throw new IllegalStateException();


        this.scorePlayer2++;
        calculerGagnantEtAvantage();
    }

    private boolean unGagnantEstPresent() {
        return !winner.isEmpty();
    }

    private String calculerAvantage() {
        if (scorePlayer1 > 3 || scorePlayer2 > 3) {
            if (aAvantage(scorePlayer1, scorePlayer2))
                return  "Player1";
            else if (aAvantage(scorePlayer2, scorePlayer1))
                return "Player2";
        }
        return "";
    }

    private void calculerGagnantEtAvantage() {
        if (scorePlayer1 > 3 || scorePlayer2 > 3) {
            if (aGagne(scorePlayer1, scorePlayer2))
                this.winner = "Player1";
            else if (aGagne(scorePlayer2, scorePlayer1))
                this.winner = "Player2";
        }
    }

    private boolean aGagne(int scoreJoueur, int scoreAdversaire) {
        return scoreJoueur - scoreAdversaire >= 2;
    }

    private boolean aAvantage(int scoreJoueur, int scoreAdversaire) {
        return scoreJoueur - scoreAdversaire == 1;
    }
}
