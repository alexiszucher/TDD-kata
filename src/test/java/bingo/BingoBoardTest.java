package bingo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BingoBoardTest {
    BingoBoard board;

    @Test
    void anNewlyCreatedBoardIsNotInitialized() {
        board = new BingoBoard(1, 1);
        assertFalse(board.isInitialized());
    }

    @Test
    void whenAllFieldsAreSetTheBoarIsInitialized() {
        String anyValue = "42";
        board = new BingoBoard(1, 1);
        board.defineCell(0, 0, anyValue);
        assertTrue(board.isInitialized());
    }

    @Test
    void whenAllFieldsOnRectangularBoardAreSetItIsInitialized() {
        String one = "one, two, three";
        String two = "Bingo cells can contain any text";
        board = new BingoBoard(1, 2);
        board.defineCell(0, 0, one);
        board.defineCell(0, 1, two);
        assertTrue(board.isInitialized());
    }

    @Test
    void aDefinedCellCantBeRedefinedEvenIfItsTheSameValue() {
        String anyValue = "42";
        board = new BingoBoard(1, 1);
        board.defineCell(0, 0, anyValue);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> board.defineCell(0, 0, anyValue));
        Assertions.assertEquals(exception.getMessage(), "cell already defined");
    }

    @Test
    void duplicateCellsAreNotAllowed() {
        String anyValue = "42";
        board = new BingoBoard(2, 2);
        board.defineCell(0, 1, anyValue);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> board.defineCell(1, 0, anyValue));
        Assertions.assertEquals(exception.getMessage(), anyValue + " already present at 0,1");
    }

    @Test
    void aNonInitializedBoardCannotBeMarked() {
        board = new BingoBoard(1, 1);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> board.markCell(0, 0));
        Assertions.assertEquals(exception.getMessage(), "board not initialized");
    }

    @Test
    void whenAllCellGetsMarkedItIsMarked() {
        String anyValue = "42";
        board = new BingoBoard(1, 1);
        board.defineCell(0, 0, anyValue);
        board.markCell(0, 0);
        Assertions.assertTrue(board.isMarked(0, 0));
    }
}