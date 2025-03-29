package bingo;

public class Cell {
    private final int positionWidth;
    private final int positionHeight;
    private boolean isMarked = false;
    private final String value;

    public Cell(int positionWidth, int positionHeight, String value) {
        this.positionWidth = positionWidth;
        this.positionHeight = positionHeight;
        this.value = value;
    }

    public void marked() {
        this.isMarked = true;
    }

    public String value() {
        return value;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public int positionWidth() {
        return positionWidth;
    }

    public int positionHeight() {
        return positionHeight;
    }
}
