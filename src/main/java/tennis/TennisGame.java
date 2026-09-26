package tennis;

public class TennisGame {
    private final ScoreFormatter formatter = new ScoreFormatter();
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private boolean termine = false;

    public String score() {
        return formatter.format(scorePlayer1, scorePlayer2);
    }

    public void unPointPourJoueur1() {
        marquerPoint(() -> scorePlayer1++);
    }

    public void unPointPourJoueur2() {
        marquerPoint(() -> scorePlayer2++);
    }

    private void marquerPoint(Runnable incrementer) {
        if (termine) throw new IllegalStateException();
        incrementer.run();
        termine = score().startsWith("Win");
    }
}