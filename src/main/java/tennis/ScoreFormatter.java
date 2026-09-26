package tennis;

import java.util.Map;

public class ScoreFormatter {
    private static final Map<Integer, String> POINTS = Map.of(
            0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty"
    );

    public String format(int scorePlayer1, int scorePlayer2) {
        if (aGagne(scorePlayer1, scorePlayer2)) return "Win for Player1";
        if (aGagne(scorePlayer2, scorePlayer1)) return "Win for Player2";
        if (aAvantage(scorePlayer1, scorePlayer2)) return "Advantage Player1";
        if (aAvantage(scorePlayer2, scorePlayer1)) return "Advantage Player2";
        if (scorePlayer1 >= 3 && scorePlayer1 == scorePlayer2) return "Deuce";
        if (scorePlayer1 == scorePlayer2) return POINTS.get(scorePlayer1) + "-All";
        return POINTS.get(scorePlayer1) + "-" + POINTS.get(scorePlayer2);
    }

    private boolean aGagne(int soi, int adversaire) {
        return soi >= 4 && soi - adversaire >= 2;
    }

    private boolean aAvantage(int soi, int adversaire) {
        return soi >= 3 && adversaire >= 3 && soi - adversaire == 1;
    }
}