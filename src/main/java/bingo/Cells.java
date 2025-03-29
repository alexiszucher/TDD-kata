package bingo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Cells {
    private final int maxWidth;
    private final int maxHeight;
    private final Set<Cell> cells = new HashSet<>();

    public Cells(int maxWidth, int maxHeight) {
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
    }

    public Cell get(int x, int y) {
        return cells.stream().filter(cell -> cell.positionWidth() == x && cell.positionHeight() == y).findFirst().orElse(null);
    }

    public void createCell(int x, int y, String value) {
        cells.add(new Cell(x, y, value));
    }

    public void mark(int x, int y) {
        get(x, y).marked();
    }

    public boolean isMarked(int x, int y) {
        return cells.stream().filter(cell -> cell.positionWidth() == x && cell.positionHeight() == y)
                .anyMatch(Cell::isMarked);
    }

    public boolean allCellsInitialized() {
        int numberOfCellsShouldBeInitialized = maxWidth * maxHeight;
        return cells.size() == numberOfCellsShouldBeInitialized;
    }

    public Optional<Cell> searchValue(String value) {
        return cells.stream().filter(cell -> cell.value().equals(value)).findFirst();
    }
}
