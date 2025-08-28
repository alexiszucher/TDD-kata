package molkky;

import java.util.List;

public class MolkkyGame {
    public static final int WINNING_POINTS = 50;
    private final int score;
    private boolean lost = false;

    public MolkkyGame(List<Roll> rolls) {
        computeIsLost(rolls);
        int sumScore = totalScore(rolls);
        if (sumScore > WINNING_POINTS) {
            this.score = 25;
        } else {
            this.score = sumScore;
        }
    }

    private void computeIsLost(List<Roll> rolls) {
        int zeroScoreRollInARow = 0;
        for (int index = 0; index < rolls.size(); index++) {
            if (rolls.get(index).totalScore() == 0) {
                zeroScoreRollInARow++;
            } else {
                zeroScoreRollInARow = 0;
            }
            if (zeroScoreRollInARow == 3) {
                this.lost = true;
                break;
            }
        }
    }

    private int totalScore(List<Roll> rolls) {
        return rolls.stream().mapToInt(Roll::totalScore).sum();
    }

    public boolean isWinningGame() {
        return score == WINNING_POINTS;
    }

    public int score() {
        return this.score;
    }

    public boolean isLost() {
        return lost;
    }
}
