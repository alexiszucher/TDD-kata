package bowling;

public class BowlingGame {
    public static int score(String[] rolls) {
        int totalScore = 0;
        for (int index = 0; index < rolls.length; index++) {
            if (isSpare(rolls[index])) {
                totalScore += computeSpareScore(rolls, index);
            } else if (isStrike(rolls[index])) {
                totalScore += computeStrikeScore(rolls, index);
            } else {
                totalScore += Integer.parseInt(rolls[index]);
            }
        }
        return totalScore;
    }

    private static int computeSpareScore(String[] rolls, int index) {
        if (isLastRoll(rolls, index)) {
            return 10;
        } else {
            return  10 + Integer.parseInt(nextRoll(rolls, index));
        }
    }

    private static int computeStrikeScore(String[] rolls, int index) {
        if (isLastRoll(rolls, index)) {
            return 10;
        } else if (nextRollIsLast(rolls, index)) {
            return  10 + Integer.parseInt(nextRoll(rolls, index));
        }
        return  10 + Integer.parseInt(nextRoll(rolls, index)) + Integer.parseInt(nextTwoRoll(rolls, index));
    }

    private static boolean nextRollIsLast(String[] rolls, int index) {
        return index + 2 >= rolls.length;
    }

    private static boolean isLastRoll(String[] rolls, int index) {
        return index + 1 >= rolls.length;
    }

    private static String nextRoll(String[] rolls, int index) {
        if (isStrike(rolls[index+1])) {
            return "10";
        }
        return rolls[index + 1];
    }

    private static String nextTwoRoll(String[] rolls, int index) {
        if (isStrike(rolls[index+2])) {
            return "10";
        }
        return rolls[index + 2];
    }

    private static boolean isSpare(String roll) {
        return roll.equals("/");
    }

    private static boolean isStrike(String roll) {
        return roll.equals("X");
    }
}
