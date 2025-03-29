package bingo;

import java.util.Optional;

public class BingoBoard {
    private final Cells cells;

    public BingoBoard(int width, int height) {
        this.cells = new Cells(width, height);
    }

    public void defineCell(int x, int y, String value) {
        if (cells.get(x, y) != null) {
            throw new IllegalStateException("cell already defined");
        }
        Optional<Cell> cell = cells.searchValue(value);
        if (cell.isPresent()) {
            throw new IllegalStateException(value + " already present at " + cell.get().positionWidth() + "," + cell.get().positionHeight());
        }
        cells.createCell(x, y, value);
    }

    public void markCell(int x, int y) {
        if (!isInitialized()) {
            throw new IllegalStateException("board not initialized");
        }
        cells.mark(x,y);
    }

    public boolean isMarked(int x, int y) {
        return cells.isMarked(x, y);
    }

    public boolean isInitialized() {
        if (cells.allCellsInitialized()) {
            return true;
        }
        return false;
    }
}