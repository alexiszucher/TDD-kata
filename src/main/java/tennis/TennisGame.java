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

    public String score() {
        if (scorePlayer1 >= 3 && hasSameScore())
            return DEUCE;

        if (hasSameScore())
            return construireScoreEgal();
        return points.get(scorePlayer1) + SEPARATOR + points.get(scorePlayer2);
    }


    private String construireScoreEgal() {
        return points.get(scorePlayer1) + SEPARATOR + "All";
    }

    private boolean hasSameScore() {
        return scorePlayer1 == scorePlayer2;
    }

    public void wonPointPlayer1() {
        this.scorePlayer1++;
    }

    public void wonPointPlayer2() {
        this.scorePlayer2++;
    }
}
