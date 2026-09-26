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
        if (!winner.isEmpty())
            return "Win for "+winner;

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
        mettreGagnantSiPresent();
    }

    public void unPointPourJoueur2() {
        this.scorePlayer2++;
        mettreGagnantSiPresent();
    }

    private void mettreGagnantSiPresent() {
        if (aGagne(scorePlayer1, scorePlayer2))
            this.winner = "Player1";
        else if (aGagne(scorePlayer2, scorePlayer1))
            this.winner = "Player2";
    }

    private boolean aGagne(int scoreJoueur, int scoreAdversaire) {
        return scoreJoueur >= 4 && scoreJoueur - scoreAdversaire >= 2;
    }
}
